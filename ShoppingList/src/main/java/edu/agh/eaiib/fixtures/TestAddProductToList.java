package edu.agh.eaiib.fixtures;

import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserConfiguration;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

public class TestAddProductToList {
    private String userName;
    private String listName;
    private String numberOfProducts;
    private String nameOfProduct;

    public boolean addProductToList() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName);
        commandParser.parse("show " + listName);
        commandParser.parse("add " + numberOfProducts + " " +  nameOfProduct + " to " + listName);
        ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
        User user = service.readUser(userName);
        List<ProductList> lists = service.getLists(user);
        ProductList containsList = lists.stream().filter(o -> o.getListName().equals(listName)).findFirst().get();
        return containsList.toString().contains(nameOfProduct);
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
