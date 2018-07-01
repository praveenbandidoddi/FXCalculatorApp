import com.cognizant.fxcalculator.ForexCalculatorApplication;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit Test cases to cover all the possible scenarios for Forex Currency Convertor application using JUnit
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class ForexCalculatorApplicationTests {

    @Rule
    public final TextFromStandardInputStream systemInput = TextFromStandardInputStream.emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testConvertionOfAUDtoAUD() {
        systemInput.provideLines("AUD 100 in AUD");
        systemOutRule.clearLog();
        ForexCalculatorApplication.forexCalculator();
        assertEquals("AUD 100.0 = AUD 100.00", systemOutRule.getLog());
    }

    @Test
    public void testConvertionOfAUDtoUSD() {
        systemInput.provideLines("AUD 100 in USD");
        systemOutRule.clearLog();
        ForexCalculatorApplication.forexCalculator();
        assertEquals("AUD 100.0 = USD 83.71", systemOutRule.getLog());

	}

    @Test
    public void testConvertionOfAUDtoDKK() {
        systemInput.provideLines("AUD 100 in DKK");
        systemOutRule.clearLog();
        ForexCalculatorApplication.forexCalculator();
        assertEquals("AUD 100.0 = DKK 505.76", systemOutRule.getLog());
    }

    @Test
    public void testConvertionOfJPYtoUSD() {
        systemInput.provideLines("JPY 100 in USD");
        systemOutRule.clearLog();
        ForexCalculatorApplication.forexCalculator();
        assertEquals("JPY 100.0 = USD 0.83", systemOutRule.getLog());
    }

    @Test
    public void testConvertionOfKRWtoFJD() {
        systemInput.provideLines("KRW 100 in INR");
        systemOutRule.clearLog();
        ForexCalculatorApplication.forexCalculator();
        assertEquals("Unable to find rate for KRW/INR", systemOutRule.getLog());
    }


}
