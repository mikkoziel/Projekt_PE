package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.User;
import edu.agh.eaiib.service.InMemoryUserDatabase;
import org.junit.Before;
import org.junit.Test;

import static edu.agh.eaiib.TestDataSupport.exampleProductList;
import static edu.agh.eaiib.TestDataSupport.exampleProductList2;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    UserRepositoryImpl userRepository = new UserRepositoryImpl(new InMemoryUserDatabase());
    private final String username = "testUser";

    @Before
    public void setUp() {
        userRepository = new UserRepositoryImpl(new InMemoryUserDatabase());
    }

    @Test
    public void shouldSaveAndReadUser() {
        //given
        User user = new User(username, singletonList(exampleProductList()));

        //when
        userRepository.saveUser(user);
        User retrievedUser = userRepository.readUser(username);

        //then
        assertEquals(user, retrievedUser);
    }

    @Test
    public void shouldReplaceUser() {
        //given
        userRepository.saveUser(new User(username, singletonList(exampleProductList())));

        //when
        User updatedUser = new User(username, singletonList(exampleProductList2()));
        userRepository.saveUser(updatedUser);

        User retrievedUser = userRepository.readUser(username);

        //then
        assertEquals(updatedUser, retrievedUser);
    }

}
