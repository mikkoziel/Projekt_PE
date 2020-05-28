package edu.agh.eaiib.command;

public class UnknownCommand extends BaseCommand {

    @Override
    public void execute() {
        System.out.println("Unknown command. Type 'help' for list of available commands");
    }
}
