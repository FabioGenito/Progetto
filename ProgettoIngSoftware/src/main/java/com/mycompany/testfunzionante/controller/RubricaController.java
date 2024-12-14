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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

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
    private Button AddButton;
    @FXML
    private Button modButton;
    @FXML
    private Button delButton;
    @FXML
    private TextField searchField;
    @FXML
    private Button Esport;
    @FXML
    private Button Import;
    @FXML
    private TableView<Contatto> Tabella;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> numClm;
    @FXML
    private TableColumn<Contatto, String> mailClm;
    private Rubrica rubrica;
    private ObservableList<Contatto> listaContatti;
    @FXML
    private TableColumn<Contatto, String> numClm2;
    @FXML
    private TableColumn<Contatto, String> numClm3;
    @FXML
    private TableColumn<Contatto, String> mailClm2;
    @FXML
    private TableColumn<Contatto, String> mailClm3;
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
    private Label TotalLabel;
    
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
        numClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumero(0)));
        numClm2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumero(1)));
        numClm3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumero(2)));
        mailClm.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMail(0)));
        mailClm2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMail(1)));
        mailClm3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMail(2)));
        Tabella.getSortOrder().add(surnameClm);
    }  

    /**
    * Ottiene il numero totale di Contatti presenti in rubrica.
    */
    private void conteggioContatti() {
        TotalLabel.setText(String.valueOf(listaContatti.size()));
    }
    
    /**
    * Ordina la Tabella su criterio Alfabatico, dando priorità prima ai Cognomi e poi ai Nomi.
    */
    private void ordinaTabella() {
        Tabella.getSelectionModel().clearSelection();
        Tabella.getSortOrder().add(surnameClm);
    }
    
    /**
    * Crea una Finestra di Dialogo di Info
    * 
    * @return Un valore intero che indica quale pulsante è stato premuto 
    */
    private int mostraInfo() {
        // Visualizzazione Dialogo per Scelta tra Sovrascrittura, Aggiunta o Annullo Operazione
        Alert alert = new Alert(Alert.AlertType.INFORMATION);        
        alert.setTitle("Scelta");
        alert.setHeaderText("Scelta");
        alert.setContentText("Vuoi Sovrascrivere la rubrica attuale o aggiunger i contatti in coda?");
        
        // Descrizione dei 3 Pulsanti Personalizzati
        ButtonType buttonTypeOne = new ButtonType("Sovrascrivi");
        ButtonType buttonTypeTwo = new ButtonType("Aggiungi");
        ButtonType buttonTypeCancel = new ButtonType("Annulla");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        Optional<ButtonType> risultato = alert.showAndWait();
        if(risultato.isPresent()) {
            if(risultato.get() == buttonTypeOne) return 1;
            if(risultato.get() == buttonTypeTwo) return 2;
        }
        return 0;
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
    private void mostraErrore(String txt) {
        Alert alert = new Alert(ERROR);
        alert.setTitle("Alert");
        alert.setContentText(txt);
        alert.showAndWait();
    }
    
    /**
    * Crea una Finestra di Dialogo di Conferma
    * 
    * @return un valore che indica se continuare l'operazione o annullarla. 
    */
    private Optional<ButtonType> mostraConferma() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);          // Creo un nuovo messaggio di Conferma
        alert.setTitle("Conferma");
        alert.setHeaderText("Conferma Eliminazione");
        alert.setContentText("Vuoi continuare?");
        return alert.showAndWait();
    }
    
    /**
    * Pulisce tutti i Fields del modulo e anche l'eventuale selzione effettuata sulla Tabella
    */
    private void pulisci() {
        nameField.clear();
        surnameField.clear();
        numberField1.clear();
        numberField2.clear();
        numberField3.clear();
        mailField1.clear();
        mailField2.clear();
        mailField3.clear();
        Tabella.getSelectionModel().clearSelection();
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
    private void aggiungi(ActionEvent event) {
        String numeri[] = {numberField1.getText(), numberField2.getText(), numberField3.getText()};
        String mail[] = {mailField1.getText(), mailField2.getText(), mailField3.getText()};
                
        // Chiamo la funzione di Verifica dei Dati
        RisultatiVerifica risultato = Verifica.verifica(nameField.getText(), surnameField.getText(), numeri, mail);

        if(risultato.getValido()) {
            Contatto c = new Contatto(nameField.getText(), surnameField.getText(), numeri, mail);
            rubrica.aggiungiContatto(c); 
            listaContatti.add(c); 
            pulisci();
        }
        else mostraErrore(risultato.getMessaggio());
        ordinaTabella();
        conteggioContatti();
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
    private void modifica(ActionEvent event) {
        String numeri[] = {numberField1.getText(), numberField2.getText(), numberField3.getText()};
        String mail[] = {mailField1.getText(), mailField2.getText(), mailField3.getText()};
        
        // Chiamo la funzione di Verifica delle modifiche effettuate
        RisultatiVerifica risultato = Verifica.verifica(nameField.getText(), surnameField.getText(), numeri, mail);
        if(risultato.getValido()) {     
            Contatto c = new Contatto(nameField.getText(), surnameField.getText(), numeri, mail);
            if (c == null) {
                mostraErrore("Nessun Contatto selezionato.");
                return;
            }
            int i = Tabella.getSelectionModel().getSelectedIndex();
            if (i < 0) {
                mostraErrore("Seleziona un contatto per continuare.");
                return;
            }
            rubrica.modificaContatto(i, c);
            listaContatti.set(i, c);
            pulisci();
            ordinaTabella();
        }
        else mostraErrore(risultato.getMessaggio());
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
    private void rimuovi(ActionEvent event) {
        Contatto c = Tabella.getSelectionModel().getSelectedItem();
        if (c == null) {
            mostraErrore("Seleziona un contatto per continuare.");
            return;
        }
        Optional<ButtonType> risultato = mostraConferma();
        if(risultato.get() != ButtonType.OK || !risultato.isPresent()) return;
        if(risultato.get() == ButtonType.OK) {                           
            rubrica.eliminaContatto(c);
            listaContatti.remove(c);
            pulisci();
        }
        ordinaTabella();
        conteggioContatti();
    }

    /**
    * 
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
    private void cerca(KeyEvent event) {
        String searchText = searchField.getText().toLowerCase();
        if (searchText.isEmpty()) listaContatti.setAll(rubrica.getContatti());
        else {
            // Filtra i contatti in base al testo inserito
            ObservableList<Contatto> filteredList = FXCollections.observableArrayList();
            for (Contatto contatto : rubrica.getContatti()) {
                boolean matchesName = contatto.getNome().toLowerCase().startsWith(searchText);
                boolean matchesSurname = contatto.getCognome().toLowerCase().startsWith(searchText);
                if (matchesName || matchesSurname) filteredList.add(contatto);
            }
            listaContatti.setAll(filteredList);
        }
         ordinaTabella();
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
    private void esportaLista(ActionEvent event) throws IOException {
        GestioneFile.esportaRubrica(rubrica);
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
    private void importaLista(ActionEvent event) throws IOException {
        
        // Visualizzazione Finestra di scelta File
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importa Rubrica");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));
        File file = fileChooser.showOpenDialog(null);
        if(file == null) return;
        
        int risultato = mostraInfo();
        
        // Aggiornamento Rubrica in base al pulsante selezionato
        if(risultato != 1 && risultato != 2) return;
        if(risultato == 1){
            listaContatti.clear();
            rubrica.getContatti().clear();
        }
            try {
                List<Contatto> r = GestioneFile.importaRubrica(file);
                rubrica.getContatti().addAll(r);
                listaContatti.addAll(r);
            } catch (IOException e) {
                mostraErrore("Errore durante l'importazione del file: " + e.getMessage());
            }
            conteggioContatti();
            ordinaTabella();
    }
    
    @FXML
    private void seleziona(MouseEvent event) {
	Contatto c = Tabella.getSelectionModel().getSelectedItem();
        nameField.setText(c.getNome());
        surnameField.setText(c.getCognome());
        numberField1.setText(c.getNumero(0));
	numberField2.setText(c.getNumero(1));
        numberField3.setText(c.getNumero(2));
        mailField1.setText(c.getMail(0));
        mailField2.setText(c.getMail(1));
        mailField3.setText(c.getMail(2));        
    }
}

