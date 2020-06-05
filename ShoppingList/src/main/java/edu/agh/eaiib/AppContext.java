package edu.agh.eaiib;

import edu.agh.eaiib.model.User;
import edu.agh.eaiib.service.ProductListService;

public class AppContext {
    private ProductListService service;
    private User user;

    public AppContext(ProductListService service, String username){
        this.service = service;
        this.setUser(username);
    }

    public void setUser(String username){
        this.user = getService().readUser(username);
    }


    public User getCurrentUser(){
        return user;
    }

    public ProductListService getService() {
        return service;
    }
}
