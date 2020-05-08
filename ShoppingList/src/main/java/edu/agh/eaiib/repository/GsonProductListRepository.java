package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class GsonProductListRepository implements ProductListRepository {

    final static Gson gson = new Gson();
    public final String productsFileName;

    public GsonProductListRepository(String productsFileName) {
        this.productsFileName = productsFileName;
    }

    @Override
    public void save(List<User> users) {
        try (FileWriter writer = new FileWriter(productsFileName)) {
            Type listOfUsers = new TypeToken<ArrayList<User>>() {
            }.getType();
            gson.toJson(users, listOfUsers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readLists() {
        try (Reader reader = new FileReader(productsFileName)) {
            List<User> users = gson.fromJson(reader, new TypeToken<ArrayList<User>>() {
            }.getType());
            return users == null ? new ArrayList<>() : users;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveUser(User user) {
        List<User> withUpdatedUser = readLists().stream()
                .map(processedUser -> (Objects.equals(processedUser.getUsername(), user.getUsername())) ? user : processedUser)
                .collect(toList());

        if (!withUpdatedUser.contains(user)) {
            withUpdatedUser.add(user);
        }

        save(withUpdatedUser);
    }

    public List<ProductList> readListsForUser(User user) {
        List<User> users = readLists();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                return u.getProductLists();
            }
        }
        return new ArrayList<>();

    }

    public User readUser(String username) {
        List<User> users = readLists();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return new User(username);

    }
}
