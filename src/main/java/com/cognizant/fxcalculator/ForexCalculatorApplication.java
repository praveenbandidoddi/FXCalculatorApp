package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

/**
 * Application Main Class
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class ForexCalculatorApplication {

    private final static Logger logger = Logger.getLogger(ForexCalculatorApplication.class);

    public static void main(String[] args) {
        //calling Forex calculator method
        forexCalculator();

    }


    //Forex calculator method to handle read calculate and display functions
    public static void forexCalculator() {
        ConversionFactory factory = new ConversionFactory();

        try {
            //Read console inputs for the conversion
            ConversionRequest request = ReadConfigurations.consoleReader();

            //Call ConversionFactory to fetch appropriate handler
            Conversion convert = factory.getConversionHandler(request);

            //Calling conversion method based on the object returned by handler
            Currency convertedCurrency = convert.getConvertedAmount(request);

            //Calling display method to display results on console
            System.out.print(ReadConfigurations.displayResult(request, convertedCurrency));
        } catch (Exception e) {
            logger.info("Exception:"+e);
        }
    }


}
