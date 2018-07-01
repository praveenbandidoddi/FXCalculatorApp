package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;


/**
 * CurrencyNotSupportedHandler handler class
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class CurrencyNotSupportedHandler implements Conversion{

    private final static Logger logger = Logger.getLogger(DirectConversionHandler.class);

    public Currency getConvertedAmount(ConversionRequest conversionRequest)
    {
        Currency convertedCurrency=new Currency();

        convertedCurrency.setAmount(0.0f);
        convertedCurrency.setName("");
        logger.debug("Currency Currently Not Supported");
        return convertedCurrency;
    }
}
