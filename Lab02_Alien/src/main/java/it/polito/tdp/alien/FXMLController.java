package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDiz = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    void doTranslate(ActionEvent event) {

    	txtResult.clear();
    	String riga = txtWord.getText().toLowerCase();
    	
    	// controllo l'input
    	if(riga==null || riga.length()==0) {
    		txtResult.setText("Inserire 1 o 2 parole");
    		return;
    	}
    
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	
    	//controllo su st
    	if(!st.hasMoreElements()) {
    		txtResult.setText("Inserire 1 o 2 parole");
    		return;
    	}
    	
    	//Estraggo la prima parola
    	String alienWord=st.nextToken();
    	
    	if(st.hasMoreElements()) {
    		//devo inserire parola e traduzione nel dizionario
    		
    		//estraggo la seconda parola
    		String translation = st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici!");
    			return;
    		}
    		
    		//Aggiungo la parola aliena e la traduzione nel dizionario
    		
    		alienDiz.addWord(alienWord, translation);
    		
    		txtResult.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + translation + "\", è stata inserita nel dizionario. ");
    		
    	}else {
    		//Controllo che non ci siano caratteri non ammessi
    		if( !alienWord.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici!");
    			return;
    		}
    		
    		String translation = alienDiz.translateWord(alienWord);
    		
    		if(translation!= null) {
    			txtResult.setText(translation);
    		}else {
    			txtResult.setText("La parola cercata non esiste nel dizionario!");
    		}
    	}

    }

    @FXML
    void doReset(ActionEvent event) {

    	txtWord.clear();
    	txtResult.clear();
    	alienDiz.resetDizionario();
    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}