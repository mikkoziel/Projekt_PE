package edu.agh.eaiib.model;

import java.util.ArrayList;

public class ProductList extends ArrayList<Product> {
    private String name;

    public ProductList(String name) {
        this.name = name;
    }
}
