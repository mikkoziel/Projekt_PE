package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public final class UserRepositoryImpl implements UserRepository {

    private final UserDatabase userDatabase;

    public UserRepositoryImpl(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public void saveUser(User user) {
        List<User> withUpdatedUser = userDatabase.read().stream()
                .map(processedUser -> (Objects.equals(processedUser.getUsername(), user.getUsername())) ? user : processedUser)
                .collect(toList());

        if (!withUpdatedUser.contains(user)) {
            withUpdatedUser.add(user);
        }

        userDatabase.save(withUpdatedUser);
    }

    @Override
    public User readUser(String username) {
        return userDatabase.read().stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst()
                .orElse(new User(username, new ArrayList<>()));
    }
}
