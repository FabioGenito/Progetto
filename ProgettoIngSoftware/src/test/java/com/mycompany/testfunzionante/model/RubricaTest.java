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
 * @author Gruppo 14
 */
public class RubricaTest {

    private Rubrica rubrica;
    private Contatto contatto1;
    private Contatto contatto2;

    public RubricaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Eseguito una sola volta prima di tutti i test
    }

    @AfterAll
    public static void tearDownClass() {
        // Eseguito una sola volta dopo tutti i test
    }

    @BeforeEach
    public void setUp() {
        // Setup eseguito prima di ogni test
        rubrica = new Rubrica();
        contatto1 = new Contatto("Mario", "Rossi", new String[]{"12345"}, new String[]{"mario.rossi@example.com"});
        contatto2 = new Contatto("Luigi", "Verdi", new String[]{"67890"}, new String[]{"luigi.verdi@example.com"});
    }

    @AfterEach
    public void tearDown() {
        // Reset dopo ogni test
        rubrica = null;
        contatto1 = null;
        contatto2 = null;
    }

    /**
     * Test del metodo getContatti, della classe Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        assertTrue(rubrica.getContatti().isEmpty(), "La rubrica deve essere inizialmente vuota");

        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        List<Contatto> result = rubrica.getContatti();
        assertEquals(2, result.size(), "La rubrica deve contenere 2 contatti");
        assertTrue(result.contains(contatto1), "La rubrica deve contenere il contatto1");
        assertTrue(result.contains(contatto2), "La rubrica deve contenere il contatto2");
    }

    /**
     * Test del metodo aggiungiContatto, della classe Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        rubrica.aggiungiContatto(contatto1);
        assertEquals(1, rubrica.getContatti().size(), "La rubrica deve contenere 1 contatto dopo l'aggiunta");
        assertTrue(rubrica.getContatti().contains(contatto1), "La rubrica deve contenere il contatto aggiunto");
    }

    /**
     * Test del metodo modificaContatto, della classe Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        rubrica.aggiungiContatto(contatto1);

        Contatto nuovoContatto = new Contatto("Giulia", "Bianchi", new String[]{"54321"}, new String[]{"giulia.bianchi@example.com"});
        rubrica.modificaContatto(0, nuovoContatto);

        List<Contatto> result = rubrica.getContatti();
        assertEquals(1, result.size(), "La rubrica deve contenere ancora 1 contatto dopo la modifica");
        assertEquals("Giulia", result.get(0).getNome(), "Il nome del contatto deve essere aggiornato");
        assertEquals("Bianchi", result.get(0).getCognome(), "Il cognome del contatto deve essere aggiornato");
    }

    /**
     * Test del metodo eliminaContatto, della classe Rubrica.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("eliminaContatto");
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        rubrica.eliminaContatto(contatto1);
        List<Contatto> result = rubrica.getContatti();

        assertEquals(1, result.size(), "La rubrica deve contenere 1 contatto dopo la rimozione");
        assertFalse(result.contains(contatto1), "La rubrica non deve contenere il contatto rimosso");
        assertTrue(result.contains(contatto2), "La rubrica deve ancora contenere il contatto non rimosso");
    }
}
