package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;

public class LoginCommand extends BaseCommand {

    private String username;

    public LoginCommand(String input, AppContext appContext){
        super(appContext);
        username = input.split(" ")[1];
    }

    @Override
    public void execute() {
        appContext.setUser(username);
        currentUser = appContext.getCurrentUser();
        System.out.println(String.format("New user logged in: %s", currentUser.getUsername()));
    }
}
