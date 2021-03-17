package it.polito.tdp.alien;

public class Word {

	private String parolaAliena;
	private String traduzione;

	public Word(String parolaAliena, String traduzione) {
		super();
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}
	
	public String getParolaAliena() {
		return parolaAliena;
	}

	public String getTraduzione() {
		return traduzione;
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
		Word other = (Word) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}
	
	
}
