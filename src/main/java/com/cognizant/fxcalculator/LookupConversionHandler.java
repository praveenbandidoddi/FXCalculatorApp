package com.cognizant.fxcalculator;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * LookupConversionHandler handler class
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class LookupConversionHandler implements Conversion {

    private final static Logger logger = Logger.getLogger(LookupConversionHandler.class);

    public Currency getConvertedAmount (ConversionRequest conversionRequest) throws IOException
    {

        //Variable declarations
        Currency convertedCurrency=new Currency();
        ConversionFactory factory= new ConversionFactory();
        Conversion firstConvert;
        ConversionRequest firstConversionRequest;
        Conversion lastConvert;
        ConversionRequest lastConversionRequest;
        Currency firstConvertedAmount;
        Currency lastConvertedAmount;

        String sourceCurrency=conversionRequest.getSourceCurrency();
        String destinationCurrency=conversionRequest.getDestinationCurrency();
        Float amount=conversionRequest.getSourceAmount();

        Map<String ,String> lookup=ReadConfigurations.getConversionLookup();

        String lookupCurrency=sourceCurrency.concat(destinationCurrency);
        String inverseCurrency=destinationCurrency.concat(sourceCurrency);

        logger.debug("Entering cross currency conversion logic as no direct conversion available for :" + sourceCurrency + " & " + destinationCurrency);

        firstConversionRequest= new ConversionRequest(sourceCurrency,lookup.containsKey(lookupCurrency)? lookup.get(lookupCurrency):lookup.get(inverseCurrency),amount);
        firstConvert = factory.getConversionHandler(firstConversionRequest);
        firstConvertedAmount=firstConvert.getConvertedAmount(firstConversionRequest);

        lastConversionRequest= new ConversionRequest(lookup.containsKey(lookupCurrency)? lookup.get(lookupCurrency):lookup.get(inverseCurrency),destinationCurrency,firstConvertedAmount.getAmount());
        lastConvert = factory.getConversionHandler(lastConversionRequest);
        lastConvertedAmount=lastConvert.getConvertedAmount(lastConversionRequest);

        if(null !=firstConvertedAmount.getAmount()&& null!=lastConvertedAmount.getAmount()) {
            convertedCurrency.setAmount(lastConvertedAmount.getAmount());
            convertedCurrency.setName(destinationCurrency);
        }
        return convertedCurrency;
    }
}
