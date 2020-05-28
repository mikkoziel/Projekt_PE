package edu.agh.eaiib.command;

public class LoginCommand extends BaseCommand {

    private String username;

    public LoginCommand(String input){
        username = input.split(" ")[1];
    }

    @Override
    public void execute() {
        appContext.setUser(username);
        System.out.println(String.format("New user logged in: %s", currentUser.getUsername()));
    }
}
