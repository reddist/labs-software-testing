package main.java;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class TrigonomicFunctions {

    public static BigInteger factorial(int n)
    {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public double tan (double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        if (x == Math.PI / 2) return Double.MAX_VALUE;
        if (x == -Math.PI / 2) return Double.MIN_VALUE;
        Sin naturalSin = new Sin();
        Cos naturalCos = new Cos(naturalSin);
        return naturalSin.sin(x, eps / 2.0).divide(naturalCos.cos(x, eps / 2.0), RoundingMode.CEILING).doubleValue();
    }

    public double cotan (double x, double eps) {
        if (x < -PI) {
            while (x < -PI) x += 2 * PI;
        }
        if (x > PI) {
            while (x > PI) x -= 2 * PI;
        }
        if (x == 0) return Double.MAX_VALUE;
        if (x == -Math.PI || x == Math.PI) return Double.MIN_VALUE;
        Sin naturalSin = new Sin();
        Cos naturalCos = new Cos(naturalSin);
        return naturalCos.cos(x, eps / 2.0).divide(naturalSin.sin(x, eps / 2.0), RoundingMode.CEILING).doubleValue();
    }
}
