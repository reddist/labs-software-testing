package main.java;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TrigonometricFunctions {
    private Sin sinObject;
    private Cos cosObject;
    private final int scaling = 400;

    public TrigonometricFunctions () {
        this.sinObject = new Sin();
        this.cosObject = new Cos(this.sinObject);
    }

    public TrigonometricFunctions (Sin sinObject, Cos cosObject) {
        this.sinObject = sinObject;
        this.cosObject = cosObject;
    }

    public double tan (double x, double eps) {
        return tan(x, eps, true).doubleValue();
    }

    public BigDecimal tan (double x, double eps, boolean isBigDecimal) {
        x = Helpers.correctX(x, -Math.PI, Math.PI, 2 * Math.PI);
        if (x == Math.PI / 2) return BigDecimal.valueOf(Double.MAX_VALUE);
        if (x == -Math.PI / 2) return BigDecimal.valueOf(Double.MIN_VALUE);
        return this.sinObject.sin(x, eps / 2.0)
                .setScale(scaling, RoundingMode.CEILING)
                .divide(this.cosObject.cos(x, eps / 2.0), RoundingMode.CEILING);
    }

    public double cotan (double x, double eps) {
        return cotan(x, eps, true).doubleValue();
    }

    public BigDecimal cotan (double x, double eps, boolean isBigDecimal) {
        x = Helpers.correctX(x, -Math.PI, Math.PI, 2 * Math.PI);
        if (x == 0) return BigDecimal.valueOf(Double.MAX_VALUE);
        if (x == -Math.PI || x == Math.PI) return BigDecimal.valueOf(Double.MIN_VALUE);
        return this.cosObject.cos(x, eps / 2.0)
                .setScale(scaling, RoundingMode.CEILING)
                .divide(this.sinObject.sin(x, eps / 2.0), RoundingMode.CEILING);
    }

    public double sec (double x, double eps) {
        return sec(x, eps, true).doubleValue();
    }

    public BigDecimal sec (double x, double eps, boolean isBigDecimal) {
        x = Helpers.correctX(x, -Math.PI, Math.PI, 2 * Math.PI);
        if (x == -Math.PI / 2 || x == Math.PI / 2) return BigDecimal.valueOf(Double.MAX_VALUE);
        return BigDecimal.valueOf(1.0D)
                .setScale(scaling, RoundingMode.CEILING)
                .divide(this.cosObject.cos(x, eps), RoundingMode.CEILING);
    }

    public double cosec (double x, double eps) {
        return cosec(x, eps, true).doubleValue();
    }

    public BigDecimal cosec (double x, double eps, boolean isBigDecimal) {
        x = Helpers.correctX(x, -Math.PI, Math.PI, 2 * Math.PI);
        if (x == 0 || x == Math.PI || x == -Math.PI) return BigDecimal.valueOf(Double.MAX_VALUE);
        return BigDecimal.valueOf(1.0D)
                .setScale(scaling, RoundingMode.CEILING)
                .divide(this.sinObject.sin(x, eps), RoundingMode.CEILING);
    }
}
