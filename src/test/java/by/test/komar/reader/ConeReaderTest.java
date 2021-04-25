package by.test.komar.reader;

import by.task.komar.exception.ConeException;
import by.task.komar.reader.ConeReader;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeReaderTest {

    @Test
    public void testReadFromFile() throws ConeException {
        ConeReader reader = new ConeReader();
        List<String> actualArray = reader.readFromFile("src\\main\\resources\\file\\figure.txt");
        List<String> expectedArray = new ArrayList<>();
        expectedArray.add("1 2 3 4 5");
        expectedArray.add("1.0 1.1 1.2 1.3 1.4");
        expectedArray.add("-1 -1 -1 1 1");
        assertEquals(actualArray, expectedArray, "Test failed as...");
    }

    @Test(expectedExceptions = ConeException.class)
    public void testReadFromFileException() throws ConeException {
        ConeReader reader = new ConeReader();
        List<String> actualArray = reader.readFromFile("path.txt");
    }

}

