package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * CurrencyNotSupportedHandler handler class
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public class DirectConversionHandler implements Conversion {

    final static Logger logger = Logger.getLogger(DirectConversionHandler.class);

    public Currency getConvertedAmount(ConversionRequest conversionRequest) throws IOException
    {
        Currency convertedCurrency=new Currency();

        String sourceCurrency=conversionRequest.getSourceCurrency();
        String destinationCurrency=conversionRequest.getDestinationCurrency();
        float amount=conversionRequest.getSourceAmount();

        convertedCurrency.setAmount(Float.parseFloat(ReadConfigurations.getConversionRates().get(sourceCurrency.concat(destinationCurrency))) * amount);
        convertedCurrency.setName(destinationCurrency);
        logger.debug("Conversion performed from direct conversion:"+convertedCurrency.getAmount()+" "+convertedCurrency.getName());

        return convertedCurrency;
    }
}
