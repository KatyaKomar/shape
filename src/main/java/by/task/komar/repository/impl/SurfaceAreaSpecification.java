package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Specification;
import by.task.komar.service.impl.CalculationServiceImpl;

public class SurfaceAreaSpecification implements Specification {
    private double minSurfaceArea;
    private double maxSurfaceArea;

    public SurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationServiceImpl calculationService = new CalculationServiceImpl();
        double surfaceArea = calculationService.coneSurfaceArea(cone);
        boolean isSpecified = (surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea);
        return isSpecified;
    }
}
