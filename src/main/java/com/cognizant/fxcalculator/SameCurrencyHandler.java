package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * SameCurrencyHandler handler class
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public class SameCurrencyHandler implements Conversion {

    final static Logger logger = Logger.getLogger(DirectConversionHandler.class);

    public Currency getConvertedAmount(ConversionRequest conversionRequest) throws IOException {
        Currency convertedCurrency = new Currency();

        String sourceCurrency = conversionRequest.getSourceCurrency();
        String destinationCurrency = conversionRequest.getDestinationCurrency();
        float amount = conversionRequest.getSourceAmount();
        convertedCurrency.setAmount(amount);
        convertedCurrency.setName(destinationCurrency);
        logger.debug("No Conversion Performed as same currency");

        return convertedCurrency;
    }
}
