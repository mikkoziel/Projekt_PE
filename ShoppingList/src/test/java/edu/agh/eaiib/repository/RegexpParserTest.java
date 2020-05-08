package edu.agh.eaiib.repository;

import edu.agh.eaiib.model.ProductList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegexpParserTest {

    String regexp1 = "login [A-Za-z1-9]+";
    String regexp2 = "add [A-Za-z1-9]+ to [A-Za-z1-9]+";
    String regexp3 = "create [A-Za-z1-9]+";
    String regexp4 = "buy [A-Za-z1-9]+ in [A-Za-z1-9]+";
    String regexp5 = "user add [A-Za-z0-9]+ to [A-Za-z0-9]+";
    String regexp6 = "show [A-Za-z0-9]+";
    String regexp7 = "showAll";

    @Test
    public void testLoggingInParserWithProperString() {
        //given
        String inputString = "login ProjektList";

        //when
        Boolean result = inputString.matches(regexp1);

        //then
        assertTrue(result);
    }

    @Test
    public void testLoggingInParserWithImproperString() {
        //given
        String inputString = "login  ProjektList";

        //when
        Boolean result = inputString.matches(regexp1);

        //then
        assertTrue(!result);
    }

    @Test
    public void testLoggingInParserWithImproperStringVol2() {
        //given
        String inputString = "login;';'a';d\nProjektList";

        //when
        Boolean result = inputString.matches(regexp1);

        //then
        assertTrue(!result);
    }

    @Test
    public void testAddingProductsInParserWithProperString() {
        //given
        String inputString = "add Chocolate to list1";

        //when
        Boolean result = inputString.matches(regexp2);

        //then
        assertTrue(result);
    }

    @Test
    public void testAddingProductsInParserWithImproperString() {
        //given
        String inputString = "add Chocolate tolist1";

        //when
        Boolean result = inputString.matches(regexp2);

        //then
        assertTrue(!result);
    }

    @Test
    public void testAddingProductsInParserWithImproperStringVol2() {
        //given
        String inputString = "add Chocolate to\n;a.alist1";

        //when
        Boolean result = inputString.matches(regexp2);

        //then
        assertTrue(!result);
    }

    @Test
    public void testCreatingListParserWithProperString() {
        //given
        String inputString = "create MyFirstList";

        //when
        Boolean result = inputString.matches(regexp3);

        //then
        assertTrue(result);
    }

    @Test
    public void testCreatingListParserWithImproperString() {
        //given
        String inputString = "create _;asd;ad";

        //when
        Boolean result = inputString.matches(regexp3);

        //then
        assertTrue(!result);
    }

    @Test
    public void testCreatingListParserWithImproperStringVol2() {
        //given
        String inputString = "create\n\n _;asd;ad";

        //when
        Boolean result = inputString.matches(regexp3);

        //then
        assertTrue(!result);
    }

    @Test
    public void testBuyingPorductParserWithProperString() {
        //given
        String inputString = "buy Milk in List3";

        //when
        Boolean result = inputString.matches(regexp4);

        //then
        assertTrue(result);
    }

    @Test
    public void testBuyingProductParserWithImproperString() {
        //given
        String inputString = "buy in _;asd;ad";

        //when
        Boolean result = inputString.matches(regexp4);

        //then
        assertTrue(!result);
    }

    @Test
    public void testBuyingProductParserWithImproperStringVol2() {
        //given
        String inputString = "buy asdspadlpaslda in  asl dsa";

        //when
        Boolean result = inputString.matches(regexp4);

        //then
        assertTrue(!result);
    }

    @Test
    public void testAddingUserParserWithProperString(){
        String inputString = "user add testuser to testlist";

        boolean result = inputString.matches(regexp5);

        assertTrue(result);
    }

    @Test
    public void testAddingUserParserWithImproperString(){
        String inputString = "user dj add to ljhl";

        boolean result = inputString.matches(regexp5);

        assertTrue(!result);
    }

    @Test
    public void testShowinListInParserWithProperString() {
        //given
        String inputString = "show list1";

        //when
        Boolean result = inputString.matches(regexp6);

        //then
        assertTrue(result);
    }

    @Test
    public void testShowAllInParserWithProperString() {
        //given
        String inputString = "showAll";

        //when
        Boolean result = inputString.matches(regexp7);

        //then
        assertTrue(result);
    }
}
