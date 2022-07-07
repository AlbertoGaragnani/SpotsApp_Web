package model;

import java.util.ArrayList;
import java.util.List;

public class Recensione {
	
	private String id;
	private int valutazione;
	private String titolo;
	private String descrizione;
	private List<Permanenza> permanenza;
	private String username;
	
	public Recensione() {
		List<Permanenza> perm = new ArrayList<>();
		this.permanenza = perm;
		this.titolo= "";
		this.descrizione = "";
		this.username="";
	}
	
	public Recensione(String id, int valutazione, String titolo, String descrizione,
			List<Permanenza> permanenza) {
		this.id = id;
		this.valutazione = valutazione;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.permanenza = permanenza;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getValutazione() {
		return valutazione;
	}
	
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public List<Permanenza> getPermanenza() {
		return permanenza;
	}
	
	public void setPermanenza(List<Permanenza> permanenza) {
		this.permanenza = permanenza;
	}
	
	
}
