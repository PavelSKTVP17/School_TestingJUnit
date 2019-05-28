/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Demo1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author user
 */
public class AssertTest 
{
    /*
    public AssertTest() 
    {
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
    */
    @Test 
    @Ignore
    public void substring() 
    {
        assertEquals("llo", "Hello".substring(3));
    }
    @Test(expected = ArithmeticException.class)
    public void divideByZero() 
    {
        assertEquals(10/0, 25 ,1e-9);
    }
    /*@Test
    public void demo_test() 
    {
        assertEquals("llo", "Hel"+"lo");
        assertEquals(1.0, 1d/3+1d/3+1d/3,1e-10);
    }*/
}
