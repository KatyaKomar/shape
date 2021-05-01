package by.task.komar.observer;

import by.task.komar.exception.ConeException;

public interface ConeObservable<T extends ConeObserver> {
    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws ConeException;
}
