package by.test.komar.service;

import by.task.komar.entity.Cone;
import by.task.komar.entity.Point;
import by.task.komar.exception.ConeException;
import by.task.komar.factory.ShapeFactory;
import by.task.komar.service.impl.CalculationServiceImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculationServiceImplTest {

    @Test
    public void testConeSurfaceArea() throws ConeException {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        Cone cone = ShapeFactory.createCone(1, 2, 3, 4, 3);
        double actualSurfaceArea = calculation.coneSurfaceArea(cone);
        double expectedSurfaceArea = 36 * Math.PI;
        assertEquals(actualSurfaceArea, expectedSurfaceArea, 0.001, "Test failed as...");
    }

    @Test
    public void testConeVolume() throws ConeException {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        Cone cone = ShapeFactory.createCone(1, -1, 3, 4, 3);
        double actualVolume = calculation.coneVolume(cone);
        double expectedVolume = 16 * Math.PI;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testConeVolumeRatio() throws ConeException {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        Cone cone = ShapeFactory.createCone(0, 0, 0, 4, 3);
        Point point = new Point(1, 1, 1);
        double actualVolume = calculation.coneVolumeRatio(cone, point);
        double expectedVolume = 128.0 / 304;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testIsCone() {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        boolean actual = calculation.isCone(new Point(0, 7, -5), 0, 2);
        assertFalse(actual, " Test failed as...");
    }

    @Test
    public void testIsBaseOnPlane() throws ConeException {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        Cone cone = ShapeFactory.createCone(2, -2, 0, 4, 3);
        boolean actual = calculation.isBaseOnPlane(cone);
        assertTrue(actual, " Test failed as...");
    }

    @Test(expectedExceptions = ConeException.class)
    public void testConeVolumeRatioException() throws ConeException {
        CalculationServiceImpl calculation = new CalculationServiceImpl();
        Cone cone = ShapeFactory.createCone(0, 0, 0, 4, 3);
        Point point = new Point(1, 1, 3.5);
        double actualVolume = calculation.coneVolumeRatio(cone, point);
    }
}