package test.java;

import main.java.Cos;
import main.java.Sin;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestCos {
    double eps = 0.0001;
    Cos naturalCos;
    Cos cos_with_mocked_sin;

    @Before
    public void init() {
        Sin naturalSin = new Sin();
        Sin mockedSin = mock(Sin.class);
        naturalCos = new Cos(naturalSin);
        cos_with_mocked_sin = new Cos(mockedSin);
    }

    @Test
    public void CheckPositive() {
        double[] params = {0.555, 0.567, 0.780, 14, 30};
        for (double param : params) {
            assertEquals(Math.cos(param), naturalCos.cos(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckZero() {
        assertEquals(1, naturalCos.cos(0, eps).doubleValue(), eps);
        assertEquals(1, naturalCos.cos(eps, eps).doubleValue(), eps);
        assertEquals(1, naturalCos.cos(-eps, eps).doubleValue(), eps);
    }

    @Test
    public void CheckNegative() {
        double[] params = {-0.456, -0.777, -1.780, -16, -50};
        for (double param : params) {
            assertEquals(Math.cos(param), naturalCos.cos(param, eps).doubleValue(), eps);
        }
    }

    @Test
    public void CheckBounds() {
        assertEquals(0, naturalCos.cos(Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(0, naturalCos.cos(-Math.PI / 2, eps).doubleValue(), eps);
        assertEquals(1, naturalCos.cos(0, eps).doubleValue(), eps);
        assertEquals(-1, naturalCos.cos(Math.PI, eps).doubleValue(), eps);
        assertEquals(-1, naturalCos.cos(-Math.PI, eps).doubleValue(), eps);
    }
}
