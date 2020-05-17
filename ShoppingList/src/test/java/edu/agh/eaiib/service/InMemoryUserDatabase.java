package edu.agh.eaiib.service;

import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDatabase implements UserDatabase {

    List<User> users = new ArrayList<>();

    @Override
    public void save(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> read() {
        return users;
    }
}
