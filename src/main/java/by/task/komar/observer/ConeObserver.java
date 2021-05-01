package by.task.komar.observer;

import by.task.komar.exception.ConeException;

public interface ConeObserver {
    void updateVolume(ConeEvent coneEvent) throws ConeException;

    void updateSurfaceArea(ConeEvent coneEvent) throws ConeException;
}
