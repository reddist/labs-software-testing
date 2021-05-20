package main.java;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.lang.Math.PI;

public class Cos {
    private Sin sinObject;

    public Cos () {
        this.sinObject = new Sin();
    }

    public Cos (Sin sinObject) {
        this.sinObject = sinObject;
    }

    public BigDecimal cos (double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        BigDecimal abs_cos = BigDecimal.valueOf(1)
                .subtract(
                    sinObject.sin(x, eps).pow(2)
                )
                .sqrt(MathContext.DECIMAL128);
        if (x > PI / 2 || x < - PI / 2) {
            return abs_cos.multiply(BigDecimal.valueOf(-1));
        } else {
            return abs_cos;
        }
    }
}
