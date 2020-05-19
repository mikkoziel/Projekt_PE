package edu.agh.eaiib.command;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;

public class ShowListCommand extends BaseCommand {

    private String listName;

    public ShowListCommand(String input){
        String tmp = input.replaceFirst("show ", "");
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ ", "");
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

        System.out.println("List of products from " + listName + ":");
        for (Product product : list.getProductList()) {
            System.out.println(product.getAmount() + " " + product.getName() + " bought: " + product.isBought());
        }
    }
}
