package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
        this( DEFAULT_PESO_MAX_BORSA);
		
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
		}
	/**
	 * Aggiunge un attrezzo nella borsa
	 * @param attrezzo
	 * @return true se � stato aggiunto, false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		return false;
		if (this.numeroAttrezzi==10)
		return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
		}

	/**
	 * 
	 * @return restituisce il peso massimo sostenibile dalla borsa
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	/**
	 * Controlla se il nome dell'attrezzo nel parametro corrisponde ad un attrezzo nella borsa
	 * @param nomeAttrezzo
	 * @return attrezzo richiesto, altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
				}
		return a;
	}
	/**
	 * Calcola il peso corrente della borsa ad ogni sua invocazione
	 * @return peso della borsa aggiornato
	 */
	public int getPeso() {

		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
		}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		
		if(nomeAttrezzo!=null && this.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo[] attr = new Attrezzo [10];
			
			int l = 0;
			for(int i=0; i< this.numeroAttrezzi; i++) {
				if(!this.attrezzi[i].getNome().equals(nomeAttrezzo)){
					attr[l]= this.attrezzi[i];
					l++;
				}
			}
			this.numeroAttrezzi--;
			this.attrezzi=attr;
			return true;
		}
		
		return false;
	}
	
	public String toString() {

		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	

}