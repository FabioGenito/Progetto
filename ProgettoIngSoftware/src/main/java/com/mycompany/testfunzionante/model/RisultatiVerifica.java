/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.model;

/**
 *
 * @author Gruppo 14
 */
public class RisultatiVerifica {
    private final boolean valido;
    private final String messaggio;

    /**
    * Costruttore della classe ValidationResult.
    *
    * @param[in] valido esito della verifica.
    * @param[in] messaggio Stringa contentene il messaggio di errore.
    */
    public RisultatiVerifica(boolean valido, String messaggio) {
        this.valido = valido;
        this.messaggio = messaggio;
    }
    
    /***
    * Getter di IsValid
    * 
    * @return isValid esito della verifica;
    */
    public boolean getValido() {
        return valido;
    }

    /***
    * Getter di ErrorMessage
    * 
    * @return errorMessage Stringa di testo contentene il messaggio di errore;
    */
    public String getMessaggio() {
        return messaggio;
    }

    /***
    * Verifica Positiva
    * 
    * @return ValidationResult(true, null) rappresenta un'esito positivo alla verifica che non contiene messsaggi di errore.
    */
    public static RisultatiVerifica risultatoPositivo() {
        return new RisultatiVerifica(true, null);
    }

    /***
    * Verifica Negativa
    * 
    * @param[in] errorMessage messaggio di errore.
    * @return ValidationResult(false, errorMessage) rappresenta un'esito negativo alla verifica che contiene il messsaggio di errore associato.
    */
    public static RisultatiVerifica risultatoNegativo(String messaggio) {
        return new RisultatiVerifica(false, messaggio);
    }
}

