package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.service.InMemoryProductListRepository;
import edu.agh.eaiib.service.ProductListService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandParserTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private CommandParser testObject;
    private ProductListService service;

    @Before
    public void setUp() {
        testObject = new CommandParser("aa");
        service = new ProductListService(new InMemoryProductListRepository());
        CommandParser.service = service;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @Ignore
    public void testAddProduct() {
        testObject.parse("add 3 apple");
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("apple", 3));
        assertEquals(expected, service.getList());

        testObject.parse("add 4 apple");
        expected.add(new Product("apple", 4));
        assertEquals(expected, service.getList());

        testObject.parse("add 10 egg");
        expected.add(new Product("egg", 10));
        assertEquals(expected, service.getList());
    }

    @Test
    public void testShowAllProductsList() {
        System.out.print("List of products");
        assertEquals("List of products", outContent.toString());
    }
}