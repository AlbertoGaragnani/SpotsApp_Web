package mockDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Admin;
import model.Attivita;
import model.Recensione;
import model.Spot;
import model.Utente;

public class SpotsDB {

	private List<Spot> spots;
	private UsersDB databaseUtenti;
	
	public SpotsDB() {
		this.spots = new ArrayList<>();
		this.databaseUtenti = new UsersDB();
		init();		
	}
	
	public List<Spot> getSpots()
	{
		return this.spots;
	}
	
	/*
	private String id;
	private String usernameUtente;
	private String nome;
	private String indirizzo;
	private File[] immagini;
	private int presenzeSegnalate;
	private List<Attivita> attivita;
	private Map<String, Double> affluenza;
	private List<Recensione> recensioni;
	*/
	
	private void init() {
		Utente a1 = this.databaseUtenti.getUtenti().get(0);
		Utente a2 = this.databaseUtenti.getUtenti().get(1);
		Utente a3 = this.databaseUtenti.getUtenti().get(2);
		Map<String,Double> mappa = new HashMap<>();
		List<Recensione> lista = new ArrayList<>();
		Spot sp = new Spot();
		sp.setId("SP0001");
		sp.setUsernameUtente(a1.getUsername());
		sp.setNome("Calamaretto");
		sp.setIndirizzo("Via dei calamaretti");
		sp.setAttivita(Attivita.CLIFFDIVING);
		//Settare le immagini
		sp.setPresenzeSegnalate(2);
		sp.setAffluenza(mappa);
		sp.setRecensioni(lista);
		this.spots.add(sp);
		
		sp = new Spot();
		sp.setId("SP0002");
		sp.setIndirizzo("Viale Gino Cervi");
		sp.setUsernameUtente(a1.getUsername());
		sp.setNome("Unipol Arena");
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setAttivita(Attivita.CLIFFDIVING);
		//Settare le immagini
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		sp.setRecensioni(lista);
		this.spots.add(sp);
		
		sp = new Spot();
		sp.setId("SP0003");
		sp.setIndirizzo("Piazza Azzarita");
		sp.setUsernameUtente(a2.getUsername());
		sp.setNome("Paladozza");
		sp.setAttivita(Attivita.BASKETBALL);
		//Settare le immagini
		sp.setPresenzeSegnalate(100);
		sp.setAffluenza(mappa);
		sp.setRecensioni(lista);
		this.spots.add(sp);
		
		sp = new Spot();
		sp.setId("SP0004");
		sp.setIndirizzo("Viale Risorgimento 2");
		sp.setUsernameUtente(a3.getUsername());
		sp.setNome("L'angolo del parkour");
		sp.setAttivita(Attivita.PARKOUR);
		//Settare le immagini
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		sp.setRecensioni(lista);
		this.spots.add(sp);
		
		
	}
}
