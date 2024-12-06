/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @brief Classe adibita alla gestione di operazioni su File
 * 
 * @author Gruppo14
 */

public class GestioneFile {
    
    /**
    * @brief Esporta l'intera Rubrica su un file esterno
    * 
    * @param[in] file File di Destinazione 
    */    
    public void esportaRubrica(FileOutputStream file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
    * @brief Importa da un file esterno una Rubrica
    * 
    * Preleva da un file esterno una serie di informazioni
    * da cui crea una rubrica che verrà sostituita a quella
    * eventualmente già esistente nel sistema.
    * 
    * @param[in] file File Sorgente 
    * @return newRubrica Rubrica 
    */    
    public ArrayList<Contatto> importaRubrica(FileInputStream file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}