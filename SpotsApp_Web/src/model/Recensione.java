package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Recensione {
	
	private String id;
	private int valutazione;
	private Optional<String> titolo;
	private Optional<String> descrizione;
	private Optional<List<Permanenza>> permanenza;
	
	public Recensione() {
		List<Permanenza> perm = new ArrayList<>();
		this.permanenza = Optional.of(perm);
		this.titolo= Optional.of("");
		this.descrizione = Optional.of("");
	}
	
	public Recensione(String id, int valutazione, Optional<String> titolo, Optional<String> descrizione,
			Optional<List<Permanenza>> permanenza) {
		this.id = id;
		this.valutazione = valutazione;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.permanenza = permanenza;
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
	
	public Optional<String> getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = Optional.of(titolo);
	}
	
	public Optional<String> getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = Optional.of(descrizione);
	}
	
	public Optional<List<Permanenza>> getPermanenza() {
		return permanenza;
	}
	
	public void setPermanenza(List<Permanenza> permanenza) {
		this.permanenza = Optional.of(permanenza);
	}
	
	
}
