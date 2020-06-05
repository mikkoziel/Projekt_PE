package edu.agh.eaiib.fixtures;

import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.repository.GsonUserConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCreateList {

    private String userName;
    private String listName;

    public boolean createList(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName);
        commandParser.parse("show " + listName);
        return out.toString().contains("List of products from " + listName + ":");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
