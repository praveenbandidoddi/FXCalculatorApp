package com.cognizant.fxcalculator;


/**
 * Currency POJO class to store converted currency name and value
 *
 * @author  Praveen Bandidoddi
 * @since   2018-06-29
 */
public class Currency {

    //Default Constructor
    public Currency()
    {
        this.amount = 0.0f;
        this.name="";

    }

    //Parameterised Constructor
    public Currency(String name,Float amount)
    {
        this.amount=amount;
        this.setName(name);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Float amount;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
