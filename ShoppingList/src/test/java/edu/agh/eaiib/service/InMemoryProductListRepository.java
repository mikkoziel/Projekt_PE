package edu.agh.eaiib.service;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.ProductListRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProductListRepository implements ProductListRepository {

    ProductList productList = new ProductList();
    List<User> list = new ArrayList<User>();
    List<ProductList> productLists = new ArrayList<ProductList>();
    User user = new User();

    @Override
    public void save(List<User> list) {
        this.list = list;
    }

    @Override
    public ProductList read() {
        return productList;
    }

    @Override
    public List<ProductList> readListsForUser(User user) {
        return productLists;
    }

    @Override
    public User readUser(String username) {
        return user;
    }

    @Override
    public void saveUser(User user) {

    }


}
