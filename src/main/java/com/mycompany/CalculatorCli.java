package com.mycompany;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class CalculatorCli 
{
    private final Calculator CALC;

    public CalculatorCli(Calculator CALC) 
    {this.CALC = CALC;}
    
    public void runInteractiveSession(Reader rdr)
    {
        runInteractiveSession(rdr,System.out::println);
    }
    public void runInteractiveSession(Reader rdr, DoubleConsumer resConsumer) 
    {
        new BufferedReader(rdr).lines()
                .flatMap( s->Stream.of(s.split(";")) )
                .filter( s->!s.trim().isEmpty() )
                .mapToDouble(CALC::calculate)
                .forEach(resConsumer);
    }
    public static void main(String[] args) throws Exception
    {
        CalculatorCli cli=new CalculatorCli( new CalculatorImpl() );
        try (Reader rdr= new InputStreamReader(System.in))
        {
            cli.runInteractiveSession(rdr);
        }
        
    }
}
