package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

import java.util.ArrayList;
import java.util.List;

public interface ProductListRepository {
    void save(List<User> users);

    List<ProductList> readListsForUser(User user);

    User readUser(String username);

    void saveUser(User user);
}
