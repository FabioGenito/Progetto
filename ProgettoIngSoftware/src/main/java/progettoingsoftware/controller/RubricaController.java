/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingsoftware.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import progettoingsoftware.model.Contatto;
import progettoingsoftware.model.Rubrica;

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
    private TextField number1Field;
    @FXML
    private TextField number2Field;
    @FXML
    private TextField number3Field;
    @FXML
    private TextField mail1Field;
    @FXML
    private TextField mail2Field;
    @FXML
    private TextField mail3Field;
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
    }    

    /**
    * Aggiunta di un Contatto
    * 
    * 
    * Provvede alla creazione di una nuova Istanza della 
    * classe "Contatto" , all'aggiunta di tale istanza nella
    * lista grafica e nella struttura dati sottostante.
    * 
    * 
    * @param[in] event Click tasto "Aggiungi"
    */
    @FXML
    private void add(ActionEvent event) {
        String[] numeri = new String[3];
        numeri[0] = number1Field.getText();
        numeri[1] = number2Field.getText();
        numeri[2] = number3Field.getText();

        String[] mail = new String[3];
        mail[0] = mail1Field.getText();
        mail[1] = mail2Field.getText();
        mail[2] = mail3Field.getText();

        Contatto c = new Contatto(nameField.getText(), surnameField.getText(), mail, numeri);
        rubrica.aggiungiContatto(c); 
        listaContatti.add(c); 

        nameField.clear();
        surnameField.clear();
        number1Field.clear();
        number2Field.clear();
        number3Field.clear();
        mail1Field.clear();
        mail2Field.clear();
        mail3Field.clear();
    }

    /**
    * @brief Modifica delle informazioni di un Contatto
    * 
    * Provvede alla modifica del contatto
    * selezionato (nella lista grafica), aggiornando sia
    * la lista grafica che la struttura dati.
    * 
    * @param[in] event Click del pulsante "Salva"
    */
    @FXML
    private void mod(ActionEvent event) {
    }

    /**
    * @brief Rimozione dalla Lista
    * 
    * 
    * Provvede alla rimozione del contatto
    * selezionato (nella lista grafica), aggiornando 
    * sia la lista grafica che la struttura dati.
    * 
    * @param[in] event Pressione del pulsante "Elimina"
    */
    @FXML
    private void del(ActionEvent event) {
    }

    /**
    * @brief Ricerca di un Contatto
    * 
    * Provvede al filtraggio grafico della lista
    * in funzione del contenuto della stringa di ricerca
    * 
    * @param[in] event Cambiamenti del testo nella Barra di Ricerca
    */
    @FXML
    private void search(KeyEvent event) {
        
    }

    /**
    * @brief Invoca il metodo dedicato per esportare la Rubrica su un File Esterno
    * 
    * @param[in] event Click sul Pulsante "Esporta Rubrica"
    */
    @FXML
    private void esportList(ActionEvent event) {
    }

    /**
    * @brief Invoca il metodo dedicato per importare da un File esterno una Lista di Contatti
    * 
    * @param event 
    */
    @FXML
    private void importList(ActionEvent event) {
    }
    
}
