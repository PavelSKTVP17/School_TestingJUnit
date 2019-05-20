/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CalculatorImplTest 
{
    private CalculatorImpl CALC;
    
    @Before
    public void setUp()    { CALC=new CalculatorImpl();   }
    
    @Test
    public void zeroTest() throws Exception
    {
        double resl = CALC.calculate("0");
        assertEquals(0, resl,1e-9);
    }
    @Test
    public void floatingPointTest() throws Exception
    {
        double resl = CALC.calculate("-3000.02");
        assertEquals(-3000.02, resl,1e-9);
    }
    @Test
    public void addTest_1() throws Exception
    {
        double resl = new CalculatorImpl().calculate("30.4/2");
        assertEquals(15.2, resl,1e-9);
    }
    @Test
    public void addTest_2() throws Exception
    {
        double resl = new CalculatorImpl().calculate("(2+2)*1.5/10-444");
        assertEquals(-443.4, resl,1e-9);
    }
    @Test
    public void functionTest() throws Exception
    {
        double resl = new CalculatorImpl().calculate("sin(1)*sin(1)+cos(1)*cos(1)");
        assertEquals(1, resl,1e-9);
    }
    /*
    public CalculatorImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
