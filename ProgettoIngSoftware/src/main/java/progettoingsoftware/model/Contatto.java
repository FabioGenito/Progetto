/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.model;

/**
 *
 * @author User
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String[] mail;
    private String[] num;
    
    public Contatto(String nome, String cognome, String[] mail, String[] num) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String[] getMail() {
        return mail;
    }

    public String[] getNum() {
        return num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setMail(String[] mail) {
        this.mail = mail;
    }

    public void setNum(String[] num) {
        this.num = num;
    }
    
}
