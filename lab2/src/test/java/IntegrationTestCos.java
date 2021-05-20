package test.java;

import main.java.Cos;
import main.java.Sin;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegrationTestCos extends TestCos {
    @Before
    @Override
    public void init () {
        Sin mockedSin = mock(Sin.class);
        ArgumentCaptor<Double> x = ArgumentCaptor.forClass(Double.class);
        when(mockedSin.sin(x.capture(), Mockito.anyDouble()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.sin(x.getValue()))));
        when(mockedSin.sin(x.capture(), Mockito.anyDouble()))
                .thenAnswer(invocation -> (BigDecimal.valueOf(Math.sin(x.getValue()))));
        naturalCos = new Cos(mockedSin);
    }
}
