package by.task.komar.service;

import by.task.komar.entity.Cone;
import by.task.komar.entity.Point;
import by.task.komar.exception.ConeException;

public interface ConeCalculationService {
    double coneSurfaceArea(Cone cone);

    double coneVolume(Cone cone);

    double coneVolumeRatio(Cone cone, Point point) throws ConeException;

    boolean isCone(Point center, double radius, double height);

    boolean isBaseOnPlane(Cone cone);
}
