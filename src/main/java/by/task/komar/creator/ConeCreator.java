package by.task.komar.creator;

import by.task.komar.entity.Cone;
import by.task.komar.entity.ConeParameters;
import by.task.komar.entity.Point;
import by.task.komar.entity.Warehouse;
import by.task.komar.exception.ConeException;
import by.task.komar.factory.ShapeFactory;
import by.task.komar.repository.impl.ConeRepository;
import by.task.komar.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCreator {
    private static Logger logger = LogManager.getLogger();

    public void addConeToRepository(Point center, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(center, radius, height);
        createWarehouse(cone);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        logger.log(Level.INFO, "add cone " + cone.toString() + " to repository");
    }

    public void addConeToRepository(double x, double y, double z, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(x, y, z, radius, height);
        createWarehouse(cone);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        logger.log(Level.INFO, "add cone " + cone.toString() + " to repository");
    }

    public void addConeToRepository(double[] array) throws ConeException {
        Cone cone = ShapeFactory.createCone(array);
        createWarehouse(cone);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        logger.log(Level.INFO, "add cone " + cone.toString() + " to repository");
    }

    private void createWarehouse(Cone cone) {
        long id = cone.getConeId();
        CalculationServiceImpl calculationService = new CalculationServiceImpl();
        double surfaceArea = calculationService.coneSurfaceArea(cone);
        double volume = calculationService.coneVolume(cone);
        ConeParameters parameters = new ConeParameters(surfaceArea, volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, parameters);
    }
}
