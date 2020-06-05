package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.ProductList;

public class BuyCommand extends BaseCommand {

    private String productName;
    private String listName;

    public BuyCommand(String input, AppContext appContext){
        super(appContext);
        String tmp = input.replaceFirst("buy ", "");
        productName = tmp.substring(0, tmp.indexOf(" "));
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ in ", "");
        listName = tmp;
    }

    @Override
    public void execute() {
        ProductList list = currentUser.findList(listName);
        if (list == null) {
            System.out.println("List of that name doesn't exist.\n" +
                    " First you must create list with that name.");
            return;
        }
        currentUser.buyProductFromList(productName, list);
        service.saveUser(currentUser);
    }
}
