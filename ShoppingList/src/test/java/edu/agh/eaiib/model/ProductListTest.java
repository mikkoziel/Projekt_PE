package edu.agh.eaiib.model;

import org.junit.Test;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductListTest {

    @Test
    public void testEquals() {
        assertEquals(emptyList(), new ProductList("name", ""));
        assertNotEquals(new ProductList("name", ""), new ProductList("differentName", ""));
    }
}