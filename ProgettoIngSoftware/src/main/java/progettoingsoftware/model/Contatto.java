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
    * @param[in] nome Nome del contatto.
    * @param[in] cognome Cognome del contatto.
    * @param[in] mail[] Mail del contatto.
    * @param[in] num[] Numeri del contatto.
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
    * @return cognome Il cognome del contatto.
    */
    public String getCognome() {
        return cognome;
    }
    
    /**
    * @brief Ottiene la mail i-esima del Contatto
    * 
    * @param[in] i Indice della Mail.
    * @return mail La mail i-esima del contatto.
    */
    public String getMail(int i) {
        return mail[i];
    }

    /**
    * @brief Ottiene il numero di telefono i-esimo del Contatto
    * 
    * @param[in] i Indice del Numero
    * @return num Il numero i-esimo del Contatto.
    */
    public String getNum(int i) {
        return num[i];
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
    * @param[in] i L'indice del contatto da impostare.
    * @param[in] mail Le mail del contatto.
    */
    public void setMail(String mail, int i) {
        this.mail[i] = mail;
    }
    
    /**
    * @brief Imposta i numeri del contatto.
    * 
    * @param[in] num I nuovi numeri del contatto.
    * @param[in] i L'indice del contatto da impostare.
    */
    public void setNum(String num, int i) {
        this.num[i] = num;
    }
}