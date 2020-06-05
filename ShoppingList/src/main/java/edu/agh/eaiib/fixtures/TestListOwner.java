package edu.agh.eaiib.fixtures;

import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserConfiguration;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestListOwner {
    private String userName;
    private String listName;

    public boolean addListWithOwner() {
        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName);
        commandParser.parse("show " + listName);
        ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
        User user = service.readUser(userName);
        List<ProductList> lists = service.getLists(user);
        return lists.stream().anyMatch(o -> o.getUsersWithAccess().contains(userName));
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
