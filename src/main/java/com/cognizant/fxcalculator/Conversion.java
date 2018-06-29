package com.cognizant.fxcalculator;

import java.io.IOException;

/**
 * Interface which can be implemented by all Handler classes to convert currency using getConvertedAmount method
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public interface Conversion {
    //Interface class mandating all sub classes to implement getConvertedAmount method
    Currency getConvertedAmount(ConversionRequest conversionRequest) throws IOException;

}
