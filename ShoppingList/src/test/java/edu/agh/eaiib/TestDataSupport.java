package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;

import java.util.Random;

import static java.util.Arrays.asList;

public class TestDataSupport {

    public static ProductList exampleProductList() {
        return new ProductList(
                "listName",
                asList(
                        new Product("testProductName", new Random().nextInt(), false),
                        new Product("testProductName2", 6, false)
                ));
    }

    public static ProductList exampleProductList2() {
        return new ProductList(
                "listName2",
                asList(
                        new Product("testProductName", new Random().nextInt(), false),
                        new Product("testProductName2", 6, false)
                ));
    }
}
