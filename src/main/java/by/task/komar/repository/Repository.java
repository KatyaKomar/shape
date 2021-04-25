package by.task.komar.repository;

import by.task.komar.entity.Cone;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {
    void addCone(Cone cone);

    void addAllCone(Collection<Cone> cone);

    boolean removeCone(Cone cone);

    boolean removeAllCone(Collection<Cone> cone);

    List query(Specification specification);

    List sort(Comparator<? super Cone> comparator);
}
