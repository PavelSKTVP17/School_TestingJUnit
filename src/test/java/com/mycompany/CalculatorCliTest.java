package com.mycompany;

import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
//import org.mockito.Mockito;
import static org.mockito.Mockito.*;
public class CalculatorCliTest 
{
    private Calculator CALCMOCK;
    private CalculatorCli CLI;
    
    @Rule
    public TestRule timeout= new Timeout(1000, TimeUnit.MILLISECONDS);
    
    @Before
    public void setUp()
    {
        CALCMOCK=mock(Calculator.class);
        CLI=new CalculatorCli(CALCMOCK);
    }
    
    @Test//(timeout = 50)
    public void emptyExpressionsMustBeSkipped() 
    {
        CLI.runInteractiveSession(new StringReader(";\n;   ;;;\t\n;"));
        verifyZeroInteractions(CALCMOCK);
    }
    @Test//(timeout = 50)
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_1()  throws InterruptedException 
    {
        CLI.runInteractiveSession(new StringReader("1;2;3"));
        Thread.sleep(200);
        verify(CALCMOCK).calculate("1");
        verify(CALCMOCK).calculate("2");
        verify(CALCMOCK).calculate("3");
        verifyNoMoreInteractions(CALCMOCK);
    }
    @Test//(timeout = 50)
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_2() throws InterruptedException 
    {
        when(CALCMOCK.calculate("1")).thenReturn(1d);
        when(CALCMOCK.calculate("2")).thenReturn(2d);
        when(CALCMOCK.calculate("3")).thenReturn(3d);
        //Thread.sleep(1100);
        CLI.runInteractiveSession(new StringReader("1;2;3"));
        verify(CALCMOCK).calculate("1");
        verify(CALCMOCK).calculate("2");
        verify(CALCMOCK).calculate("3");     
        verifyNoMoreInteractions(CALCMOCK);
    }
    /*
    public CalculatorCliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRunInteractiveSession_Reader() {
        System.out.println("runInteractiveSession");
        Reader rdr = null;
        CalculatorCli instance = null;
        instance.runInteractiveSession(rdr);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRunInteractiveSession_Reader_DoubleConsumer() {
        System.out.println("runInteractiveSession");
        Reader rdr = null;
        DoubleConsumer resConsumer = null;
        CalculatorCli instance = null;
        instance.runInteractiveSession(rdr, resConsumer);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CalculatorCli.main(args);
        fail("The test case is a prototype.");
    }
    */
}
