package by.task.komar.filler;

import by.task.komar.entity.Cone;
import by.task.komar.entity.Point;
import by.task.komar.exception.ConeException;
import by.task.komar.factory.ShapeFactory;
import by.task.komar.repository.impl.ConeRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepositoryFiller {
    private static Logger logger = LogManager.getLogger();

    public void fillConeRepository(Point center, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(center, radius, height);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillConeWarehouse(cone);
        logger.log(Level.INFO, "add cone " + cone + " to repository");
    }

    public void fillConeRepository(double x, double y, double z, double radius, double height) throws ConeException {
        Cone cone = ShapeFactory.createCone(x, y, z, radius, height);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillConeWarehouse(cone);
        logger.log(Level.INFO, "add cone " + cone + " to repository");
    }

    public void fillConeRepository(double[] array) throws ConeException {
        Cone cone = ShapeFactory.createCone(array);
        ConeRepository repository = ConeRepository.getInstance();
        repository.addCone(cone);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillConeWarehouse(cone);
        logger.log(Level.INFO, "add cone " + cone + " to repository");
    }
}
