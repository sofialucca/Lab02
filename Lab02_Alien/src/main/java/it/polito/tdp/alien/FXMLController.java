package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {

	Dizionario model=new Dizionario();

    @FXML
    private TextArea txtRisultato;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtTraduzione;

    @FXML
    private Label labelErrore;
    
    @FXML
    void doTranslate(ActionEvent event) { 
    	String testoInput=txtTraduzione.getText();
    	String[] input=testoInput.split(" ");

    	//controllo che il campo non sia vuoto
    	if((testoInput.isBlank())) {
    		labelErrore.setText("ERRORE:INSERIRE TESTO");
    		txtRisultato.clear();
    		return;
    	}
    	
    	//caso di inserimento parole
    	if(input.length>=2) {
    		if(!testoInput.matches( "[a-zA-Z[ /s]]*")) {
	    		labelErrore.setText("ERRORE:INSERIRE TESTO VALIDO.");
	    		txtRisultato.clear();
	    		return;
	    	}
    		List<String> soloTraduzioni=new LinkedList<>();
    		for(int i=1;i<input.length;i++) {
    			soloTraduzioni.add(input[i]);
    		}
    		this.model.add(input[0], soloTraduzioni);
    		txtRisultato.setText("PAROLA INSERITA CON SUCCESSO");
    	}else {
    		//caso di traduzione && testoInput.matches("[a-zA-Z]*")
    		
    		if(testoInput.matches("([A-Za-z]*\\?[a-zA-Z]*){0,1}|[a-zA-Z]*") ) {
    			String traduzione=this.model.translateWord(input[0]);
	    		if(traduzione.isBlank()) {
	    			txtRisultato.setText("PAROLA NON TROVATA");
	    		}else {
	    			txtRisultato.setText(traduzione);    			
	    		}
    		}else {
	    		labelErrore.setText("ERRORE:INSERIRE TESTO VALIDO.");
	    		txtRisultato.clear();
	    		return;
    		}

    	}
    	this.btnReset.setDisable(false); 
    	labelErrore.setText(null);
    	this.txtTraduzione.clear();
    	return;
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    	this.btnReset.setDisable(true);
    }
    
    
    @FXML
    void initialize() {
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelErrore != null : "fx:id=\"labelErrore\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Dizionario model) {
    	this.model=model;
    }
}