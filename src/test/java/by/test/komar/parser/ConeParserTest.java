package by.test.komar.parser;

import by.task.komar.exception.ConeException;
import by.task.komar.parser.ConeParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeParserTest {

    @Test
    public void testParse() throws ConeException {
        ConeParser parser = new ConeParser();
        double[] actualArray = parser.parse("-2 5 -6.7 0.1 1.");
        double[] expectedArray = new double[5];
        expectedArray[0] = -2;
        expectedArray[1] = 5;
        expectedArray[2] = -6.7;
        expectedArray[3] = 0.1;
        expectedArray[4] = 1.;
        assertEquals(actualArray, expectedArray, 0.001, "Test failed as...");
    }

    @Test(expectedExceptions = ConeException.class)
    public void testParseException() throws ConeException {
        ConeParser parser = new ConeParser();
        double[] actualArray = parser.parse("1 2 3 0.01 -1");
    }
}