package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * Factory class decides which handler to be invoked during run time (Factory Design Pattern)
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */

public class ConversionFactory {

    final static Logger logger = Logger.getLogger(ConversionFactory.class);

    public Conversion getConversionHandler(ConversionRequest request) throws IOException,NullPointerException {

        Conversion handler=null;
        Map<String,String> conversionRates=ReadConfigurations.getConversionRates();
        Map<String,String> lookup=ReadConfigurations.getConversionLookup();

        if (request != null && request.getSourceCurrency() != null && request.getDestinationCurrency() != null) {
            if(request.getSourceCurrency().equals(request.getDestinationCurrency())) {
                handler = new SameCurrencyHandler();
                logger.debug("Factory Method instantiating SameCurrencyHandler Object");
            }
            else if (conversionRates.containsKey(request.getSourceCurrency().concat(request.getDestinationCurrency()))) {
                handler = new DirectConversionHandler();
                logger.debug("Factory Method instantiating DirectConversionHandler Object");
            } else if (conversionRates.containsKey(request.getDestinationCurrency().concat(request.getSourceCurrency()))) {
                handler = new InverseConversionHandler();
                logger.debug("Factory Method instantiating InverseConversionHandler Object");
            } else if (lookup.containsKey(request.getSourceCurrency().concat(request.getDestinationCurrency())) || lookup.containsKey(request.getDestinationCurrency().concat(request.getSourceCurrency()))) {
                handler = new LookupConversionHandler();
                logger.debug("Factory Method instantiating LookupConversionHandler Object");
            }
            else
            {
                handler = new CurrencyNotSupportedHandler();
                logger.debug("Factory Method instantiating CurrencyNotSupportedHandler Object");
            }
        }
        return handler;
    }
}
