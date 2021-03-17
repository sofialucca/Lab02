package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {

	private String parolaAliena;
	private List<String> traduzione;

	public WordEnhanced(String parolaAliena, List<String> traduzione) {
		super();
		this.parolaAliena = parolaAliena;
		this.traduzione=new LinkedList<>(traduzione);
	}
	
	public String getParolaAliena() {
		return parolaAliena;
	}

	public String getTraduzione() {
		List<String> elencoTraduzioni=new LinkedList<>(traduzione);
		String stampare=elencoTraduzioni.get(0);
		elencoTraduzioni.remove(0);
		for(String s: elencoTraduzioni) {
			stampare+="\n"+s;
		}
		return stampare;
	}

	public void addTraduzione(List<String> aggiunte) {
		for(String s:traduzione) {
			for(Iterator<String> i=aggiunte.iterator();i.hasNext();) {
				i.next();
				if(s.equals(i)) {
					i.remove();
				}
			}
		}
		traduzione.add(parolaAliena);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parolaAliena == null) ? 0 : parolaAliena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}
	
	
}
