package edu.agh.eaiib;

import edu.agh.eaiib.service.ProductListService;
import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

public class CommandParserTest extends TestCase {

    private CommandParser testObject = new CommandParser();

    @Override
    public void setUp() {
        testObject.service = mock(ProductListService.class);
    }
}