package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Logarithms {
    private NaturalLogarithm naturalLn;

    public Logarithms(NaturalLogarithm naturalLn) {
        this.naturalLn = naturalLn;
    }

    private BigDecimal log (double a, double b, double eps, boolean isBigDecimal) {
        return this.naturalLn.ln(b, eps / 2, isBigDecimal).divide(this.naturalLn.ln(a, eps / 2, isBigDecimal), RoundingMode.CEILING);
    }

    public double log (double a, double b, double eps) {
        if (a < 0 || b < 0) return Double.NaN;
        return log(a, b, eps, true).doubleValue();
    }
}
