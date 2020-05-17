package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.ProductList;
import edu.agh.eaiib.model.User;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.eaiib.TestDataSupport.exampleProductList;
import static edu.agh.eaiib.TestDataSupport.exampleProductList2;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GsonUserDatabaseTest {
    private final String filename = "products-test.json";
    UserDatabase database = new GsonUserDatabase(filename);
    private final String username = "testUser";
    private final String username2 = "testUser2";

    @Test
    public void shouldReturnEmptyListIfCannotReadFromFile() {
        List<User> users = database.read();

        //then
        assertThat(users, is(new ArrayList<>()));
    }

    @Test
    public void shouldSaveAndRetrieveProductList() {
        //given
        User user = new User(username, singletonList(exampleProductList()));
        User user2 = new User(username2, singletonList(exampleProductList2()));

        //when
        List<User> users = asList(user, user2);
        database.save(users);
        List<User> retrievedUsers = database.read();

        //then
        assertThat(users, is(retrievedUsers));
    }

    @Test
    public void shouldReplaceProductList() {
        //given
        User user = new User(username, singletonList(exampleProductList()));
        User user2 = new User(username2);
        List<User> users = asList(user, user2);
        database.save(singletonList(user));

        //when
        ProductList addedProductList = exampleProductList2();
        user2.addProductList(addedProductList);
        database.save(users);

        List<User> retrievedUsers = database.read();

        //then
        assertThat(users, is(retrievedUsers));
    }

    @After
    public void tearDown() {
        database.save(new ArrayList<>());

    }

}