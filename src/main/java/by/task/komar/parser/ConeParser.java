package by.task.komar.parser;

import by.task.komar.exception.ConeException;
import by.task.komar.validator.ConeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeParser {
    private static Logger logger = LogManager.getLogger();
    private final String SPACE = "\\s+";

    public double[] parse(String string) throws ConeException {
        ConeValidator validator = new ConeValidator();
        if (validator.isValidate(string)) {
            String[] value = string.split(SPACE);
            double[] array = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                array[i] = Double.parseDouble(value[i]);
            }
            return array;
        } else {
            logger.log(Level.ERROR, "This line isn't correct");
            throw new ConeException("This line isn't correct");
        }
    }
}
