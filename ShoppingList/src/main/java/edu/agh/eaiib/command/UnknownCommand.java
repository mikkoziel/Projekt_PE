package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;

public class UnknownCommand extends BaseCommand {

    public UnknownCommand(AppContext appContext){
        super(appContext);
    }

    @Override
    public void execute() {
        System.out.println("Unknown command. Type 'help' for list of available commands");
    }
}
