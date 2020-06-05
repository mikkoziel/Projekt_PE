package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;

public class HelpCommand extends BaseCommand {

    public HelpCommand(AppContext appContext){
        super(appContext);
    }

    @Override
    public void execute() {
        System.out.println("Available commands:");
        System.out.println("login - changes the current user creating lists");
        System.out.println("add <number> <productName> to <listName> - adds a product to the list, if the list doesn't exist, the system makes it with the specified entry");
        System.out.println("create <listName> - creates a list with the specified name and the user as the creator of the list");
        System.out.println("buy <productName> in <listName> - marks the product as bought");
        System.out.println("user add <username> to <listname> - gives user read rights to list");
        System.out.println("show <listname> - prints list with listname");
        System.out.println("showAll - prints all lists that user created");
    }
}
