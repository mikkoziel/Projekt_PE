package edu.agh.eaiib.fixtures;
import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestShowProductInList {
    private String userName;
    private String listName;
    private String numberOfProducts;
    private String nameOfProduct;

    public boolean checkIfProductIsPresented() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser();
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName);
        commandParser.parse("add " + numberOfProducts + " " +  nameOfProduct + " to " + listName);
        commandParser.parse("show " + listName);
        ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
        User user = service.readUser(userName);
        List<ProductList> lists = service.getLists(user);
        List<Product> selectedProductList = lists.stream().filter(o -> o.getListName().equals(listName)).findFirst().get().getProductList();

        String output;
        output = "List of products from " + listName + ":";
        System.out.println();
        for (Product product : selectedProductList) {
            output += product.getAmount() + " " + product.getName() + " bought: " + product.isBought();
        }

        return out.toString().contains(output);
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
