package edu.agh.eaiib.commands;

import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.repository.ProductListRepository;

public abstract class Command {

    protected ProductListRepository productListRepository;

    protected Command() {
        //TODO: find a good way to inject this
        this.productListRepository = new GsonProductListRepository("todo.json");
    }

    public abstract void Execute(String username);
}
