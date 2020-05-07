package edu.agh.eaiib.commands;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.service.ProductListService;

public class CreateListCommand implements Command{

    private String listName;
    private ProductListService productListService;

    public CreateListCommand(ProductListService productListService){
        this.productListService = productListService;
    }

    @Override
    public void Execute(String username) {
        ProductList newList = new ProductList(this.listName, username);
        productListService.createList(newList);
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
