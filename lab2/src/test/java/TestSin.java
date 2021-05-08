package test.java;

import main.java.BasicFunctions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSin {
    double eps = 0.0001;

    @Test
    public void CheckPositive() {
        double[] params = {0.555, 0.567, 0.780, 14, 30};
        for (double param : params) {
            assertEquals(Math.sin(param), BasicFunctions.sin(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckZero() {
        assertEquals(0, BasicFunctions.sin(0, eps).doubleValue(), eps);
        assertEquals(0, BasicFunctions.sin(eps, eps).doubleValue(), eps);
        assertEquals(0, BasicFunctions.sin(-eps, eps).doubleValue(), eps);
    }

    @Test
    public void CheckNegative() {
        double[] params = {-0.456, -0.777, -1.780, -16, -50};
        for (double param : params) {
            assertEquals(Math.sin(param), BasicFunctions.sin(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckBounds() {
        assertEquals(1, BasicFunctions.sin(Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(-1, BasicFunctions.sin(-Math.PI / 2, eps).doubleValue(), eps);
    }
}
