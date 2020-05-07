package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ProductListRepositoryTest {
    private final String filename = "products-test.json";
    ProductListRepository productListRepository =  new GsonProductListRepository(filename);

    Product product1 = new Product("testName", 2);
    Product product2 = new Product("testName2", 6);
    Product product3 = new Product("testName3", 5);
    ProductList productList1 = new ProductList("listName", "testUserName", asList(product1, product2));
    ProductList productList2 = new ProductList("anotherListName", "anotherUserName", asList(product1, product3));

    @Test
    public void shouldSaveAndRetrieveProductList() {
        //given
        ProductList productList = productList1;

        //when
        productListRepository.save(productList);
        ProductList retrieved = productListRepository.read();

        //then
        assertEquals(productList, retrieved);
    }

    @Test
    public void shouldReplaceProductList() {
        //given
        productListRepository.save(productList1);

        //when
        productListRepository.save(productList2);
        ProductList retrieved = productListRepository.read();

        //then
        assertEquals(productList2, retrieved);
    }
}
