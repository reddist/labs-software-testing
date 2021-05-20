package test.java;

import main.java.Logarithms;
import main.java.NaturalLogarithm;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class TestLogarithms {
    double eps = 0.0001;

    @Test
    public void check_log_2 () {
        System.out.println("Check log 2...");
        Logarithms log_a_b = new Logarithms(new NaturalLogarithm());
        int number = 1;
        for (int i = 1; i < 15; i++) {
            number *= 2;
            assertEquals(Math.log(number) / Math.log(2), log_a_b.log(2, number, eps), eps);
            System.out.printf("log(2, %d) - OK\n---------------------------------\n", number);
        }
        System.out.println("Passed.\n");
    }

    @Test
    public void check_log_2_with_mocked_ln () {
        System.out.print("\n\nCheck mocking ln");
        NaturalLogarithm mockedLn = mock(NaturalLogarithm.class);
        when(mockedLn.ln(2, 0.005, true)).thenReturn(BigDecimal.valueOf(1));
        when(mockedLn.ln(4, 0.005, true)).thenReturn(BigDecimal.valueOf(4));
        Logarithms log_a_b_with_mocked_ln = new Logarithms(mockedLn);
        assertEquals(4.0, log_a_b_with_mocked_ln.log(2, 4, 0.01), 0.0);
        System.out.println(" - OK");
    }

    @Test
    public void check_ln_critical_points () {
        System.out.println("Check ln in critical points...");
        NaturalLogarithm naturalLn = new NaturalLogarithm();
        double[] params = {1, 0, Math.E, -2};
        for (double param : params) {
            System.out.print(param);
            assertEquals(Math.log(param), naturalLn.ln(param, eps), eps);
            System.out.println(" - OK");
        }
        System.out.println("Passed.\n");
    }

    @Test
    public void check_ln () {
        System.out.println("Check ln...");
        NaturalLogarithm naturalLn = new NaturalLogarithm();
        double[] params = {125, 10000, Math.E, 2.28623, 5.22221, 0.234, 0.015, 0.78402, 0.56736, Math.E * Math.E};
        for (double param : params) {
            System.out.print(param);
            assertEquals(Math.log(param), naturalLn.ln(param, eps), eps);
            System.out.println(" - OK");
        }
        System.out.println("Passed.\n");
    }
}
