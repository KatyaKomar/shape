package by.task.komar.util;

public class IdGenerator {
    private static long counter;

    private IdGenerator() {
    }

    public static long generateId() {
        return ++counter;
    }
}
