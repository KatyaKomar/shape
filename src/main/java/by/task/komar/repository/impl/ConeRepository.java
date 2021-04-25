package by.task.komar.repository.impl;

import by.task.komar.entity.Cone;
import by.task.komar.repository.Repository;
import by.task.komar.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository implements Repository {
    private static Logger logger = LogManager.getLogger();
    private List<Cone> cones;
    private static ConeRepository instance;

    public List<Cone> getCones() {
        return cones;
    }

    public Cone get(int index) {
        return cones.get(index);
    }

    public int size() {
        return cones.size();
    }

    public static ConeRepository getInstance() {
        if (instance == null) {
            instance = new ConeRepository();
        }
        return instance;
    }

    public ConeRepository() {
        cones = new ArrayList<>();
    }

    @Override
    public void addCone(Cone cone) {
        cones.add(cone);
        logger.log(Level.INFO, "New cone in repository: " + cone);
    }

    @Override
    public void addAllCone(Collection<Cone> cone) {
        cones.addAll(cone);
        logger.log(Level.INFO, "New cones in repository: " + cone);
    }

    @Override
    public boolean removeCone(Cone cone) {
        return cones.remove(cone);
    }

    @Override
    public boolean removeAllCone(Collection<Cone> cone) {
        return cones.removeAll(cone);
    }

    @Override
    public List query(Specification specification) {
        List<Cone> result = cones.stream().filter(specification::specify).collect(Collectors.toList());
        logger.log(Level.INFO, "Query by specification " + specification + ": " + result);
        return result;
    }

    @Override
    public List sort(Comparator<? super Cone> comparator) {
        List<Cone> result = cones.stream().sorted(comparator).collect(Collectors.toList());
        logger.log(Level.INFO, "Sorted with comparator " + comparator + ": " + result);
        return result;
    }
}
