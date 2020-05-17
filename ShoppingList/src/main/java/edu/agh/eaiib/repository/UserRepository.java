package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.User;

public interface UserRepository {
    void saveUser(User user);

    User readUser(String username);

}
