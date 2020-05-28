package edu.agh.eaiib.command;

public class CommandFactory {
    public static BaseCommand create(String input){
        if (input.isEmpty() || input.equals("help")) {
            return new HelpCommand();
        } else if (input.matches("login [A-Za-z0-9]+")) {
            return new LoginCommand(input);
        } else if (input.matches("add [0-9]+ [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            return new AddCommand(input);
        } else if (input.matches("create [A-Za-z0-9]+")) {
            return new CreateCommand(input);
        } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {
            return new BuyCommand(input);
        } else if (input.matches("user add [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            return new AddUserCommand(input);
        } else if (input.matches("show [A-Za-z0-9]+")) {
            return new ShowListCommand(input);
        } else if (input.matches("showAll")) {
            return new ShowAllCommand();
        } else {
            return new UnknownCommand();
        }
    }
}
