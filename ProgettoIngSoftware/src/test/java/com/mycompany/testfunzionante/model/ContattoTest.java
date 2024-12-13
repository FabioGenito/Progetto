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
public class ContattoTest {

    Contatto contatto;

    @BeforeEach
    public void setUp() {
        // Dati di esempio per i test
        String[] mail = {"esempio1@mail.com", "esempio2@mail.com"};
        String[] numeri = {"123456789", "987654321"};
        contatto = new Contatto("Mario", "Rossi", numeri, mail);
    }
    
    @AfterEach
    public void tearDown() {
        contatto = null; 
    }

    @Test
    public void testGetNome() {
        String expected = "Mario";
        String actual = contatto.getNome();
        assertEquals(expected, actual, "Il nome restituito non corrisponde al valore atteso.");
    }

    @Test
    public void testGetCognome() {
        String expected = "Rossi";
        String actual = contatto.getCognome();
        assertEquals(expected, actual, "Il cognome restituito non corrisponde al valore atteso.");
    }

    @Test
    public void testGetMail() {
        String expected = "esempio1@mail.com";
        String actual = contatto.getMail(0);
        assertEquals(expected, actual, "La mail restituita non corrisponde al valore atteso.");
    }

    @Test
    public void testGetNumero() {
        String expected = "123456789";
        String actual = contatto.getNumero(0);
        assertEquals(expected, actual, "Il numero restituito non corrisponde al valore atteso.");
    }

    @Test
    public void testSetNome() {
        String newNome = "Luigi";
        contatto.setNome(newNome);
        assertEquals(newNome, contatto.getNome(), "Il nome non è stato aggiornato correttamente.");
    }

    @Test
    public void testSetCognome() {
        String newCognome = "Verdi";
        contatto.setCognome(newCognome);
        assertEquals(newCognome, contatto.getCognome(), "Il cognome non è stato aggiornato correttamente.");
    }

    @Test
    public void testSetMail() {
        String[] newMail = {"nuova@mail.com", "altra@mail.com"};
        contatto.setMail(newMail);
        assertArrayEquals(newMail, new String[]{contatto.getMail(0), contatto.getMail(1)}, "Le mail non sono state aggiornate correttamente.");
    }

    @Test
    public void testSetNumero() {
        String[] newNumeri = {"555555555", "444444444"};
        contatto.setNumero(newNumeri);
        assertArrayEquals(newNumeri, new String[]{contatto.getNumero(0), contatto.getNumero(1)}, "I numeri non sono stati aggiornati correttamente.");
    }
}