package test.java;

import main.java.Logarithms;
import main.java.NaturalLogarithm;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegrationTestLogarithms extends TestLogarithms {
    @Before
    @Override
    public void init () {
        NaturalLogarithm mockedLn = mock(NaturalLogarithm.class);
        ArgumentCaptor<Double> x = ArgumentCaptor.forClass(Double.class);
        when(mockedLn.ln(x.capture(), Mockito.anyDouble()))
            .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(x.getValue()))));
        when(mockedLn.ln(x.capture(), Mockito.anyDouble(), Mockito.anyBoolean()))
            .thenAnswer(invocation -> (BigDecimal.valueOf(Math.log(x.getValue()))));
        naturalLn = new NaturalLogarithm();
        log_a_b = new Logarithms(mockedLn);
    }
}
