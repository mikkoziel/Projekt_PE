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

public class TestCreateMultipleLists {
    private String userName;
    private String listName1;
    private String listName2;

    public boolean addMultipleLists() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName1);
        commandParser.parse("create " + listName2);
        ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
        User user = service.readUser(userName);
        List<ProductList> lists = service.getLists(user);
        Boolean containsList1 = lists.stream().anyMatch(o -> o.getListName().equals(listName1));
        Boolean containsList2 = lists.stream().anyMatch(o -> o.getListName().equals(listName2));
        return containsList1 && containsList2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getListName2() {
        return listName2;
    }

    public void setListName2(String listName) {
        this.listName2 = listName;
    }

    public String getListName1() {
        return listName1;
    }

    public void setListName1(String listName) {
        this.listName1 = listName;
    }
}
