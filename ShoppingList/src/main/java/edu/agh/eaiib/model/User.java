package edu.agh.eaiib.model;

import java.util.ArrayList;

public class User {
    String username;
    ArrayList<ProductList> productLists;

    public User(){

    }

    public User(String username){
        this.username = username;
        this.productLists = new ArrayList<ProductList>();;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<ProductList> getProductLists() {
        return productLists;
    }

    public void addProductList(ProductList list){
        productLists.add(list);
    }

    public ProductList findList(String listName){
        for(ProductList list: this.getProductLists()){
            if(list.getName().equals(listName)){
                return list;
            }
        }
        return null;
    }

    public void replacelist(ProductList list1, ProductList list2){
        int index = productLists.indexOf(list1);
        productLists.set(index, list2);

    }

    public void addProductToList(Product product, ProductList list){
        int index = productLists.indexOf(list);
        productLists.get(index).add(product);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("User{" +
                "username='" + username + '\'' +
                ", productsLists={");

        for(ProductList list: productLists) {
            string.append(list.toString()).append(", ");
        }
        string.append('}');

        return string.toString();
    }
}
