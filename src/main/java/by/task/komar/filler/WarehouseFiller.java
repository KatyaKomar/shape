package by.task.komar.filler;

import by.task.komar.entity.Cone;
import by.task.komar.entity.ConeParameters;
import by.task.komar.entity.Point;
import by.task.komar.entity.Warehouse;
import by.task.komar.exception.ConeException;
import by.task.komar.factory.ShapeFactory;
import by.task.komar.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseFiller {
    private static Logger logger = LogManager.getLogger();

    public void fillConeWarehouse(Cone cone) {
        long id = cone.getConeId();
        CalculationServiceImpl calculationService = new CalculationServiceImpl();
        double surfaceArea = calculationService.coneSurfaceArea(cone);
        double volume = calculationService.coneVolume(cone);
        ConeParameters parameters = new ConeParameters(surfaceArea, volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, parameters);
        logger.log(Level.INFO, "add cone " + cone + " to warehouse");
    }

    public void fillConeWarehouse(Point center, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(center, radius, height);
        fillConeWarehouse(cone);
    }

    public void fillConeWarehouse(double x, double y, double z, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(x, y, z, radius, height);
        fillConeWarehouse(cone);
    }

    public void fillConeWarehouse(double[] array) throws ConeException {
        Cone cone = ShapeFactory.createCone(array);
        fillConeWarehouse(cone);
    }
}
