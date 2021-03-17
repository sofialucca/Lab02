package it.polito.tdp.alien;

import java.util.*;

public class Dizionario {

	private List<WordEnhanced> listaTraduzioni;
	
	public Dizionario() {
		listaTraduzioni=new ArrayList<>();
	}
	
	public void add(String parolaAliena,List<String> traduzione) {
		parolaAliena=parolaAliena.toLowerCase();
		WordEnhanced nuovaWord=new WordEnhanced(parolaAliena,traduzione);
		for(WordEnhanced w:listaTraduzioni) {
			if(w.equals(nuovaWord)) {
				w.addTraduzione(traduzione);
				return;
			}
		}
		listaTraduzioni.add(nuovaWord);
	}
	
	public String translateWord(String parolaAliena) {
		parolaAliena=parolaAliena.toLowerCase();
		boolean ricercaSpeciale=false;
		if(parolaAliena.contains("?")) {
			parolaAliena=parolaAliena.replace('?', '.');
			ricercaSpeciale=true;
		}
		String possibiliTraduzioni="";
		for(WordEnhanced w:listaTraduzioni) {
			if(w.getParolaAliena().matches(parolaAliena)) {
				if(ricercaSpeciale) {
					possibiliTraduzioni+="Forse stavi cercando: "+w.getParolaAliena()+"\n"+w.getTraduzione();
				}else{
					return w.getTraduzione();
				}
			}
		}
		return possibiliTraduzioni;
	}
	
	
}
