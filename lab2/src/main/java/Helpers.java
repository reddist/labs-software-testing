package main.java;

import java.math.BigInteger;

import static java.lang.Math.PI;

public class Helpers {

    public static BigInteger factorial (int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static double correctX (double x, double left, double right, double period) {
        if (x < left) {
            while (x < left) x += period;
        }
        if (x > PI) {
            while (x > right) x -= period;
        }
        return x;
    }
}
