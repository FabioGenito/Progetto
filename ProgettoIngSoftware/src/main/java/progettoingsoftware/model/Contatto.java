/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.model;

/**
 * @brief Classe adibita alla gestione dei metodi legati al singolo Contatto
 * @author Gruppo14
 */

public class Contatto {
    private String nome;
    private String cognome;
    private String[] mail;
    private String[] num;
    
    /**
    * @brief Costruttore della classe Contatto.
    *
    * @param nome
    * @param[in] cognome Cognome del contatto.
    * @param[in] mail Mail del contatto.
    * @param[in] num Numeri del contatto
    */
    public Contatto(String nome, String cognome, String[] mail, String[] num) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.num = num;
    }

    /**
    * @brief Ottiene il nome del Contatto
    * 
    * @return nome Il nome del contatto.
    */
    public String getNome() {
        return nome;
    }
    
    /**
    * @brief Ottiene il cognome del Contatto
    * 
    * @return cognome Il conome del contatto.
    */
    public String getCognome() {
        return cognome;
    }
    
    /**
    * @brief Ottiene le mail del Contatto
    * 
    * @return mail Le mail del contatto.
    */
    public String[] getMail() {
        return mail;
    }

    /**
    * @brief Ottiene i numeri di telfono del Contatto
    * 
    * @return num I numeri del Contatto.
    */
    public String[] getNum() {
        return num;
    }

    /**
    * @brief Imposta il nome del contatto.
    * 
    * @param[in] nome Il nuovo nome del contatto.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
    * @brief Imposta il cognome del contatto.
    * 
    * @param[in] cognome Il nuovo cognome del contatto.
    */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /**
    * @brief Imposta le mail del contatto.
    * 
    * @param[in] mail Le mail del contatto.
    */
    public void setMail(String[] mail) {
        this.mail = mail;
    }
    
    /**
    * @brief Imposta i numeri del contatto.
    * 
    * @param[in] num I nuovi numeri del contatto.
    */
    public void setNum(String[] num) {
        this.num = num;
    }
}