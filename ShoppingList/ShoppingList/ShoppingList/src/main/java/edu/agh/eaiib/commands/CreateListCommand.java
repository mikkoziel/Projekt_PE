package edu.agh.eaiib.commands;

import edu.agh.eaiib.model.ProductList;

public class CreateListCommand extends Command{

    private String listName;

    public CreateListCommand(String listName){
        super();
        this.listName = listName;
    }

    @Override
    public void Execute(String username) {
        ProductList newList = new ProductList(this.listName, username);
        productListRepository.save(newList);
    }
}
