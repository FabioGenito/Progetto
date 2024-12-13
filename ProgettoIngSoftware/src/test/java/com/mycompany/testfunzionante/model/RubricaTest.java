/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Rubrica instance = new Rubrica();
        List<Contatto> expResult = null;
        List<Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.aggiungiContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        int i = 0;
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.modificaContatto(i, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("eliminaContatto");
        Contatto c = null;
        Rubrica instance = new Rubrica();
        instance.eliminaContatto(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
