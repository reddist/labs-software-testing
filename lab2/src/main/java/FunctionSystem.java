package main.java;

public class FunctionSystem {

    public static double system (double x) {
        return (x <= 0)
            ? function_1(x)
            : function_2(x);
    }
//x <= 0 : (((((sec(x) * tan(x)) + csc(x)) ^ 3) ^ 2) - (cot(x) ^ 2))
//x > 0 : (((((log_2(x) ^ 2) - log_2(x)) - log_10(x)) ^ 3) - ((log_5(x) / (ln(x) ^ 2)) + (log_10(x) ^ 3)))
    public static double function_1 (double x) {
        return x + 1;
    }

    public static double function_2 (double x) {
        return x - 1;
    }
}
