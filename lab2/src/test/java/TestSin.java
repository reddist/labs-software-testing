package test.java;

import main.java.Sin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestSin {
    double eps = 0.0001;
    Sin naturalSin;
    Sin mockedSin;

    @Before
    public void init() {
        naturalSin = new Sin();
        mockedSin = mock(Sin.class);
    }

    @Test
    public void CheckPositive() {
        double[] params = {0.555, 0.567, 0.780, 14, 30};
        for (double param : params) {
            assertEquals(Math.sin(param), naturalSin.sin(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckZero() {
        assertEquals(0, naturalSin.sin(0, eps).doubleValue(), eps);
        assertEquals(0, naturalSin.sin(eps, eps).doubleValue(), eps);
        assertEquals(0, naturalSin.sin(-eps, eps).doubleValue(), eps);
    }

    @Test
    public void CheckNegative() {
        double[] params = {-0.456, -0.777, -1.780, -16, -50};
        for (double param : params) {
            assertEquals(Math.sin(param), naturalSin.sin(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckBounds() {
        assertEquals(1, naturalSin.sin(Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(-1, naturalSin.sin(-Math.PI / 2, eps).doubleValue(), eps);
    }
}
