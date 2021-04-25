package by.task.komar.entity;

import by.task.komar.exception.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Logger logger = LogManager.getLogger();
    private Map<Long, ConeParameters> coneMap;
    private static Warehouse instance;

    private Warehouse() {
        this.coneMap = new HashMap<>();
    }

    public void put(Long coneId, ConeParameters parameters) {
        coneMap.put(coneId, parameters);
    }

    public ConeParameters remove(Long coneId) {
        ConeParameters parameters = coneMap.remove(coneId);
        return parameters;
    }

    public ConeParameters get(Long coneId) throws ConeException {
        ConeParameters parameters = coneMap.get(coneId);
        if (parameters == null) {
            logger.log(Level.ERROR, "There are no such element");
            throw new ConeException("There are no such element");
        }
        return parameters;
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }
}
