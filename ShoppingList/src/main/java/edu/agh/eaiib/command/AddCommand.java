package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;

public class AddCommand extends BaseCommand {

    private int amount;
    private String productName;
    private String listName;

    public AddCommand(String input, AppContext appContext){
        super(appContext);
        String tmp = input.replaceFirst("add ", "");
        amount = Integer.parseInt(tmp.substring(0, tmp.indexOf(" ")));
        tmp = tmp.replaceFirst("[0-9]+ ", "");
        productName = tmp.substring(0, tmp.indexOf(" "));
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ to ", "");
        listName = tmp;
    }

    @Override
    public void execute() {
        Product product = new Product(productName, amount);
        ProductList list = currentUser.findList(listName);
        if (list == null) {
            System.out.println("List of that name doesn't exist.\n" +
                    " First you must create list with that name.");
            return;
        }
        service.addProduct(product, list, currentUser);
    }
}
