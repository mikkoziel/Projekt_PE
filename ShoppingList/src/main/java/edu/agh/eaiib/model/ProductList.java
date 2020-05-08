package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class ProductList {

    private String listName;
    private List<Product> productList = new ArrayList<>();
    private List<String> usersWithAccess = new ArrayList<>();

    public ProductList() {

    }

    public ProductList(String listName) {
        this.listName = listName;
    }

    public ProductList(String listName, List<Product> products) {
        this(listName);
        productList.addAll(products);
    }

    public String getListName() {
        return listName;
    }

    public List<String> getUsersWithAccess() {
        return usersWithAccess;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void buyProduct(String productName) {
        productList = productList.stream().peek(product -> {
            if (product.getName().equals(productName)) {
                product.buyProduct();
            }
        }).collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductList that = (ProductList) o;

        if (!Objects.equals(listName, that.listName)) return false;
        if (!Objects.equals(usersWithAccess, that.usersWithAccess)) return false;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        int result = listName != null ? listName.hashCode() : 0;
        result = 31 * result + (usersWithAccess != null ? usersWithAccess.hashCode() : 0);
        result = 31 * result + (productList != null ? productList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ProductList{" +
                "name='" + listName + '\'' +
                ", users=[" + String.join(",", usersWithAccess) + "]" +
                ", products=[");

        for (Product product : productList) {
            builder.append(product.toString()).append(",");
        }

        builder.append("]}'");
        return builder.toString();
    }
}
