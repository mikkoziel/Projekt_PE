package edu.agh.eaiib.fixtures;
import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.repository.GsonUserConfiguration;

import java.io.*;

public class TestLogin {

    public TestLogin(){}

    private String userName;

    public boolean loginUser() throws FileNotFoundException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);

        return out.toString().contains("New user logged in: " + userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
