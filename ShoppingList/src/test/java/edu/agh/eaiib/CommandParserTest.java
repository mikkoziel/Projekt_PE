package edu.agh.eaiib;

import edu.agh.eaiib.model.Product;
import edu.agh.eaiib.service.InMemoryProductListRepository;
import edu.agh.eaiib.service.ProductListService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
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
        List<Product> expected = singletonList(new Product("apple", 3));
        assertEquals(expected, service.getList());
    }
}