package test.java;

import main.java.BasicFunctions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCos {
    double eps = 0.0001;

    @Test
    public void CheckPositive() {
        double[] params = {0.555, 0.567, 0.780, 14, 30};
        for (double param : params) {
            assertEquals(Math.cos(param), BasicFunctions.cos(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckZero() {
        assertEquals(1, BasicFunctions.cos(0, eps).doubleValue(), eps);
        assertEquals(1, BasicFunctions.cos(eps, eps).doubleValue(), eps);
        assertEquals(1, BasicFunctions.cos(-eps, eps).doubleValue(), eps);
    }

    @Test
    public void CheckNegative() {
        double[] params = {-0.456, -0.777, -1.780, -16, -50};
        for (double param : params) {
            assertEquals(Math.cos(param), BasicFunctions.cos(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckBounds() {
        assertEquals(0, BasicFunctions.cos(Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(0, BasicFunctions.cos(-Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(1, BasicFunctions.cos(0, eps).doubleValue(), eps);
        assertEquals(-1, BasicFunctions.cos(Math.PI, eps).doubleValue(), eps);
        assertEquals(-1, BasicFunctions.cos(-Math.PI, eps).doubleValue(), eps);
    }
}
