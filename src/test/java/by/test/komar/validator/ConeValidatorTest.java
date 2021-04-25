package by.test.komar.validator;

import by.task.komar.validator.ConeValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeValidatorTest {

    @Test
    public void testIsValidate() {
        String coneString = "2 5 -6.7 0.1 1.";
        boolean actual = ConeValidator.isValidate(coneString);
        assertTrue(actual, " Test failed as...");
    }

    @Test
    public void testIsValidateNegative() {
        String coneString = "2 -2 2 10 0.0";
        boolean actual = ConeValidator.isValidate(coneString);
        assertFalse(actual, " Test failed as...");
    }

    @Test
    public void testIsValidateLessParameters() {
        String coneString = "1 1 1 1";
        boolean actual = ConeValidator.isValidate(coneString);
        assertFalse(actual, " Test failed as...");
    }

    @Test
    public void testIsValidateMoreParameters() {
        String coneString = "-1 2 -3 4 5 6";
        boolean actual = ConeValidator.isValidate(coneString);
        assertFalse(actual, " Test failed as...");
    }

    @Test
    public void testIsValidateString() {
        String coneString = "one 2 3 four 5";
        boolean actual = ConeValidator.isValidate(coneString);
        assertFalse(actual, " Test failed as...");
    }
}