/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Demo1;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.fest.assertions.api.Assertions.*;
import org.junit.Test;

/**
 *
 * @author user
 */
public class HashMapTest {
/*
    public HashMapTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void defaultConstructorShouldCreateMapEmpty() 
    {
        Map<String,String> mp = new HashMap<>();
        assertThat(mp).isEmpty();
        assertThat(mp).hasSize(0).doesNotContainKey("x");
        assertThat(mp.entrySet().iterator().hasNext()).isFalse();
    }
    @Test
    public void collectionConstructorShouldCopyAllContent() 
    {
        Map<String,String> Om = new HashMap<>();
        Om.put("a1", "b1");
        Om.put("a2", "b2");
        
        Map<String,String> Cm = new HashMap<>(Om);
        
        assertThat(Cm).describedAs("Cm").hasSize(2)
                .isEqualTo(Om).isNotSameAs(Om);
        Om.put("a3", "b3");
        assertThat(Cm).hasSize(2)
                .doesNotContain(entry("a3", "b3"))
                //
                .isNotEqualTo(Om);
    }
}
