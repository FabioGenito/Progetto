/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//@author Gruppo14

public class Rubrica{
    
    private List<Contatto> contatti;

    /**
    * Costruttore della Classe Rubrica
    */
    public Rubrica(){
        contatti = new ArrayList<Contatto>();
    }
    
    /**
    * Ottiene la Lista dei Contatti
    * 
    * @return contatti Rappresenta la lista dei contatti.
    */
    public List<Contatto> getContatti() {
        return contatti;
    }
    
    
    /**
    * Aggiunge un Contatto alla Lista
    * 
    * @param c Contatto da Aggiungere alla Lista.
    */  
    public void aggiungiContatto(Contatto c) {
        contatti.add(c);
    }

    /**
    * Modifica le Informazioni di un Contatto della Lista
    * 
    * @param c Contatto da Modificare nella Lista.
    */
    public void modificaContatto(int i, Contatto c) {
        contatti.set(i, c);
    }

    /**
    * Rimuove un Contatto dalla Lista
    * 
    * @param c Contatto da rimuovere dalla Lista.
    */
    public void eliminaContatto(Contatto c) {
        contatti.remove(c);
    }
}
