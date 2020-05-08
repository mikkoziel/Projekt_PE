package edu.agh.eaiib.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ProductListTest {

    @Test
    public void shouldMarkProductAsBought() {
        //given
        String product1Name = "testName";
        Product product1 = new Product(product1Name, 2, false);
        Product product2 = new Product("testName2", 6, false);
        ProductList productList = new ProductList("listName", asList(product1, product2));

        //when
        productList.buyProduct(product1Name);

        //then
        Product expectedProduct1 = new Product(product1Name, 2, true);
        ProductList expected = new ProductList("listName", asList(expectedProduct1, product2));

        assertEquals(expected, productList);
    }
}