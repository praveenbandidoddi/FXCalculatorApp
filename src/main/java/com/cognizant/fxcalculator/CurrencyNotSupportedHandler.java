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
public class CurrencyNotSupportedHandler implements Conversion{

    final static Logger logger = Logger.getLogger(DirectConversionHandler.class);

    public Currency getConvertedAmount(ConversionRequest conversionRequest) throws IOException
    {
        Currency convertedCurrency=new Currency();

        convertedCurrency.setAmount(new Float(0));
        convertedCurrency.setName("");
        logger.debug("Currency Currently Not Supported");
        return convertedCurrency;
    }
}
