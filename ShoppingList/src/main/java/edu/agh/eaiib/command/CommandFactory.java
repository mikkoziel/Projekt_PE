package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;

public class CommandFactory {
    public static BaseCommand create(String input, AppContext appContext){
        if (input.isEmpty() || input.equals("help")) {
            return new HelpCommand(appContext);
        } else if (input.matches("login [A-Za-z0-9]+")) {
            return new LoginCommand(input, appContext);
        } else if (input.matches("add [0-9]+ [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            return new AddCommand(input, appContext);
        } else if (input.matches("create [A-Za-z0-9]+")) {
            return new CreateCommand(input, appContext);
        } else if (input.matches("buy [A-Za-z0-9]+ in [A-Za-z0-9]+")) {
            return new BuyCommand(input, appContext);
        } else if (input.matches("user add [A-Za-z0-9]+ to [A-Za-z0-9]+")) {
            return new AddUserCommand(input, appContext);
        } else if (input.matches("show [A-Za-z0-9]+")) {
            return new ShowListCommand(input, appContext);
        } else if (input.matches("showAll")) {
            return new ShowAllCommand(appContext);
        } else {
            return new UnknownCommand(appContext);
        }
    }
}
