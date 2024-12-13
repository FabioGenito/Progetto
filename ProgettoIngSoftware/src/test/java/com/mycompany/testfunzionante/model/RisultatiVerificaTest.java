/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

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
public class RisultatiVerificaTest {
    
    public RisultatiVerificaTest() {
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
     * Test of getValido method, of class RisultatiVerifica.
     */
    @Test
    public void testGetValido() {
        System.out.println("getValido");
        RisultatiVerifica instance = null;
        boolean expResult = false;
        boolean result = instance.getValido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessaggio method, of class RisultatiVerifica.
     */
    @Test
    public void testGetMessaggio() {
        System.out.println("getMessaggio");
        RisultatiVerifica instance = null;
        String expResult = "";
        String result = instance.getMessaggio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of risultatoPositivo method, of class RisultatiVerifica.
     */
    @Test
    public void testRisultatoPositivo() {
        System.out.println("risultatoPositivo");
        RisultatiVerifica expResult = null;
        RisultatiVerifica result = RisultatiVerifica.risultatoPositivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of risultatoNegativo method, of class RisultatiVerifica.
     */
    @Test
    public void testRisultatoNegativo() {
        System.out.println("risultatoNegativo");
        String messaggio = "";
        RisultatiVerifica expResult = null;
        RisultatiVerifica result = RisultatiVerifica.risultatoNegativo(messaggio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
