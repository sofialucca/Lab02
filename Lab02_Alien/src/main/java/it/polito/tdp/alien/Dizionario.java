package it.polito.tdp.alien;

import java.util.*;

public class Dizionario {

	private List<Word> listaTraduzioni;
	
	public Dizionario() {
		listaTraduzioni=new ArrayList<>();
	}
	
	public void add(String parolaAliena,String traduzione) {
		parolaAliena=parolaAliena.toLowerCase();
		parolaAliena=parolaAliena.toLowerCase();
		Word nuovaWord=new Word(parolaAliena,traduzione);
		for(Word w:listaTraduzioni) {
			if(w.equals(nuovaWord)) {
				return;
			}
		}
		listaTraduzioni.add(nuovaWord);
	}
	
	public String translateWord(String parolaAliena) {
		parolaAliena=parolaAliena.toLowerCase();
		for(Word w:listaTraduzioni) {
			if(w.getParolaAliena().equals(parolaAliena)) {
				return w.getTraduzione();
			}
		}
		return null;
	}
	
	
}
