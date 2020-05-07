package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.service.InMemoryProductListRepository;
import edu.agh.eaiib.service.ProductListService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommandParserTest {

    private CommandParser testObject;
    private ProductListService service;

    @Before
    public void setUp() {
        testObject = new CommandParser();
        service = new ProductListService(new InMemoryProductListRepository());
        CommandParser.service = service;
    }

    @Test
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
}