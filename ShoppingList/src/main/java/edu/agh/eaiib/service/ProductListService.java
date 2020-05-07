package edu.agh.eaiib.service;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.ProductListRepository;

import java.util.ArrayList;

public class ProductListService {

    private final ProductListRepository repository;

    public ProductListService(ProductListRepository repository) {
        this.repository = repository;
    }

    public ProductList getList() {
        return repository.read();
    }

    public ArrayList<ProductList> getLists(User user) {
        return repository.readListsForUser(user);
    }

    public void addProduct(Product product, ProductList list, User user) {
        user.addProductToList(product, list);
        repository.saveUser(user);
    }

    public void saveUser(User user){
        repository.saveUser(user);
    }

    public User readUser(String username){
        return repository.readUser(username);
    }
}
