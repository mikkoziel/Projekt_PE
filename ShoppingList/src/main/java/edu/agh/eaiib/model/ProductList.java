package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList {

    private String name;
    private List<String> usersNames = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();

    public ProductList() {

    }

    public ProductList(String name, String creatorName) {
        this.name = name;
    }

    public ProductList(String name, String listCreatorName, List<Product> products) {
        this(name, listCreatorName);
        productList.addAll(products);
    }

    public String getName() {
        return name;
    }

    public List<String> getUsers() {
        return usersNames;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void buyProduct(String productName) {
        if (productList.size() > 0) {
            for (Product product : productList) {
                if (product.getName().equals(productName)) {
                    product.buyProduct();
                }
            }
            //System.out.println("No product by this name on this list");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(usersNames, that.usersNames)) return false;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (usersNames != null ? usersNames.hashCode() : 0);
        result = 31 * result + (productList != null ? productList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ProductList{" +
                "name='" + name + '\'' +
                ", users=[" + String.join(",", usersNames) + "]" +
                ", products=[");

        for (Product product : productList) {
            builder.append(product.toString()).append(",");
        }

        builder.append("]}'");
        return builder.toString();
    }
}
