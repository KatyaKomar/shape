package by.task.komar.entity;

import by.task.komar.exception.ConeException;
import by.task.komar.observer.ConeEvent;
import by.task.komar.observer.ConeObservable;
import by.task.komar.observer.impl.ConeObserverImpl;
import by.task.komar.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cone implements ConeObservable<ConeObserverImpl> {
    private static Logger logger = LogManager.getLogger();
    private long coneId;
    private Point center;
    private double radius;
    private double height;
    private List<ConeObserverImpl> observers = new ArrayList<>();

    public Cone(Point center, double radius, double height) {
        this.center = center;
        this.radius = radius;
        this.height = height;
        this.coneId = IdGenerator.generateId();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) throws ConeException {
        this.center = center;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        if (radius <= 0) {
            logger.log(Level.ERROR, "Radius can't be " + radius);
            throw new ConeException("Radius can't be " + radius);
        }
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ConeException {
        if (height <= 0) {
            logger.log(Level.ERROR, "Height can't be " + radius);
            throw new ConeException("Height can't be " + height);
        }
        this.height = height;
        notifyObservers();
    }

    public long getConeId() {
        return coneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radius, radius) == 0 &&
                Double.compare(cone.height, height) == 0 &&
                coneId == cone.coneId &&
                center.equals(cone.center);
    }

    @Override
    public int hashCode() {
        int result = this.center.hashCode();
        long longBits = Double.doubleToLongBits(this.radius);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.height);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cone{");
        builder.append("center=").append(center);
        builder.append(", radius=").append(radius);
        builder.append(", height=").append(height);
        builder.append(", coneId=").append(coneId);
        builder.append('}');
        return builder.toString();
    }

    @Override
    public void attach(ConeObserverImpl observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ConeObserverImpl observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws ConeException {
        ConeEvent coneEvent = new ConeEvent(this);
        if (!observers.isEmpty()) {
            for (ConeObserverImpl observer : observers) {
                observer.updateSurfaceArea(coneEvent);
                observer.updateVolume(coneEvent);
            }
        }
    }
}
