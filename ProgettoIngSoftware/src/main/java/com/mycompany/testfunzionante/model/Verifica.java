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
public class Verifica {
    
    /***
    * Verifica se il Numero è valido
    * 
    * @param[in] number il numero da controllare
    * @return number.matches() esito della verifica 
    */     
    public static boolean VerificaNumero(String number) {
        return number.matches("\\d+");
    }

    /***
    * Verifica se la Mail è valida
    * 
    * @param[in] mail la mail da controllare
    * @return mail.matches() esito della verifica 
    */
    public static boolean VerificaEmail(String mail) {
        return mail.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    } 
    
    /***
    * Verifica se il contatto è valido
    * 
    * @param[in] name il nome da controllare.
    * @param[in] surname il cognome da controllare.
    * @param[in] numeri l'array di numeri da controllare.
    * @param[in] mail l'array di mail da controllare.
    * 
    * @return mail.matches() esito della verifica 
    */
    public static RisultatiVerifica verifica(String name, String surname, String[] numeri, String[] mail) {
        if(name.isEmpty() && surname.isEmpty()) return RisultatiVerifica.risultatoNegativo("Devi compilare almeno un campo tra nome e cognome.");
        
        for(String numero : numeri) {
            if(numero.isEmpty()) return RisultatiVerifica.risultatoPositivo();
            if(!numero.isEmpty() && !VerificaNumero(numero)) return RisultatiVerifica.risultatoNegativo("Il numero non può avere caratteri non numerici e non deve avere prefissi internazionali");
            if(!numero.isEmpty() && numero.length() < 10) return RisultatiVerifica.risultatoNegativo("Il numero inserito è troppo corto.");
            if(!numero.isEmpty() && numero.length() > 10) return RisultatiVerifica.risultatoNegativo("Il numero inserito è troppo lungo.");
        }

        for(String email : mail) {
            if(!email.isEmpty() && !VerificaEmail(email)) return RisultatiVerifica.risultatoNegativo("La mail inserita non è valida.");
        }
        return RisultatiVerifica.risultatoPositivo();
    }
}

