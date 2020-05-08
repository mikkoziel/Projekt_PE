package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

import java.util.ArrayList;

public interface ProductListRepository {
    void save(ArrayList<User> users);

    ProductList read();
    ArrayList<ProductList> readListsForUser(User user);
    ArrayList<ProductList> readAllListsForUser(User user);

    User readUser(String username);
    void saveUser(User user);
}
