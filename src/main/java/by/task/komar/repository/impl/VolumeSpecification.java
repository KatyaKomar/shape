package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Specification;
import by.task.komar.service.impl.CalculationServiceImpl;

public class VolumeSpecification implements Specification {
    private double minVolume;
    private double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationServiceImpl calculationService = new CalculationServiceImpl();
        double volume = calculationService.coneVolume(cone);
        boolean isSpecified = (volume >= minVolume && volume <= maxVolume);
        return isSpecified;
    }
}
