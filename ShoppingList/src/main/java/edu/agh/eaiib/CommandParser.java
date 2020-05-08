package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.service.ProductListService;

import java.util.ArrayList;

public class CommandParser {

    static ProductListService service = new ProductListService(new GsonProductListRepository("./database.json"));
    User user;

    public CommandParser(String username) {
        this.user = service.readUser(username);
    }

    public boolean parse(String input) {
        if (input.isEmpty() || input.equals("help")) {
            System.out.println("Available commands:");
            System.out.println("login - changes the current user creating lists");
            System.out.println("add <number> <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
            System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
            System.out.println("buy <productName> in <listName> - marks the product as bought");
            System.out.println("user add <username> to <listname> - gives user read rights to list");
            System.out.println("show <listname> - prints list with listname");
            System.out.println("showAll - prints all lists that user created");
        } else if (input.matches("login [A-Za-z0-9]+")) {
            String username = input.split(" ")[1];
            this.user = new User(username);
            System.out.println(String.format("New user logged in: %s", this.user.getUsername()));
        } else if (input.matches("add [0-9]+ [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            parseAdd(input);
        } else if (input.matches("create [A-Za-z0-9]+")) {
            parseCreate(input);
        } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {
            parseBuy(input);
        } else if (input.matches("user add [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            parseUserAdd(input);
        } else if (input.matches("show [A-Za-z0-9]+")) {
            parseShowList(input);
        } else if (input.matches("showAll")) {
            parseShowAll();
        } else return !input.matches("quit");
        return true;
    }

    private void parseAdd(String input) {
        String tmp = input.replaceFirst("add ", "");
        int amount = Integer.parseInt(tmp.substring(0, tmp.indexOf(" ")));
        tmp = tmp.replaceFirst("[0-9]+ ", "");
        String productName = tmp.substring(0, tmp.indexOf(" "));
        Product product = new Product(productName, amount);
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ to ", "");
        String listName = tmp;
        ProductList list = user.findList(listName);
        if (list == null) {
            System.out.println("List of that name doesn't exist.\n" +
                    " First you must create list with that name.");
            return;
        }
        service.addProduct(product, list, user);
    }

    private void parseCreate(String input) {
        String listName = input.replaceFirst("create ", "");
        ProductList list = new ProductList(listName, user.getUsername());
        user.addProductList(list);
        service.saveUser(user);
    }

    private void parseBuy(String input) {
        String tmp = input.replaceFirst("buy ", "");
        String productName = tmp.substring(0, tmp.indexOf(" "));
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ in ", "");
        String listName = tmp;
        ProductList list = user.findList(listName);
        if (list == null) {
            System.out.println("List of that name doesn't exist.\n" +
                    " First you must create list with that name.");
            return;
        }
        user.buyProductFromList(productName, list);
        service.saveUser(user);
    }

    private void parseUserAdd(String input) {
        String tmp = input.replaceFirst("user add ", "");
        String userName = tmp.substring(0, tmp.indexOf(" "));
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ to ", "");
        String listName = tmp;
        ProductList list = user.findList(listName);
        if (list == null) {
            System.out.println(String.format("List %s does not exists.", listName));
            return;
        }
        user.addUserToList(userName, list);
        service.saveUser(user);
    }

    private void parseShowList(String input) {
        String tmp = input.replaceFirst("show ", "");
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ ", "");
        String listName = tmp;
        ProductList list = user.findList(listName);

        if (list == null) {
            System.out.println("List of that name doesn't exist.\n" +
                    " First you must create list with that name.");
            return;
        }

        System.out.println("List of products from " + listName + ":");
        for (Product product : list.getProductList()) {
            System.out.println(product.getAmount() + " " + product.getName() + " bought: " + product.isBought());
        }
    }

    private void parseShowAll() {
        ArrayList<ProductList> lists = service.getLists(user);

        if (lists == null) {
            System.out.println("List doesn't exist.");
            return;
        }

        for (ProductList list : lists) {
            System.out.println("List of products from " + list.getName() + ":");
            for (Product product : list.getProductList()) {
                System.out.println(product.getAmount() + " " + product.getName() + " bought: " + product.isBought());
            }
        }
    }

}
