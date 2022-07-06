package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Spot implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String usernameUtente;
	private String nome;
	private String indirizzo;
	private String descrizione;
	private List<File> immagini;
	private int presenzeSegnalate;
	private List<Attivita> attivita;
	private Map<String, Double> affluenza;
	private List<Recensione> recensioni;
	private List<SegnalazioneSpot> segnalazioni;
	
	public Spot() {
		this.immagini = new ArrayList<>();
		this.attivita = new ArrayList<>();
		this.affluenza = new HashMap<>();
		this.recensioni = new ArrayList<>();
		this.segnalazioni = new ArrayList<>();
		this.descrizione= "";
	}

	public Spot(String id, String usernameUtente, String nome, String indirizzo, List<File> immagini,
			List<Attivita> attivita, Map<String, Double> affluenza, List<Recensione> recensioni) {
		super();
		this.id = id;
		this.usernameUtente = usernameUtente;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.immagini = immagini;
		this.presenzeSegnalate = 0;
		this.attivita = attivita;
		this.affluenza = affluenza;
		this.recensioni = recensioni;
	}
	
	

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<SegnalazioneSpot> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<SegnalazioneSpot> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsernameUtente() {
		return usernameUtente;
	}

	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<File> getImmagini() {
		return immagini;
	}

	public void setImmagini(List<File> immagini) {
		this.immagini = immagini;
	}
	
	public void setImmagini(File immagine) {
		this.immagini.add(immagine);
	}

	public int getPresenzeSegnalate() {
		return presenzeSegnalate;
	}

	public void setPresenzeSegnalate(int presenzeSegnalate) {
		this.presenzeSegnalate = presenzeSegnalate;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}
	
	public void setAttivita(Attivita attivita) {
		if(this.getAttivita().isEmpty())
		{
			this.attivita = new ArrayList<>();
			this.attivita.add(attivita);
		}
		else
			this.attivita.add(attivita);
	}
	

	public Map<String, Double> getAffluenza() {
		return affluenza;
	}

	public void setAffluenza(Map<String, Double> affluenza) {
		this.affluenza = affluenza;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}
	
	public void setRecensioni(Recensione r) {
		this.recensioni.add(r);
	}

	@Override
	public int hashCode() {
		return Objects.hash(indirizzo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spot other = (Spot) obj;
		return Objects.equals(indirizzo, other.indirizzo) && Objects.equals(nome, other.nome);
	}
	
		
	
}
