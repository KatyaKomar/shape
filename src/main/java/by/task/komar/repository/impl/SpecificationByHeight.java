package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Specification;

public class SpecificationByHeight implements Specification {
    private double minHeight;
    private double maxHeight;

    public SpecificationByHeight(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean isSpecified = (cone.getHeight() >= minHeight && cone.getHeight() <= maxHeight);
        return isSpecified;
    }
}
