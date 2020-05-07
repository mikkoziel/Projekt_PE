package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.service.ProductListService;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    static ProductListService service = new ProductListService(new GsonProductListRepository("database.json"));
    User user;

    public CommandParser(String username) {
        this.user = new User(username);
    }

    public void parse(String input) {
        if (input.isEmpty() || input.equals("help")) {
            System.out.println("Available commands:");
            System.out.println("login - changes the current user creating lists");
            System.out.println("add <number> <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
            System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
            System.out.println("buy <productName> in <listName> - marks the product as bought");
        } else if (input.matches("login [A-Za-z0-9]+")) {
            String username = input.split(" ")[1];
            this.user = new User(username);
            System.out.println(String.format("New user logged in: %s", this.user.getUsername()));
        } else if (input.matches("add [0-9]+ [A-Za-z0-9]+")) {
            parseAdd(input);
        } else if (input.matches("create [A-Za-z0-9]+")) {
            parseCreate(input);
        } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {

        }
    }

    private void parseAdd(String input) {
        int amount = Integer.parseInt(input.replaceFirst("add ", "")
                .replaceFirst(" [A-Za-z0-9]+", ""));
        String productName = input.replaceFirst("add [0-9]+ ", "");
        Product product = new Product(productName, amount);
        String listName = input.replaceFirst("[A-Za-z0-9]+ to ", "");
        ProductList list = user.findList(listName);
        if (list == null){
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

}
