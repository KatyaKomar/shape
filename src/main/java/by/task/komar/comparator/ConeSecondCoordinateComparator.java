package by.task.komar.comparator;

import by.task.komar.entity.Cone;

import java.util.Comparator;

public class ConeSecondCoordinateComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int compare = Double.compare(o1.getCenter().getY(), o2.getCenter().getY());
        return compare;
    }
}
