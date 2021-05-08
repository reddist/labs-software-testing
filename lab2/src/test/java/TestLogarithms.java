package test.java;

import main.java.BasicFunctions;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestLogarithms {
    double eps = 0.0001;

    @Test
    public void check_log_2() {
        int number = 1;
        for (int i = 1; i < 15; i++) {
            number *= 2;
            System.out.print(number);
            assertEquals(Math.log(number) / Math.log(2), BasicFunctions.log(2, number, eps).doubleValue(), eps);
            System.out.println(" - OK");
        }
    }
}
