package by.task.komar.comparator;

import by.task.komar.entity.Cone;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int compare = Double.compare(o1.getRadius(), o2.getRadius());
        return compare;
    }
}
