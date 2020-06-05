package edu.agh.eaiib;

import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.InMemoryUserDatabase;
import edu.agh.eaiib.service.ProductListService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CommandParserTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        ProductListService service = new ProductListService(new UserRepositoryImpl(new InMemoryUserDatabase()));
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testShowAllProductsList() {
        System.out.print("List of products");
        assertEquals("List of products", outContent.toString());
    }
}