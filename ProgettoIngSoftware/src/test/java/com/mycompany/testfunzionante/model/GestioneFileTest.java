/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

import java.io.File;
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
public class GestioneFileTest {
    
    public GestioneFileTest() {
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
     * Test of esportaRubrica method, of class GestioneFile.
     */
    @Test
    public void testEsportaRubrica() throws Exception {
        System.out.println("esportaRubrica");
        Rubrica rubrica = null;
        GestioneFile.esportaRubrica(rubrica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importaRubrica method, of class GestioneFile.
     */
    @Test
    public void testImportaRubrica() throws Exception {
        System.out.println("importaRubrica");
        File file = null;
        List<Contatto> expResult = null;
        List<Contatto> result = GestioneFile.importaRubrica(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
