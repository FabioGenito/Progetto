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
public class VerificaTest {
    
    public VerificaTest() {
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
     * Test of VerificaNumero method, of class Verifica.
     */
    @Test
    public void testVerificaNumero() {
        System.out.println("VerificaNumero");
        String number = "";
        boolean expResult = false;
        boolean result = Verifica.VerificaNumero(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerificaEmail method, of class Verifica.
     */
    @Test
    public void testVerificaEmail() {
        System.out.println("VerificaEmail");
        String mail = "";
        boolean expResult = false;
        boolean result = Verifica.VerificaEmail(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifica method, of class Verifica.
     */
    @Test
    public void testVerifica() {
        System.out.println("verifica");
        String name = "";
        String surname = "";
        String[] numeri = null;
        String[] mail = null;
        RisultatiVerifica expResult = null;
        RisultatiVerifica result = Verifica.verifica(name, surname, numeri, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
