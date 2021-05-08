package main.java;
import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class BasicFunctions {

    public static BigInteger factorial(int n)
    {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static double tan_from_sincos (double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        if (x == Math.PI / 2) return Double.MAX_VALUE;
        if (x == -Math.PI / 2) return Double.MIN_VALUE;
        return sin(x, eps / 2.0).divide(cos(x, eps / 2.0), RoundingMode.CEILING).doubleValue();
    }

    public static BigDecimal sin(double x, double eps) {
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

    public static BigDecimal cos (double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        BigDecimal abs_cos = BigDecimal.valueOf(1)
            .subtract(
                sin(x, eps).pow(2)
            )
            .sqrt(MathContext.DECIMAL128);
        if (x > PI / 2 || x < - PI / 2) {
            return abs_cos.multiply(BigDecimal.valueOf(-1));
        } else {
            return abs_cos;
        }
    }

    public static BigDecimal ln (double x, double eps) {
        if (x == 0) return BigDecimal.valueOf(Double.MAX_VALUE);
        BigDecimal decimalX = new BigDecimal(x);
        decimalX = decimalX.setScale(200, RoundingMode.CEILING);
        int correction = 0;
        while (decimalX.compareTo(new BigDecimal(2)) >= 0) {
            decimalX = decimalX.divide(new BigDecimal(E), RoundingMode.CEILING);
            correction += 1;
        }
        BigDecimal result = decimalX.subtract(BigDecimal.valueOf(1));
        BigDecimal x_minus_1 = decimalX.subtract(BigDecimal.valueOf(1));
        BigDecimal prev_result = result
            .add(BigDecimal.valueOf(eps))
            .add(BigDecimal.valueOf(1));
        for (int k = 2; result.subtract(prev_result).abs().compareTo(BigDecimal.valueOf(eps)) > 0 && k < 50; k++) {
            prev_result = result;
            result = result.add(
                x_minus_1.pow(k)
                    .divide(new BigDecimal(k), RoundingMode.CEILING)
                    .multiply(new BigDecimal(-1).pow(k + 1))
            );
        }
        return result.add(BigDecimal.valueOf(correction));
    }

    public static BigDecimal log (double a, double b, double eps) {
        return ln(b, eps / 2).divide(ln(a, eps / 2), RoundingMode.CEILING);
    }
}
