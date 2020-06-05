package edu.agh.eaiib.service;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.UserRepository;

import java.util.List;

public class ProductListService {

    private final UserRepository repository;

    public ProductListService(UserRepository repository) {
        this.repository = repository;
    }

    public List<ProductList> getLists(User user) {
        return repository.readUser(user.getUsername()).getProductLists();
    }

    public void addProduct(Product product, ProductList list, User user) {
        user.addProductToList(product, list);
        repository.saveUser(user);
    }

    public void saveUser(User user) {
        repository.saveUser(user);
    }

    public User readUser(String username) {
        return repository.readUser(username);
    }
}
