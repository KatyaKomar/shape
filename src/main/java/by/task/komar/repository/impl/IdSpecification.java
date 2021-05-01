package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Specification;

public class IdSpecification implements Specification {
    private long nameId;

    public IdSpecification(long nameId) {
        this.nameId = nameId;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean isSpecified = cone.getConeId() == nameId;
        return isSpecified;
    }
}
