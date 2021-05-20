package main.java;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

import static main.java.TrigonomicFunctions.factorial;

public class Sin {
    public BigDecimal sin(double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        if (x == Math.PI / 2) return new BigDecimal(1);
        if (x == -Math.PI / 2) return new BigDecimal(-1);
        if (x == Math.PI) return new BigDecimal(0);
        if (x == -Math.PI) return new BigDecimal(0);
        if (x == 0) return new BigDecimal(0);
        BigDecimal result = new BigDecimal(x);
        BigDecimal prev_result = new BigDecimal(x)
                .add(new BigDecimal(eps))
                .add(new BigDecimal(1));
        for (int k = 3; abs(result.subtract(prev_result).doubleValue()) > eps && k < 30; k += 2) {
            prev_result = result;
            result = BigDecimal.valueOf(x).pow(k)
                    .multiply(BigDecimal.valueOf(
                            new BigFraction(1)
                                    .divide(factorial(k))
                                    .doubleValue()
                    ))
                    .multiply(BigDecimal.valueOf(-1).pow((k - 1) / 2))
                    .add(result);
        }
        return result;
    }
}
