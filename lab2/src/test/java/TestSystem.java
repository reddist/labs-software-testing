package test.java;

import main.java.FunctionSystem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSystem {

    FunctionSystem system;
    final double delta = 0.001;

    @Before
    public void init () {
        system = new FunctionSystem();
    }

    @Test
    public void test_trig_critical_points () {
        assertEquals(Double.MAX_VALUE, system.system(-Math.PI), delta);
        assertEquals(Double.MAX_VALUE, system.system(-1.5 * Math.PI), delta);
        assertEquals(Double.MAX_VALUE, system.system(-0.5 * Math.PI), delta);
        assertEquals(305.544, system.system(-Math.PI-0.61471), delta);
        assertEquals(305.544, system.system(-Math.PI+0.61471), delta);
    }

    @Test
    public void test_trig_1 () {
        double[] params = {-4.4, -4.41, -4.415};
        double[] answers = {1896530, 2715630, 3266740};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), 1.5);
        }
    }

    @Test
    public void test_trig_2 () {
        double[] params = {-4.2, -4.25, -4.3, -4.33};
        double[] answers = {11831.3, 31336.4, 98408.5, 215233};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), 0.5);
        }
    }

    @Test
    public void test_trig_3 () {
        double[] params = {-4.1, -4.034, -3.87, -3.666, -3.5};
        double[] answers = {2559.15, 1202.921, 384.122, 355.604, 1172.962};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_trig_4 () {
        double[] params = {-3.36, -3.3, -3.29, -3.276, -3.26};
        double[] answers = {12875.5, 75455.5, 109211, 192489, 400279};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), 1);
        }
    }

    @Test
    public void test_trig_5 () {
        double[] params = {-3.25, -3.24, -3.23};
        double[] answers = {668933, 1178360, 2212240};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), 2.5);
        }
    }

    @Test
    public void test_log_1 () {
        double[] params = {0.267, 0.35978, 0.555, 0.567, 0.701};
        double[] answers = {228.527, 69.3066, 7.16735, 6.33339, 2.55566};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_2 () {
        double[] params = {0.798, 0.8265, 0.87364, 0.9423, 0.97};
        double[] answers = {2.90298, 3.34254, 4.6245, 10.4563, 20.3991};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_3 () {
        double[] params = {0.9765, 0.988, 0.991, 0.995};
        double[] answers = {26.128, 51.4666, 68.7261, 123.956};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_4 () {
        double[] params = {1.0025, 1.04, 1.08, 1.1111};
        double[] answers = {-248.845, -15.8424, -8.07571, -5.90321};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_5 () {
        double[] params = {1.15, 1.2462, 1.357, 1.445566};
        double[] answers = {-4.45678, -2.85431, -2.0921, -1.75865};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_6 () {
        double[] params = {1.9765, 5.974, 10.875, 100.543};
        double[] answers = {-0.968419, 34.9493, 399.674, 45074.406};
        for (int i = 0; i < params.length; i++) {
            assertEquals(answers[i], system.system(params[i]), delta);
        }
    }

    @Test
    public void test_log_critical_points () {
        assertEquals(Double.MAX_VALUE, system.system(1), delta);
        assertEquals(Double.MIN_VALUE, system.system(1.00001), delta);
        assertEquals(2.48268, system.system(0.728655), delta);
    }
}
