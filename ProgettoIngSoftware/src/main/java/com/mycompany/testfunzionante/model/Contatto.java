/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;
/**
 *
 * @author Gruppo14
 */

public class Contatto {
    private String nome;
    private String cognome;
    private String[] mail;
    private String[] num;
    
    
    /**
    * Costruttore della classe Contatto.
    *
    * @param nome Nome del contatto.
    * @param cognome Cognome del contatto.
    * @param mail Mail del contatto.
    * @param num Numeri del contatto
    */
    public Contatto(String nome, String cognome, String[] num, String[] mail) {
        //i++;
        this.nome = nome;
        this.cognome = cognome;
        this.num = num;
        this.mail = mail;
    }

    /**
    * Ottiene il nome del Contatto
    * 
    * @return nome Il nome del contatto.
    */
    public String getNome() {
        return nome;
    }
    
    /**
    * Ottiene il cognome del Contatto
    * 
    * @return cognome Il conome del contatto.
    */
    public String getCognome() {
        return cognome;
    }
    
    /**
    * Ottiene le mail del Contatto
    * 
    * @param i Indice della Mail.
     * @return mail[i] Mail di Ritorno
    */
    public String getMail(int i) {
        return mail[i];
    }

    /**
    * Ottiene i numeri di telfono del Contatto
    * 
    * @param i Indice del Numero.
    * @return num I numeri del Contatto.
    */
    public String getNum(int i) {
        return num[i];
    }

    /**
    * Imposta il nome del contatto.
    * 
    * @param nome Il nuovo nome del contatto.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
    * Imposta il cognome del contatto.
    * 
    * @param cognome Il nuovo cognome del contatto.
    */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /**
    * Imposta le mail del contatto.
    * 
    * @param mail Le mail del contatto.
    */
    public void setMail(String[] mail) {
        this.mail = mail;
    }
    
    /**
    * Imposta i numeri del contatto.
    * 
    * @param num I nuovi numeri del contatto.
    */
    public void setNum(String[] num) {
        this.num = num;
    }
}