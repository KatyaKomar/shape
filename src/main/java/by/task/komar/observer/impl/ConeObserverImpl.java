package by.task.komar.observer.impl;

import by.task.komar.entity.Cone;
import by.task.komar.entity.ConeParameters;
import by.task.komar.entity.Warehouse;
import by.task.komar.exception.ConeException;
import by.task.komar.observer.ConeEvent;
import by.task.komar.observer.ConeObserver;
import by.task.komar.service.impl.CalculationServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserverImpl implements ConeObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateVolume(ConeEvent coneEvent) throws ConeException {
        Cone cone = coneEvent.getSource();
        long id = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        ConeParameters parameters = warehouse.get(id);
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        double volume = calculation.coneVolume(cone);
        parameters.setVolume(volume);
        logger.log(Level.INFO, "update volume in cone " + cone);
    }

    @Override
    public void updateSurfaceArea(ConeEvent coneEvent) throws ConeException {
        Cone cone = coneEvent.getSource();
        long id = cone.getConeId();
        Warehouse warehouse = Warehouse.getInstance();
        ConeParameters parameters = warehouse.get(id);
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        double surfaceArea = calculation.coneSurfaceArea(cone);
        parameters.setSurfaceArea(surfaceArea);
        logger.log(Level.INFO, "update surface area in cone " + cone);
    }
}
