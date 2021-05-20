package test.java;

import main.java.TrigonometricFunctions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestSec {
    double eps = 0.0001;
    TrigonometricFunctions trigfun;

    @Before
    public void init() {
        trigfun = new TrigonometricFunctions();
    }

    @Test
    public void test_critical_from_system () {
        double x = -Math.PI+0.61471;
        assertEquals(1.0D / Math.cos(x), trigfun.sec(x, eps / 100, true).doubleValue(), eps);
    }

}
