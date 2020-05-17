package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.User;

import java.util.List;

public interface UserDatabase {
    void save(List<User> users);

    List<User> read();
}
