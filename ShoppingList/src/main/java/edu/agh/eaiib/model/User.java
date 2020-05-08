package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    List<ProductList> productLists;

    public User() {

    }

    public User(String username) {
        this.username = username;
        this.productLists = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<ProductList> getProductLists() {
        return productLists;
    }

    public void addProductList(ProductList list) {
        productLists.add(list);
    }

    public ProductList findList(String listName) {
        for (ProductList list : this.getProductLists()) {
            if (list.getName().equals(listName)) {
                return list;
            }
        }
        return null;
    }

    public void replacelist(ProductList list1, ProductList list2) {
        int index = productLists.indexOf(list1);
        productLists.set(index, list2);

    }

    public void addProductToList(Product product, ProductList list) {
        int index = productLists.indexOf(list);
        productLists.get(index).getProductList().add(product);
    }

    public void buyProductFromList(String productName, ProductList list) {
        int index = productLists.indexOf(list);
        productLists.get(index).buyProduct(productName);
    }

    public void addUserToList(String username, ProductList list) {
        int index = productLists.indexOf(list);
        productLists.get(index).getUsers().add(username);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("User{" +
                "username='" + username + '\'' +
                ", productsLists={");

        for (ProductList list : productLists) {
            string.append(list.toString()).append(", ");
        }
        string.append('}');

        return string.toString();
    }
}
