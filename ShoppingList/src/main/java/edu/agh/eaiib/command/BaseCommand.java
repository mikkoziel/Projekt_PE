package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.service.ProductListService;

public class BaseCommand {
    AppContext appContext;
    User currentUser;
    ProductListService service;

    public BaseCommand(AppContext appContext){
        this.appContext = appContext;
        this.currentUser = appContext.getCurrentUser();
        this.service = appContext.getService();
    }

    public void execute(){

    }
}
