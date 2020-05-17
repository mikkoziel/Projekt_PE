package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.agh.eaiib.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class GsonUserDatabase implements UserDatabase {
    final static Gson gson = new Gson();
    private final String productsFileName;

    public GsonUserDatabase(String productsFileName) {
        this.productsFileName = productsFileName;
    }

    @Override
    public void save(List<User> users) {
        try (FileWriter writer = new FileWriter(productsFileName)) {
            Type listOfUsers = new TypeToken<List<User>>() {}.getType();
            gson.toJson(users, listOfUsers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> read() {
        try (Reader reader = new FileReader(productsFileName)) {
            List<User> users = gson.fromJson(reader, new TypeToken<List<User>>() {}.getType());
            return users == null ? new ArrayList<>() : users;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
