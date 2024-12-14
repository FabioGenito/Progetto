/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.FileChooser;

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
    static public void esportaRubrica(Rubrica rubrica) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Esporta Rubrica");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        File file = fileChooser.showSaveDialog(null);
        if (file == null) return;
        try( PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter(file)))) {
            
            pw.println("Nome;Cognome;Primo Numero;Secondo Numero;Terzo Numero;Prima Mail;Seconda Mail; Terza Mail");
            for(Contatto c : rubrica.getContatti()) {
                pw.print(c.getNome());
                pw.append(";");
                
                pw.print(c.getCognome());
                pw.append(";");

                for(int i = 0; i<3; i++) {
                    pw.print(c.getNumero(i));
                    pw.append(";");
                }

                for(int i = 0; i<2; i++) {
                    pw.print(c.getMail(i));
                    pw.append(";");
                }
                pw.println(c.getMail(2));
            }
        }    
    }

    /**
    * @brief Importa da un file esterno una Rubrica
    * 
    * Preleva da un file esterno una serie di informazioni
    * da cui crea una rubrica che verrà sostituita a quella
    * eventualmente già esistente nel sistema.
    * 
    * @param[in] file File Sorgente 
    * 
    * @return newRubrica Rubrica 
    */    
    static public List<Contatto> importaRubrica(File file) throws FileNotFoundException, IOException {
        List<Contatto> r = new ArrayList();
        try( BufferedReader br = new BufferedReader( new FileReader(file))) {
            
            String header = br.readLine(); 
            if (header == null) return r;
           
            String line;
            while((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Ignora righe vuote
                String fields[] = line.split(";");
                String[] numeri = {ottieniCampo(fields, 2), ottieniCampo(fields, 3), ottieniCampo(fields, 4)};
                String[] mail = {ottieniCampo(fields, 5), ottieniCampo(fields, 6), ottieniCampo(fields, 7)};
                Contatto c = new Contatto(ottieniCampo(fields, 0), ottieniCampo(fields, 1), numeri, mail);
                r.add(c);
            }
        }
        return r;
    }

    private static String ottieniCampo(String[] fields, int index) {
        return index < fields.length ? fields[index] : "";
    }
}