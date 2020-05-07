package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;

import java.io.*;
import java.util.ArrayList;

public class GsonProductListRepository implements ProductListRepository {

    public GsonProductListRepository(String productsFileName) {
        this.productsFileName = productsFileName;
    }

    final static Gson gson = new Gson();
    public final String productsFileName;

    @Override
    public void save(ArrayList<User> users) {
        try (FileWriter writer = new FileWriter(productsFileName)) {
            gson.toJson(users, writer);
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

    public ArrayList<User> readLists(){
        try (Reader reader = new FileReader(productsFileName)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<User>>() {}.getType());
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveUser(User user){
        ArrayList<User> users = readLists();
        for(User u: users){
            if(u.getUsername().equals(user.getUsername())){
                int index = users.indexOf(u);
                users.set(index, user);
                break;
            }
        }
        save(users);
    }

    public ArrayList<ProductList> readListsForUser(User user){
        ArrayList<User> users = readLists();
        for(User u: users){
            if(u.getUsername().equals(user.getUsername())){
                return u.getProductLists();
            }
        }
        return new ArrayList<ProductList>();

    }

    public User readUser(User user){
        ArrayList<User> users = readLists();
        for(User u: users){
            if(u.getUsername().equals(user.getUsername())){
                return u;
            }
        }
        return new User();

    }
}
