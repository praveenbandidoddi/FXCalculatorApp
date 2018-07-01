package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * InverseConversionHandler handler class
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class InverseConversionHandler implements Conversion {

    private final static Logger logger = Logger.getLogger(InverseConversionHandler.class);

    public Currency getConvertedAmount(ConversionRequest conversionRequest)
    {
        Currency convertedCurrency=new Currency();

        String sourceCurrency=conversionRequest.getSourceCurrency();
        String destinationCurrency=conversionRequest.getDestinationCurrency();
        float amount=conversionRequest.getSourceAmount();

        convertedCurrency.setAmount((1/(Float.parseFloat(ReadConfigurations.getConversionRates().get(destinationCurrency.concat(sourceCurrency))))) * amount);
        convertedCurrency.setName(destinationCurrency);
        logger.debug("Conversion performed from Inversion logic conversion: "+convertedCurrency.getAmount()+" "+convertedCurrency.getName());

        return convertedCurrency;
    }

}
