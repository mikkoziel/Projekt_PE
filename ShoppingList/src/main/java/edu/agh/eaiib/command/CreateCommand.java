package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.ProductList;

public class CreateCommand extends BaseCommand{

    private String listName;

    public CreateCommand(String input, AppContext appContext){
        super(appContext);
        listName = input.replaceFirst("create ", "");
    }

    @Override
    public void execute() {
        if(currentUser.findList(listName) == null){
            ProductList list = new ProductList(listName);
            currentUser.addProductList(list);
            currentUser.addUserToList(currentUser.getUsername(), list);
            service.saveUser(currentUser);
        }
        else{
            System.out.println("List '" + listName + "' already exists. \n" +
                    "Use command show " + listName + "to show it content.");
        }
    }
}
