package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;

import java.util.List;

public class ShowAllCommand extends BaseCommand {

    public ShowAllCommand(AppContext appContext){
        super(appContext);
    }

    @Override
    public void execute() {
        List<ProductList> lists = service.getLists(currentUser);

        if (lists == null || lists.size() == 0) {
            System.out.println("No lists for this user.");
            return;
        }

        for (ProductList list : lists) {
            System.out.println("List of products from " + list.getListName() + ":");
            if(list.getProductListSize() != 0) {
                for (Product product : list.getProductList()) {
                    System.out.println("\t" + product.getAmount() + " " + product.getName() + " bought: " + product.isBought());
                }
            }else{
                System.out.println("\tNo products");
            }
        }
    }
}
