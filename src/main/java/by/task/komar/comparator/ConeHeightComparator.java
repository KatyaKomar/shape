package by.task.komar.comparator;

import by.task.komar.entity.Cone;

import java.util.Comparator;

public class ConeHeightComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int compare = Double.compare(o1.getHeight(), o2.getHeight());
        return compare;
    }
}
