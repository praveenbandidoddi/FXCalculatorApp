package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;

/**
 * ReadConfigurations class has methods to read configurations from properties files and helper methods to read
 * console inputs and display outputs
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public final class ReadConfigurations {

    private final static Logger logger = Logger.getLogger(ReadConfigurations.class);

    private static InputStream inputStream;

    //Read direct conversion rates into a Map from properties file
    public static HashMap<String,String> getConversionRates()  {

        HashMap<String,String> map = new HashMap<String,String>();

        try {
            Properties prop = new Properties();
            String propFileName = "conversions.properties";

            inputStream = ReadConfigurations.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            for (final Entry<Object, Object> entry : prop.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
            if(!map.isEmpty())
                logger.info("Conversion Rates:"+map);
        } catch (Exception e) {
            logger.info("Exception: " + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.info("Exception: " + e);
            }
        }

        return map;

    }

    //Read conversion lookup configuration into a Map from properties file
    public static HashMap<String,String> getConversionLookup() {

        HashMap<String,String> map = new HashMap<String,String>();

        try {
            Properties prop = new Properties();
            String propFileName = "lookup.properties";

            inputStream = ReadConfigurations.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            for (final Entry<Object, Object> entry : prop.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
            if(!map.isEmpty())
                logger.info("Currency Lookup Table:"+map);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                logger.info("Exception: " + e);
            }
        }

        return map;

    }

    // Helper method to read input string from console
    public static ConversionRequest consoleReader() {

        ConversionRequest request = new ConversionRequest();

        //Read Inputs from Console: Source Currency, Amount and Destination Currency
        //System.out.println("Please enter conversion string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs;

        if ( null != input && !(input.length() < 3)) {
            logger.debug("Input read from console" + input);
            inputs = input.split(" ");
            request.setSourceCurrency(inputs[0]);
            request.setDestinationCurrency(inputs[3]);
            request.setSourceAmount(Float.parseFloat(inputs[1]));
        }
        else
        {
            System.out.println("No Inputs Provided");
        }
        return request;

    }

    //Helper method to construct output display string
    public static String displayResult(ConversionRequest request,Currency convertedCurrency)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat jdf = new DecimalFormat("0");

        if (null != convertedCurrency && null!=convertedCurrency.getAmount()  &&  0!=convertedCurrency.getAmount()) {
            String amount;
            if (request.getDestinationCurrency().equals("JPY"))
                amount = jdf.format(convertedCurrency.getAmount());
            else
                amount = df.format(convertedCurrency.getAmount());

            return request.getSourceCurrency() + " " + request.getSourceAmount() + " = " + convertedCurrency.getName() + " " + amount;
        } else
            return "Unable to find rate for " + request.getSourceCurrency() + "/" + request.getDestinationCurrency();

    }
}
