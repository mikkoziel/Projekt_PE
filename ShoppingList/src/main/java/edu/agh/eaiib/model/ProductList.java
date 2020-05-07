package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private String name;
    private String creatorName;
    private List<String> usersNames;
    private final List<Product> products;

    public ProductList(String name, String listCreatorName){
        this(name, listCreatorName, new ArrayList<Product>(), new ArrayList<String>());
    }

    public ProductList(String name, String listCreatorName, List<Product> products){
        this(name, listCreatorName, products, new ArrayList<String>());
    }

    public ProductList(String name, String listCreatorName, List<Product> products, List<String> users) {
        this.name = name;
        this.creatorName = listCreatorName;
        this.products = products;
        this.usersNames = users;
    }

    public String getName() {
        return name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<String> getUsers() { return usersNames; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        if (!name.equals(that.name)) return false;
        if (!creatorName.equals(that.creatorName)) return false;
        return products.equals(that.products);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + creatorName.hashCode();
        result = 31 * result + products.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "name='" + name + '\'' +
                ", username='" + creatorName + '\'' +
                ", products=" + products +
                '}';
    }
}
