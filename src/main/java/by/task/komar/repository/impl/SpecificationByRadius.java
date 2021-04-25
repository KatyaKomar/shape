package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Specification;

public class SpecificationByRadius implements Specification {
    private double minRadius;
    private double maxRadius;

    public SpecificationByRadius(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean isSpecified = (cone.getRadius() >= minRadius && cone.getRadius() <= maxRadius);
        return isSpecified;
    }
}
