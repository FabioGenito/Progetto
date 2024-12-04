/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeSet;

//@author Gruppo14

public class Rubrica{
    
private Set<Contatto> contatti;
    
    public Rubrica(TreeSet<Contatto> contatti){
        this.contatti = contatti;
    }
    
    public void selezionaContatto(int i) {
        
    }

    public void creaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modificaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminaContatto(Contatto c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public TreeSet<Contatto> ricercaContatto(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

