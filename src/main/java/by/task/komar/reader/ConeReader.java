package by.task.komar.reader;

import by.task.komar.exception.ConeException;
import by.task.komar.validator.ConeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ConeReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String filename) throws ConeException {
        List<String> lines;
        Path path = Paths.get(filename);
        try {
            lines = Files.lines(path).filter(ConeValidator::isValidate).collect(Collectors.toList());
        } catch (IOException ex) {
            logger.log(Level.ERROR, "Incorrect filename " + filename);
            throw new ConeException("Incorrect filename " + filename);
        }
        logger.log(Level.INFO, "This lines " + lines + " are correct");
        return lines;
    }

}
