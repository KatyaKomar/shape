package by.task.komar.factory;

import by.task.komar.entity.Cone;
import by.task.komar.entity.Point;
import by.task.komar.exception.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    public static Cone createCone(Point point, double radius, double height) throws ConeException {
        Cone cone;
        if (radius <= 0 || height <= 0) {
            logger.log(Level.ERROR, "Can't be cone");
            throw new ConeException("Can't be cone");
        }
        cone = new Cone(point, radius, height);
        logger.log(Level.ERROR, "Create cone " + cone.toString());
        return cone;
    }

    public static Cone createCone(double x, double y, double z, double radius, double height) throws ConeException {
        Cone cone = createCone(new Point(x, y, z), radius, height);
        return cone;
    }

    public static Cone createCone(double[] array) throws ConeException {
        if (array.length != 5) {
            logger.log(Level.ERROR, "Can't be cone");
            throw new ConeException("Can't be cone");
        }
        Point point = new Point(array[0], array[1], array[2]);
        double radius = array[3];
        double height = array[4];
        Cone cone = createCone(point, radius, height);
        return cone;
    }
}
