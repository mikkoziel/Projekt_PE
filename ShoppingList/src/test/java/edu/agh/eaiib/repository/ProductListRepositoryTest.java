package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ProductListRepositoryTest {
    private final String filename = "products-test.json";
    ProductListRepository productListRepository = new GsonProductListRepository(filename);
    String username = "testUser";
    User user = new User(username);
    Product product1 = new Product("testName", 2);
    Product product2 = new Product("testName2", 6);
    Product product3 = new Product("testName3", 5);
    ProductList productList1 = new ProductList("listName", asList(product1, product2));
    ProductList productList2 = new ProductList("anotherListName", asList(product1, product3));

    @Test
    public void shouldSaveAndRetrieveProductList() {
        //given
        ProductList productList = productList1;
        User user = this.user;

        //when
        user.addProductList(productList);
        productListRepository.saveUser(user);
        User retrivedUser = productListRepository.readUser(user.getUsername());
        ProductList retrieved = retrivedUser.findList(productList.getListName());

        //then
        assertEquals(productList.toString(), retrieved.toString());
    }

    @Test
    public void shouldReplaceProductList() {
        //given
        User user = this.user;
        user.addProductList(productList1);
        productListRepository.saveUser(user);

        //when
        user.replacelist(productList1, productList2);
        productListRepository.saveUser(user);
        User retrievedUser = productListRepository.readUser(user.getUsername());
        ProductList retrieved = user.findList(productList2.getListName());

        //then
        assertEquals(productList2, retrieved);
    }
}
