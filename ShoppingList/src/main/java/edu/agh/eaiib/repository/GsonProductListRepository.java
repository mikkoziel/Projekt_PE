package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GsonProductListRepository implements ProductListRepository {

    final static Gson gson = new Gson();
    public final String productsFileName;
    public GsonProductListRepository(String productsFileName) {
        this.productsFileName = productsFileName;
    }

    @Override
    public void save(ArrayList<User> users) {
        try (FileWriter writer = new FileWriter(productsFileName)) {
            Type listOfUsers = new TypeToken<ArrayList<User>>() {
            }.getType();
            gson.toJson(users, listOfUsers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductList read() {
        try (Reader reader = new FileReader(productsFileName)) {
            return gson.fromJson(reader, ProductList.class);
        } catch (FileNotFoundException e) {
            return new ProductList();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<User> readLists() {
        try (Reader reader = new FileReader(productsFileName)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<User>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUser(User user) {
        ArrayList<User> users = readLists();
        boolean userExists = false;
        if (users != null) {
            for (User u : users) {
                if (u.getUsername().equals(user.getUsername())) {
                    int index = users.indexOf(u);
                    users.set(index, user);
                    userExists = true;
                    break;
                }
            }

            if (!userExists) {
                users.add(user);
            }
        } else {
            users = new ArrayList<User>();
            users.add(user);
        }
        save(users);
    }

    public ArrayList<ProductList> readListsForUser(User user) {
        ArrayList<User> users = readLists();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                return u.getProductLists();
            }
        }
        return new ArrayList<ProductList>();

    }

    public ArrayList<ProductList> readAllListsForUser(User user) {
        ArrayList<User> users = readLists();
        ArrayList<ProductList> allProductLists = new ArrayList<ProductList>();
        for (User u : users) {
            ArrayList<ProductList> productLists = u.getProductLists();
            productLists.forEach(x -> {
                if (x.getCreatorName().equals(user.getUsername())) allProductLists.add(x);
            });
        }
        return allProductLists;
    }

    public User readUser(String username) {
        ArrayList<User> users = readLists();
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return new User(username);

    }
}
