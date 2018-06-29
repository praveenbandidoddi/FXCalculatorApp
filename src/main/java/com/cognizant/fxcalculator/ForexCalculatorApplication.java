package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Application Main Class
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public class ForexCalculatorApplication {

    final static Logger logger = Logger.getLogger(ForexCalculatorApplication.class);

    public static void main(String[] args) {

        ConversionFactory factory = new ConversionFactory();

        try {
            //Read console inputs for the conversion
            ConversionRequest request = ReadConfigurations.consoleReader();

            //Call ConversionFactory to fetch appropriate handler
            Conversion convert = factory.getConversionHandler(request);

            //Calling conversion method based on the object returned by handler
            Currency convertedCurrency = convert.getConvertedAmount(request);

            //Calling display method to display results on the console
            System.out.println(ReadConfigurations.displayResult(request, convertedCurrency));
        }
        catch (Exception e)
        {
            logger.info("Exception:"+e);
        }
    }


}
