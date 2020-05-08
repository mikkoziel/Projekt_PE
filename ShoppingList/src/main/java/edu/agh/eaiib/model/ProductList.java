package edu.agh.eaiib.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList {

    private String name;
    private String creatorName;
    private List<String> usersNames = new ArrayList<>();
    private ArrayList<Product> productList = new ArrayList<>();

    public ProductList() {

    }

    public ProductList(String name, String creatorName) {
        this.name = name;
        this.creatorName = creatorName;
    }

    public ProductList(String name, String listCreatorName, List<Product> products) {
        this(name, listCreatorName);
        productList.addAll(products);
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

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void buyProduct(String productName){
        if(productList.size() > 0){
            for(Product product: productList){
                if(product.getName().equals(productName)){
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
        StringBuilder builder = new StringBuilder("ProductList{" +
                "name='" + name + '\'' +
                ", users=[" + String.join(",", usersNames) + "]" +
                ", products=[");

        for (Product product: productList) {
            builder.append(product.toString()).append(",");
        }

        builder.append("]}'");
        return builder.toString();
    }
}
