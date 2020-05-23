package edu.agh.eaiib.fixtures;

import edu.agh.eaiib.CommandParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestLogin {

    public TestLogin(){}

    private String userName;

    public boolean loginUser(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser();
        commandParser.parse("login " + userName);
        return out.toString().contains("Logged in as: " + userName);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
