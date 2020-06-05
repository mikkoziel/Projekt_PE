package edu.agh.eaiib.fixtures;
import edu.agh.eaiib.CommandParser;
import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserConfiguration;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestBuyProduct {
    private String userName;
    private String listName;
    private String numberOfProducts;
    private String nameOfProduct;

    public boolean buyProductFromList() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandParser commandParser = new CommandParser(GsonUserConfiguration.defaultConfiguration);
        commandParser.parse("login " + userName);
        commandParser.parse("create " + listName);
        commandParser.parse("add " + numberOfProducts + " " +  nameOfProduct + " to " + listName);
        commandParser.parse("buy" + nameOfProduct + " in " + listName);
        ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
        User user = service.readUser(userName);
        List<ProductList> lists = service.getLists(user);
        List<Product> selectedProductList = lists.stream().filter(o -> o.getListName().equals(listName)).findFirst().get().getProductList();

        for (Product product: selectedProductList) {
            if (product.getName().equals(nameOfProduct)) {
                return product.isBought();
            }
        }
        return false;
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
