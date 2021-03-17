package it.polito.tdp.alien;

import java.net.URL;
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
    	if((!txtTraduzione.getText().matches( "[a-zA-Z[ \\t\\n\\x0B\\f\\r]]*"))||(txtTraduzione.getText().isBlank())) {
    		labelErrore.setText("ERRORE:INSERIRE TESTO VALIDO.");
    		txtRisultato.clear();
    		return;
    	}
    	String[] input=(txtTraduzione.getText()).split(" ");
    	if(input.length==2) {
    		this.model.add(input[0], input[1]);
    		txtRisultato.setText("PAROLA INSERITA CON SUCCESSO");
    	}else {
    		String traduzione=this.model.translateWord(input[0]);
    		if(traduzione==null) {
    			txtRisultato.setText("PAROLA NON TROVATA");
    		}else {
    			txtRisultato.setText(traduzione);    			
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