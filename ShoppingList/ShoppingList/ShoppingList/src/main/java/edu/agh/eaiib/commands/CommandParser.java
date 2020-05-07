package edu.agh.eaiib.commands;

public class CommandParser {
    public static Command parse(String input) {
        if (input.isEmpty() || input.equals("help")) {
            System.out.println("Available commands:");
            System.out.println("login - changes the current user creating lists");
            System.out.println("add <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
            System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
            System.out.println("buy <productName> in <listName> - marks the product as bought");
        } else {
            String[] parts = input.split(" ");
            if (input.matches("login [A-Za-z1-9]+")) {

            } else if (input.matches("add [A-Za-z1-9]+ to [A-Za-z1-9]+")) {

            } else if (input.matches("create [A-Za-z1-9]+")) {
                return new CreateListCommand(parts[1]);
            } else if (input.matches("buy [A-Za-z1-9]+ in [A-Za-z1-9]+")) {

            }
        }
        return new NullCommand();
    }
}
