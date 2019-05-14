package com.mycompany;

/**
 *
 * @author user
 */
public class CalculatorImpl implements Calculator
{
    @Override
    public double calculate(String expression) 
    {
        return Double.parseDouble(expression);
       // throw new UnsupportedOperationException();
    }
    
}
