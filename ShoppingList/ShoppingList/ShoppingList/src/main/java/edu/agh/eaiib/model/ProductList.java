package edu.agh.eaiib.model;

import java.util.List;

public class ProductList {
    private String name;
    private String username;
    private List<Product> products;

    public ProductList() {
    }

    public ProductList(String name, String username, List<Product> products) {
        this.name = name;
        this.username = username;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        if (!name.equals(that.name)) return false;
        if (!username.equals(that.username)) return false;
        return products.equals(that.products);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + products.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", products=" + products +
                '}';
    }
}
