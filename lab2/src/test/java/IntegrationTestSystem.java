package test.java;

import main.java.*;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegrationTestSystem extends TestSystem {
    @Before
    @Override
    public void init () {
        TrigonometricFunctions mockedTrigfun = mock(TrigonometricFunctions.class);
        Logarithms mockedLogarithms = mock(Logarithms.class);
        NaturalLogarithm mockedLn = mock(NaturalLogarithm.class);
        ArgumentCaptor<Double> a = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> b = ArgumentCaptor.forClass(Double.class);
        ArgumentCaptor<Double> x = ArgumentCaptor.forClass(Double.class);
        // mock log(a, b)
        when(mockedLogarithms.log(a.capture(), b.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(b.getValue()) / Math.log(a.getValue()))));
        when(mockedLogarithms.log(a.capture(), b.capture(), Mockito.anyDouble()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(b.getValue()) / Math.log(a.getValue()))));
        // mock natural logarithm
        when(mockedLn.ln(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(x.getValue()))));
        when(mockedLn.ln(x.capture(), Mockito.anyDouble()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(x.getValue()))));
        // mock Trigonometric functions
        when(mockedTrigfun.tan(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.tan(x.getValue()))));
        when(mockedTrigfun.sec(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(1.0D / Math.cos(x.getValue()))));
        when(mockedTrigfun.cosec(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(1.0D / Math.sin(x.getValue()))));
        when(mockedTrigfun.cotan(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(1.0D / Math.tan(x.getValue()))));
        system = new FunctionSystem(mockedTrigfun, mockedLn, mockedLogarithms);
    }
}
