package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList extends ArrayList<Product> {

    private String name;
    private String creatorName;
    private List<String> usersNames = new ArrayList<>();

    public ProductList() {

    }

    public ProductList(String name, String creatorName) {
        this.name = name;
        this.creatorName = creatorName;
    }

    public ProductList(String name, String listCreatorName, List<Product> products) {
        this(name, listCreatorName);
        addAll(products);
    }

    public String getName() {
        return name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public List<String> getUsers() {
        return usersNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductList products = (ProductList) o;
        return Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "name='" + name + '\'' +
                '}';
    }
}
