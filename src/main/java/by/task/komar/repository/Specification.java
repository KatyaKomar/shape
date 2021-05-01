package by.task.komar.repository;

import by.task.komar.entity.Cone;

@FunctionalInterface
public interface Specification {
    boolean specify(Cone cone);
}
