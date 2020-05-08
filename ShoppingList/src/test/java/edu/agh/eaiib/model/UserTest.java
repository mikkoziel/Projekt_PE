package edu.agh.eaiib.model;

import org.junit.Test;

import java.util.Random;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldFindList() {
        //given
        User user = new User("testUser");
        ProductList list = exampleList();
        user.addProductList(list);

        //when
        ProductList found = user.findList(list.getListName());

        //then
        assertEquals(list, found);
    }

    @Test
    public void shouldReturnNullIfListNotFound() {
        //given
        User user = new User("testUser");
        ProductList list = exampleList();

        //when
        ProductList found = user.findList(list.getListName());

        //then
        assertNull(found);
    }

    @Test
    public void shouldReplaceList() {
        //given
        User user = new User("testUser");
        ProductList list = exampleList();
        ProductList replacement = exampleList();
        user.addProductList(list);

        //when
        user.replaceList(list, replacement);
        ProductList found = user.findList(replacement.getListName());

        //then
        assertEquals(replacement, found);
    }

    @Test
    public void shouldDoNothingWhenReplacingNonExistingList() {
        //given
        User user = new User("testUser");
        ProductList existingList = exampleList();
        ProductList replacement = exampleList();
        user.addProductList(existingList);

        //when
        user.replaceList(exampleList(), replacement);

        //then
        assertNull(user.findList(replacement.getListName()));
        assertEquals(existingList, user.findList(existingList.getListName()));
    }


    @Test
    public void shouldMarkProductAsBought() {
        //given
        User user = new User("testUser");
        ProductList list = exampleList();
        ProductList list2 = exampleList();
        user.addProductList(list);
        user.addProductList(list2);

        //when
        user.buyProductFromList("testProductName", list);

        //then
        assertTrue(user.findList(list.getListName()).getProductList().get(0).isBought());
        assertNotNull(user.findList(list2.getListName()));
    }

    @Test
    public void addUserToList() {
        //given
        User user = new User("testUser");
        ProductList list = exampleList();
        user.addProductList(list);

        //when
        String anotherTestUser = "anotherTestUser";
        user.addUserToList(anotherTestUser, list);

        //then
        assertTrue(user.findList(list.getListName()).getUsersWithAccess().contains(anotherTestUser));
    }

    private ProductList exampleList() {
        return new ProductList(
                "listName",
                asList(
                        new Product("testProductName", new Random().nextInt(), false),
                        new Product("testProductName2", 6, false)
                ));
    }
}