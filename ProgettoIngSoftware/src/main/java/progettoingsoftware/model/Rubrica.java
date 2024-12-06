/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @brief Classe adibita alla gestione dei metodi legati alla collezione di contatti.
 * @author Gruppo14
*/


public class Rubrica{
    
    private List<Contatto> contatti;

    /**
    * @brief Costruttore della Classe Rubrica
    */
    public Rubrica(){
        contatti = new ArrayList<Contatto>();
    }
    
    /**
    * @brief Ottiene la Lista dei Contatti
    * 
    * @return contatti Rappresenta la lista dei contatti.
    */
    public List<Contatto> getContatti() {
        return contatti;
    }
    
    
    /**
    * @brief Aggiunge un Contatto alla Lista
    * 
    * @param[in] c Contatto da Aggiungere alla Lista.
    */  
    public void aggiungiContatto(Contatto c) {
        contatti.add(c);
    }

    /**
    * @brief Modifica le Informazioni di un Contatto della Lista
    * 
    * @param[in] c Contatto da Modificare nella Lista.
    */
    public void modificaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * @brief Rimuove un Contatto dalla Lista
    * 
    * @param[in] c Contatto da rimuovere dalla Lista.
    */
    public void eliminaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * @brief Cerca un Contatto nella Lista
    * 
    * La ricerca avviene attraverso il passaggio alla funzione 
    * di una stringa; la funzione ricerca nella Lista tutti i 
    * contatti il cui cognome o il nome corrisponda a tale stringa 
    * o inizi per essa 
    * 
    * @param[in] s Stringa con cui ricercare corrispondenze nella Lista.
    * @return lista Lista Filtrata.
    */
    public TreeSet<Contatto> ricercaContatto(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}