package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.ProductListRepository;

import java.util.ArrayList;

public class InMemoryProductListRepository implements ProductListRepository {

    ProductList productList = new ProductList();
    ArrayList<User> list = new ArrayList<User>();

    @Override
    public void save(ArrayList<User> list) {
        this.list = list;
    }

    @Override
    public ProductList read() {
        return productList;
    }

    @Override
    public ArrayList<ProductList> readListsForUser(User user) {
        return user.getProductLists();
    }

    @Override
    public User readUser(User user) {
        return user;
    }

    @Override
    public void saveUser(User user) {

    }


}
