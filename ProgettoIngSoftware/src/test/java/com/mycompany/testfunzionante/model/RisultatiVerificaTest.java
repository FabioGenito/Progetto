package com.mycompany.testfunzionante.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gruppo 14
 * 
 */
public class RisultatiVerificaTest {

    private RisultatiVerifica instance;

    @BeforeEach
    public void setUp() {
       
    }

    @AfterEach
    public void tearDown() {
        
    }

    /**
     * Test del metodo getValido, della classe RisultatiVerifica.
     */
    @Test
    public void testGetValido() {
        System.out.println("getValido");
        
        
        instance = RisultatiVerifica.risultatoPositivo();
        assertTrue(instance.getValido());
        
        
        instance = RisultatiVerifica.risultatoNegativo("Errore");
        assertFalse(instance.getValido());
    }

    /**
     * Test del metodo getMessaggio, della classe RisultatiVerifica.
     */
    @Test
    public void testGetMessaggio() {
        System.out.println("getMessaggio");

       
        instance = RisultatiVerifica.risultatoPositivo();
        assertNull(instance.getMessaggio());

        
        instance = RisultatiVerifica.risultatoNegativo("Errore");
        assertEquals("Errore", instance.getMessaggio());
    }

    /**
     * Test del metodo risultatoPositivo, della classe RisultatiVerifica.
     */
    @Test
    public void testRisultatoPositivo() {
        System.out.println("risultatoPositivo");
        
        instance = RisultatiVerifica.risultatoPositivo();
        assertTrue(instance.getValido());
        assertNull(instance.getMessaggio());
    }

    /**
     * Test del metodo risultatoNegativo, della classe RisultatiVerifica.
     */
    @Test
    public void testRisultatoNegativo() {
        System.out.println("risultatoNegativo");
        
        String messaggio = "Errore di verifica";
        instance = RisultatiVerifica.risultatoNegativo(messaggio);
        
        assertFalse(instance.getValido());
        assertEquals(messaggio, instance.getMessaggio());
    }
}