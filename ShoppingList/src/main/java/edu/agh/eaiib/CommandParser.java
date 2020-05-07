package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.service.ProductListService;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    static ProductListService service = new ProductListService(new GsonProductListRepository("database.json"));
    String username = new String();
    List<ProductList> lists = new ArrayList<ProductList>();

    public CommandParser(String username) {
        this.username = username;
    }

    public void parse(String input) {
        if (input.isEmpty() || input.equals("help")) {
            System.out.println("Available commands:");
            System.out.println("login - changes the current user creating lists");
            System.out.println("add <number> <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
            System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
            System.out.println("buy <productName> in <listName> - marks the product as bought");
        } else if (input.matches("login [A-Za-z0-9]+")) {
            this.username = input.split(" ")[1];
            System.out.println(String.format("New user logged in: %s", this.username));
            printListLists();
        } else if (input.matches("add [0-9]+ [A-Za-z0-9]+")) {
            parseAdd(input);
        } else if (input.matches("create [A-Za-z0-9]+")) {
          
        } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {

        }
    }

    private void parseAdd(String input) {
        int amount = Integer.parseInt(input.replaceFirst("add ", "")
                .replaceFirst(" [A-Za-z0-9]+", ""));
        String productName = input.replaceFirst("add [0-9]+ ", "");
        Product product = new Product(productName, amount);
        service.addProduct(product);
    }

    private void printListLists(){

        return;
    }
}
