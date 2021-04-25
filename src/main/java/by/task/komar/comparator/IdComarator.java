package by.task.komar.comparator;

import by.task.komar.entity.Cone;

import java.util.Comparator;

public class IdComarator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        int compare = Long.compare(o1.getConeId(), o2.getConeId());
        return compare;
    }
}
