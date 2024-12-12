/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfunzionante.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import com.mycompany.testfunzionante.model.*;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 * @brief Classe adibita al collegamento tra la View e le strutture dati (Rubrica e Contatto)
 *
 * @author Gruppo14
 */
public class RubricaController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField numberField1;
    @FXML
    private TextField numberField2;
    @FXML
    private TextField numberField3;
    @FXML
    private TextField mailField1;
    @FXML
    private TextField mailField2;
    @FXML
    private TextField mailField3;
    @FXML
    private Button AddButton;
    @FXML
    private Button modButton;
    @FXML
    private Button delButton;
    @FXML
    private TableView<Contatto> Tabella;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    
    private Rubrica rubrica;
    private ObservableList<Contatto> listaContatti;
    @FXML
    private TextField searchField;
    @FXML
    private Button Esport;
    @FXML
    private Button Import;
    @FXML
    private TableColumn<Contatto, String> numClm;
    @FXML
    private TableColumn<Contatto, String> mailClm;
    @FXML
    private TableColumn<Contatto, String> numClm2;
    @FXML
    private TableColumn<Contatto, String> numClm3;
    @FXML
    private TableColumn<Contatto, String> mailClm2;
    @FXML
    private TableColumn<Contatto, String> mailClm3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica(); 
        listaContatti = FXCollections.observableArrayList(rubrica.getContatti());
        Tabella.setItems(listaContatti);

        nameClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        surnameClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCognome()));
        numClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNum(0)));
        mailClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMail(0)));
        
        surnameClm.setSortType(TableColumn.SortType.ASCENDING);
        Tabella.getSortOrder().add(surnameClm);
    }    

    /**
    * @brief Verifica del numero di telefono
    * 
    * @param[in] number Numero di telefono 
    * @pre Deve essere inserito una stringa numerica.
    * 
    * @post Se il numero inserito presenta dei caratteri non numerici viene restituito False
    * 
    */
    private boolean isValidNumber(String number) {
        return number.matches("\\d+");
    }
    
    /**
    * @brief Verifica e-mail
    * 
    * @param[in] mail 
    * @pre Deve essere inserito una e-mail.
    * 
    * @post Se la mail inserita presenta uno spazio iniziale, una "@" iniziale
    *       un dominio non valido, o l'assenza della "@" viene restituito False
    * 
    */
    private boolean isValidEmail(String mail) {
        return mail.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }
    
    /**
    * @brief Verifica Dati
    * 
    * @param[in] numeri Numeri di Telefono da controllare
    * @param[in] mail Mail da Controllare
    * 
    * @post In base ai dati inseriti viene resituto un valore booleano che indica se essi
    *       sono validi o meno, inoltre viene mostrato un avviso in caso di dati non validi
    *       contenente il motivo dell'esito negativo.
    * 
    */
    private boolean verifica(String[] numeri, String[] mail) {
        if(nameField.getText().isEmpty() && surnameField.getText().isEmpty()) {
            showAlert("Devi compilare almeno un campo tra nome e cognome");
            return false;
        }
        
        for(String numero : numeri) {
            if(!numero.isEmpty() && !isValidNumber(numero)) {
                showAlert("Il numero non può contenere caratteri");
                return false;
            }
        }

        for(String email : mail) {
            if(!email.isEmpty() && !isValidEmail(email)) {
                showAlert("La mail non è valida");
                return false;
            }
        }
        return true;
    }
    
    /**
    * @brief mostra Avviso
    * 
    * @param[in] txt Messaggio di errore 
    * 
    * 
    *@post Viene creata una finestra di avviso relativa all'errore
    * 
    */
    private void showAlert(String txt) {
        Alert alert = new Alert(ERROR);
        alert.setTitle("Alert");
        alert.setContentText(txt);
        alert.showAndWait();
    }
    
    private void clear() {
        nameField.clear();
        surnameField.clear();
        numberField1.clear();
        numberField2.clear();
        numberField3.clear();
        mailField1.clear();
        mailField2.clear();
        mailField3.clear();
    }
    
    
    /**
    * @brief Aggiunta di un Contatto.
    * 
    * 
    * Provvede alla creazione di una nuova Istanza della 
    * classe "Contatto" , all'aggiunta di tale istanza nella
    * lista grafica e nella struttura dati sottostante.
    * Guarda Anche il metodo aggiungiContatto() della classe Rubrica.
    * Se non viene compilati i campi nome e cognome viene invocato il metodo showAlert(),
    * Viene effettuato un controllo sui campi numero e mail per verificarne la validità
    *   attraverso i metodi isValidEmail(),isValidNumber().
    * 
    * 
    * @param[in] event Click tasto "Aggiungi".
    * 
    * @pre  I campi "nameField" e "surnameField" devono essere compilati almeno in parte. I campi opzionali "number1Field", "number2Field"
    *       "number3Field", "mail1Field", "mail2Field", "mail3Field" possono essere vuoti.
    *       
    * @post Un nuovo contatto è aggiunto sia alla lista grafica che alla struttura dati sottostante.
    *       
    * @invariant La lista dei contatti deve essere coerente con la struttura dati sottostante.
    * 
    * @see aggiungiContatto(), isValidEmail(),isValidNumber(),showAlert().
    */
   @FXML
    private void add(ActionEvent event) {
        String[] numeri = new String[3];
        numeri[0] = numberField1.getText();
        numeri[1] = numberField2.getText();
        numeri[2] = numberField3.getText();
        
        if(nameField.getText().isEmpty() && surnameField.getText().isEmpty()) {
            showAlert("Devi compilare almeno un campo tra nome e cognome");
            return;
        }
        
        for(String numero : numeri) {
            if(!numero.isEmpty() && !isValidNumber(numero)) {
                showAlert("Il numero non può contenere caratteri");
                return;
            }
        }

        String[] mail = new String[3];
        mail[0] = mailField1.getText();
        mail[1] = mailField2.getText();
        mail[2] = mailField3.getText();
        
        for(String email : mail) {
            if(!email.isEmpty() && !isValidEmail(email)) {
                showAlert("La mail non è valida");
                return;
            }
        }

        Contatto c = new Contatto(nameField.getText(), surnameField.getText(), mail, numeri);
        rubrica.aggiungiContatto(c); 
        listaContatti.add(c); 
        Tabella.getSortOrder().add(surnameClm);
        clear();
    }

    /**
    * @brief Modifica delle informazioni di un Contatto.
    * 
    * Provvede alla modifica del contatto
    * selezionato (nella lista grafica), aggiornando sia
    * la lista grafica che la struttura dati.
    * Guarda anche il metodo modificaContatto() della classe Rubrica.
    * 
    * @param[in] event Click del pulsante "Salva"
    * @pre Deve essere selezionato un contatto valido nella lista.
    * 
    * @post Il contatto modificato riflette le nuove informazioni sia nella lista grafica che nella struttura dati.
    *      
    * @invariant La lista dei contatti e la struttura dati sottostante devono rimanere sincronizzate.
    * 
    * @see modificaContatto().
    */
    @FXML
    private void mod(ActionEvent event) {
        String numeri[] = {numberField1.getText(), numberField2.getText(), numberField3.getText()};
        String mail[] = {mailField1.getText(), mailField2.getText(), mailField3.getText()};
        
        if(verifica(numeri, mail)) {     // Chiamo la funzione di Verifica delle modifiche effettuate
            Contatto c = new Contatto(nameField.getText(), surnameField.getText(), numeri, mail); 
            int i = Tabella.getSelectionModel().getSelectedIndex();
            rubrica.modificaContatto(i, c);
            listaContatti.set(i, c);
            clear();
        }
    }

    /**
    * @brief Rimozione dalla Lista.
    * 
    * 
    * Provvede alla rimozione del contatto
    * selezionato (nella lista grafica), aggiornando 
    * sia la lista grafica che la struttura dati.
    * Guarda anche il metodo eliminaContatto() della classe Rubrica
    * 
    * @param[in] event Pressione del pulsante "Elimina".
    * 
    * @pre Deve essere selezionato un contatto valido nella lista.
    * 
    * @post Il contatto selezionato è rimosso dalla lista grafica e dalla struttura dati.
    *      
    * @invariant La lista grafica e la struttura dati devono essere coerenti dopo la rimozione.
    * 
    * @see eliminaContatto().
    */
    @FXML
    private void del(ActionEvent event) {
        Contatto c = Tabella.getSelectionModel().getSelectedItem();
        rubrica.eliminaContatto(c);
        listaContatti.remove(c);
        Tabella.getSortOrder().add(surnameClm);
    }

    /**
    * @brief Ricerca di un Contatto.
    * 
    * Provvede al filtraggio grafico della lista
    * in funzione del contenuto della stringa di ricerca.
    * Guarda anche il metodo ricercaContatto() della classe Rubrica.
    * 
    * @param[in] event Cambiamenti del testo nella Barra di Ricerca
    * 
    * @pre La lista grafica deve essere inizializzata e contenere almeno un elemento.
    *      
    * @post I risultati del filtraggio sono visibili nella lista grafica in tempo reale.
    *       
    * @invariant La struttura dati sottostante non è alterata  dal processo di ricerca.
    * 
    * @see ricercaContatto().
    */
    @FXML
    private void search(KeyEvent event) {
        
    }

    /**
    * @brief Invoca il metodo dedicato per esportare la Rubrica su un File Esterno.
    * Guarda anche il metodo esportaRubrica() della classe GestioneFile.
    * 
    * @param[in] event Click sul Pulsante "Esporta Rubrica".
    * 
    * @pre La rubrica deve contenere almeno un contatto.
    * 
    * @post Il file esterno contenente i contatti è generato correttamente.
    *       
    * @invariant La struttura dati della rubrica non è alterata dal processo di esportazione.
    * 
    * @see esportaRubrica().
    */
    @FXML
    private void esportList(ActionEvent event) {
    }

    /**
    * @brief Invoca il metodo dedicato per importare da un File esterno una Lista di Contatti.
    * Guarda anche il metodo importaFile() della classe GestioneFile.
    * 
    * @param[in] event Click sul Pulsante "Importa Rubrica".
    * 
    * @pre Il file esterno deve essere valido e formattato correttamente.
    *      
    * @post La rubrica è aggiornata con i contatti importati.
    * 
    * @invariant La struttura dati della rubrica deve essere coerente dopo l'importazione.
    * 
    * @see importaFile().
    */
    @FXML
    private void importList(ActionEvent event) {
    }
    
    
    @FXML
    private void selection(MouseEvent event) {
	Contatto c = Tabella.getSelectionModel().getSelectedItem();
        nameField.setText(c.getNome());
        surnameField.setText(c.getCognome());
        numberField1.setText(c.getNum(0));
	numberField2.setText(c.getNum(1));
        numberField3.setText(c.getNum(2));
        mailField1.setText(c.getMail(0));
        mailField2.setText(c.getMail(1));
        mailField3.setText(c.getMail(2));        
    }
}

