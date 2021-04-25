package by.task.komar.service.impl;

import by.task.komar.entity.Cone;
import by.task.komar.entity.Point;
import by.task.komar.exception.ConeException;
import by.task.komar.service.ConeCalculationService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculationServiceImpl implements ConeCalculationService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public double coneSurfaceArea(Cone cone) {
        double circleArea = Math.PI * cone.getRadius() * cone.getRadius();
        double length = Math.sqrt(cone.getRadius() * cone.getRadius() + cone.getHeight() * cone.getHeight());
        double lateralSurfaceArea = Math.PI * cone.getRadius() * length;
        double coneSurfaceArea = circleArea + lateralSurfaceArea;
        logger.log(Level.INFO, "Surface area of cone " + cone.toString() + ": " + coneSurfaceArea);
        return coneSurfaceArea;
    }

    @Override
    public double coneVolume(Cone cone) {
        double coneVolume = Math.PI * cone.getRadius() * cone.getRadius() * cone.getHeight() / 3;
        logger.log(Level.INFO, "Volume of cone " + cone.toString() + ": " + coneVolume);
        return coneVolume;
    }

    @Override
    public double coneVolumeRatio(Cone cone, Point point) throws ConeException {
        if (point.getZ() <= cone.getCenter().getZ() || point.getZ() >= cone.getCenter().getZ() + cone.getHeight()) {
            throw new ConeException("There are no sections from point " + point.toString());
        } else {
            double secondHeight = point.getZ() - cone.getCenter().getZ();
            double firstHeight = cone.getHeight() - secondHeight;
            double firstRadius = firstHeight * cone.getRadius() / cone.getHeight();
            double firstConeVolume = coneVolume(new Cone(cone.getCenter(), firstRadius, firstHeight));
            double secondConeVolume = coneVolume(cone) - firstConeVolume;
            double coneVolumeRatio = firstConeVolume / secondConeVolume;
            logger.log(Level.INFO, "Volume ratio of cone " + cone.toString() + " and point " + point.toString() + ": " + coneVolumeRatio);
            return coneVolumeRatio;
        }
    }

    @Override
    public boolean isCone(Point center, double radius, double height) {
        boolean isCone = radius > 0 && height > 0;
        return isCone;
    }

    @Override
    public boolean isBaseOnPlane(Cone cone) {
        boolean isBaseOnPlane = cone.getCenter().getZ() == 0;
        return isBaseOnPlane;
    }
}
