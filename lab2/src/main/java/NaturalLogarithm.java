package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.E;

public class NaturalLogarithm {
    private final int scaling = 400;

    public BigDecimal ln (double x, double eps, boolean isBigDecimal) {
        if (x == 1) return BigDecimal.valueOf(0.0D);
        if (x == E) return BigDecimal.valueOf(1.0D);
        eps = eps / 100;
        BigDecimal decimalX = new BigDecimal(x);
        decimalX = decimalX.setScale(scaling, RoundingMode.CEILING);
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
        int numb = 2;
        BigDecimal powered_x_minus_1 = x_minus_1.multiply(x_minus_1);
        for (int k = 2; result.subtract(prev_result).abs().compareTo(BigDecimal.valueOf(eps)) > 0 && k < 900; k++) {
            prev_result = result;
            result = result.add(
                    powered_x_minus_1
                        .divide(new BigDecimal(k), RoundingMode.HALF_UP)
                        .multiply(BigDecimal.valueOf(k % 2 == 0 ? -1.0D : 1.0D))
            );
            powered_x_minus_1 = powered_x_minus_1.multiply(x_minus_1);
            numb = k;
        }
        System.out.println("\n" + numb + " iterations");
        return result.add(BigDecimal.valueOf(correction));
    }

    public double ln (double x, double eps) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        if (x == 1) return 0.0D;
        if (x == E) return 1.0D;
        return ln(x,  eps, true).doubleValue();
    }
}
