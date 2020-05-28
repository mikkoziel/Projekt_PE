package edu.agh.eaiib;

import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

public class AppContext {
    private ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
    private User user;

    public void setUser(String username){
        user = getService().readUser(username);
    }

    public User getCurrentUser(){
        return user;
    }

    public ProductListService getService() {
        return service;
    }
}
