package by.task.komar.comparator;

import by.task.komar.entity.Cone;
import by.task.komar.service.impl.CalculationServiceImpl;

import java.util.Comparator;

public class ConeVolumeComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        CalculationServiceImpl calculationService = new CalculationServiceImpl();
        double firstVolume = calculationService.coneVolume(o1);
        double secondVolume = calculationService.coneVolume(o2);
        int compare = Double.compare(firstVolume, secondVolume);
        return compare;
    }
}
