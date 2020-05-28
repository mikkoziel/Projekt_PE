package edu.agh.eaiib.command;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;

import java.util.List;

public class ShowAllCommand extends BaseCommand {

    @Override
    public void execute() {
        List<ProductList> lists = service.getLists(currentUser);

        if (lists == null) {
            System.out.println("List doesn't exist.");
            return;
        }

        for (ProductList list : lists) {
            System.out.println("List of products from " + list.getListName() + ":");
            for (Product product : list.getProductList()) {
                System.out.println(product.getAmount() + " " + product.getName() + " bought: " + product.isBought());
            }
        }
    }
}
