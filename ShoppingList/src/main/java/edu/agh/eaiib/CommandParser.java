package edu.agh.eaiib;

import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.service.ProductListService;

public class CommandParser {

    static ProductListService service = new ProductListService(new GsonProductListRepository("database.json"));

    public void parse(String input) {
        if (input.isEmpty() || input.equals("help")) {
            System.out.println("Available commands:");
            System.out.println("login - changes the current user creating lists");
            System.out.println("add <number> <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
            System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
            System.out.println("buy <productName> in <listName> - marks the product as bought");
        } else {
            if (input.matches("login [A-Za-z0-9]+")) {

            } else if (input.matches("add [0-9]+ [A-Za-z0-9]+ to [A-Za-z0-9]+")) {

            } else if (input.matches("create [A-Za-z0-9]+")) {

            } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {

            }
        }
    }
}
