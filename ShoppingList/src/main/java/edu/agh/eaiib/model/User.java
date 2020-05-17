package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class User {
    private String username;
    private List<ProductList> productLists = new ArrayList<>();

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, List<ProductList> productLists) {
        this.username = username;
        this.productLists = productLists;
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
        return productLists.stream()
                .filter(list -> list.getListName().equals(listName))
                .findFirst()
                .orElse(null);
    }

    public void replaceList(ProductList list, ProductList replacement) {
        int index = productLists.indexOf(list);
        if (index != -1) {
            productLists.set(index, replacement);
        }
    }

    public void addProductToList(Product product, ProductList list) {
        doIfPresent(list, productList -> productList.getProductList().add(product));
    }

    public void buyProductFromList(String productName, ProductList list) {
        doIfPresent(list, productList -> productList.buyProduct(productName));
    }

    public void addUserToList(String username, ProductList list) {
        doIfPresent(list, productList -> productList.getUsersWithAccess().add(username));
    }

    private void doIfPresent(ProductList list, Consumer<ProductList> productListConsumer) {
        int index = productLists.indexOf(list);
        if (index != -1) {
            productListConsumer.accept(list);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return productLists != null ? productLists.equals(user.productLists) : user.productLists == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (productLists != null ? productLists.hashCode() : 0);
        return result;
    }
}
