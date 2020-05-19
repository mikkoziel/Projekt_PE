package edu.agh.eaiib.command;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

public class CreateCommand extends BaseCommand{

    private String listName;

    public CreateCommand(String input){
        listName = input.replaceFirst("create ", "");
    }

    @Override
    public void execute() {
        ProductList list = new ProductList(listName);
        currentUser.addProductList(list);
        service.saveUser(currentUser);
    }
}
