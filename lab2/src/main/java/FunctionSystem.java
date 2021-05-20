package main.java;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FunctionSystem {

    double eps = 0.0001;
    TrigonometricFunctions trigfun;
    Logarithms logarithms;
    NaturalLogarithm naturalLogarithm;

    public FunctionSystem () {
        Sin naturalSin = new Sin();
        this.naturalLogarithm = new NaturalLogarithm();
        this.trigfun = new TrigonometricFunctions(naturalSin, new Cos(naturalSin));
        this.logarithms = new Logarithms(this.naturalLogarithm);
    }

    public FunctionSystem (TrigonometricFunctions trigfun, NaturalLogarithm naturalLogarithm, Logarithms logarithms) {
        this.trigfun = trigfun;
        this.logarithms = logarithms;
        this.naturalLogarithm = naturalLogarithm;
    }

    public double system (double x) {
        return (x <= 0)
            ? function_1(x)
            : function_2(x);
    }

    public double function_1 (double x) {
        x = Helpers.correctX(x, -1.5 * Math.PI, -0.5 * Math.PI, Math.PI);
        if (x >= -Math.PI - eps && x <= -Math.PI + eps) return Double.MAX_VALUE;
        if (x >= -Math.PI / 2 - eps && x <= -Math.PI / 2 + eps) return Double.MAX_VALUE;
        if (x >= -1.5 * Math.PI - eps && x <= -1.5 * Math.PI + eps) return Double.MAX_VALUE;
        return trigfun.sec(x, eps / 100, true).multiply(
            trigfun.tan(x, eps / 100, true)
        ).add(
            trigfun.cosec(x, eps / 100, true)
        ).pow(3).pow(2).subtract(
            trigfun.cotan(x, eps / 100, true).pow(2)
        ).doubleValue();
    }

    public double function_2 (double x) {
        if (x >= 1.0D - eps && x <= 1.0D + eps && x <= 1.0D) return Double.MAX_VALUE;
        if (x >= 1.0D - eps && x <= 1.0D + eps && x >= 1.0D) return Double.MIN_VALUE;
        return logarithms.log(
            2.0D,
            x,
            eps,
            true
        ).pow(2).subtract(
            logarithms.log(2.0D, x, eps, true)
        ).subtract(
            logarithms.log(10.0D, x, eps, true)
        ).pow(3)
        .subtract(
            logarithms.log(5.0D, x, eps, true)
                .divide(
                    naturalLogarithm.ln(x, eps, true).pow(2),
                    RoundingMode.CEILING
                )
                .add(logarithms.log(
                10.0D,
                    x,
                    eps,
                    true
                ).pow(3))
        ).doubleValue();
    }
}
