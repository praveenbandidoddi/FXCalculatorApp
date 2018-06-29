package com.cognizant.fxcalculator;

/**
 * ConversionRequest POJO class to store conversion request details
 *
 * @author  Praveen Bandidoddi
 * @version 1.0
 * @since   2018-06-29
 */
public class ConversionRequest {

    //Default Constructor
    public ConversionRequest() {
        this.sourceCurrency="";
        this.destinationCurrency="";
        this.sourceAmount=new Float(0);
    }

    //Parameterised Constructor
    public ConversionRequest(String sourceCurrency,String destinationCurrency, Float sourceAmount)
    {
        this.sourceCurrency=sourceCurrency;
        this.destinationCurrency=destinationCurrency;
        this.sourceAmount=sourceAmount;
    }

    private String sourceCurrency;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    private String destinationCurrency;

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    private Float sourceAmount;

    public Float getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(Float sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

}
