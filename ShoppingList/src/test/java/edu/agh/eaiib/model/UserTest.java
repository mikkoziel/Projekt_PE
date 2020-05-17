package edu.agh.eaiib.model;

import org.junit.Test;

import static edu.agh.eaiib.TestDataSupport.exampleProductList;
import static edu.agh.eaiib.TestDataSupport.exampleProductList2;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldFindList() {
        //given
        User user = new User("testUser");
        ProductList list = exampleProductList();
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
        ProductList list = exampleProductList();

        //when
        ProductList found = user.findList(list.getListName());

        //then
        assertNull(found);
    }

    @Test
    public void shouldReplaceList() {
        //given
        User user = new User("testUser");
        ProductList list = exampleProductList();
        ProductList replacement = exampleProductList2();
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
        ProductList existingList = exampleProductList();
        ProductList replacement = exampleProductList2();
        user.addProductList(existingList);

        //when
        user.replaceList(exampleProductList(), replacement);

        //then
        assertNull(user.findList(replacement.getListName()));
        assertEquals(existingList, user.findList(existingList.getListName()));
    }


    @Test
    public void shouldMarkProductAsBought() {
        //given
        User user = new User("testUser");
        ProductList list = exampleProductList();
        ProductList list2 = exampleProductList();
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
        ProductList list = exampleProductList();
        user.addProductList(list);

        //when
        String anotherTestUser = "anotherTestUser";
        user.addUserToList(anotherTestUser, list);

        //then
        assertTrue(user.findList(list.getListName()).getUsersWithAccess().contains(anotherTestUser));
    }
}