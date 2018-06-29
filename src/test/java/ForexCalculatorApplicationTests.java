import com.cognizant.fxcalculator.*;
import org.hamcrest.MatcherAssert;
import org.junit.Test;


import java.io.IOException;
import static org.junit.Assert.assertTrue;

/**
 * Unit Test cases to cover all the possible scenarios for Forex Currency Convertor application using JUnit
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public class ForexCalculatorApplicationTests {

    @Test
	public void testConvertionOfAUDtoUSD() throws IOException {
        ConversionRequest cr=new ConversionRequest("AUD","USD",new Float(100));
        //Call ConversionFactory to fetch appropriate handler
        ConversionFactory factory = new ConversionFactory();
        Conversion convert = factory.getConversionHandler(cr);
        //Calling conversion method based on the object returned by handler
        Currency actualConvertedCurrency = convert.getConvertedAmount(cr);
        assertTrue("AUD 100.0 = USD 83.71".equals(ReadConfigurations.displayResult(cr,actualConvertedCurrency)));

	}

   @Test
    public void testConvertionOfAUDtoAUD() throws IOException {
        ConversionRequest cr=new ConversionRequest("AUD","AUD",new Float(100));
        //Call ConversionFactory to fetch appropriate handler
        ConversionFactory factory = new ConversionFactory();
        Conversion convert = factory.getConversionHandler(cr);
        //Calling conversion method based on the object returned by handler
        Currency actualConvertedCurrency = convert.getConvertedAmount(cr);
        assertTrue("AUD 100.0 = AUD 100.00".equals(ReadConfigurations.displayResult(cr,actualConvertedCurrency)));
    }

    @Test
    public void testConvertionOfAUDtoDKK() throws IOException {
        ConversionRequest cr=new ConversionRequest("AUD","DKK",new Float(100));
        //Call ConversionFactory to fetch appropriate handler
        ConversionFactory factory = new ConversionFactory();
        Conversion convert = factory.getConversionHandler(cr);
        //Calling conversion method based on the object returned by handler
        Currency actualConvertedCurrency = convert.getConvertedAmount(cr);
        assertTrue("AUD 100.0 = DKK 505.76".equals(ReadConfigurations.displayResult(cr,actualConvertedCurrency)));
    }

    @Test
    public void testConvertionOfJPYtoUSD() throws IOException{
        ConversionRequest cr=new ConversionRequest("JPY","USD",new Float(100));
        //Call ConversionFactory to fetch appropriate handler
        ConversionFactory factory = new ConversionFactory();
        Conversion convert = factory.getConversionHandler(cr);
        //Calling conversion method based on the object returned by handler
        Currency actualConvertedCurrency = convert.getConvertedAmount(cr);
        assertTrue("JPY 100.0 = USD 0.83".equals(ReadConfigurations.displayResult(cr,actualConvertedCurrency)));
    }

    @Test
    public void testConvertionOfKRWtoFJD() throws IOException{
        ConversionRequest cr=new ConversionRequest("KRW","FJD",new Float(100));
        //Call ConversionFactory to fetch appropriate handler
        ConversionFactory factory = new ConversionFactory();
        Conversion convert = factory.getConversionHandler(cr);
        //Calling conversion method based on the object returned by handler
        Currency actualConvertedCurrency = convert.getConvertedAmount(cr);
        System.out.println(ReadConfigurations.displayResult(cr,actualConvertedCurrency));
        assertTrue("Unable to find rate for KRW/FJD".equals(ReadConfigurations.displayResult(cr,actualConvertedCurrency)));
    }


}
