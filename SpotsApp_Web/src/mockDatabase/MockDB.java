package mockDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Admin;
import model.Attivita;
import model.Moderatore;
import model.Recensione;
import model.Spot;
import model.Utente;

public class MockDB {
	
	private static MockDB instance;
	private List<Utente> utenti;
	private List<Moderatore> moderatori;
	private List<Admin> admin;
	private Map<Utente, String> password;
	private List<Spot> spots;
	private Map<String, List<Spot>> preferiti;
	
	private MockDB() {
		utenti = new ArrayList<>();
		moderatori = new ArrayList<>();
		admin = new ArrayList<>();
		password = new HashMap<>();
		spots = new ArrayList<>();
		preferiti = new HashMap<>();
		init();
	}
	
	public static synchronized MockDB getInstance() {
		if(instance == null)
			instance = new MockDB();
		return instance;
	}
	
	private void init() {
		
		//Creazione utenti
		Utente u1 = new Utente("GiulioFabbri", "fabbrigiulio2@libero.it");
		Utente u2 = new Utente("Ceron", "marcoceron@libero.it");
		Utente u3 = new Utente("KGW34", "kyleweems@gmail.it");
		Utente u4 = new Utente("GinoCuccarolo", "cuccathepivot@libero.it");
		Utente u5 = new Utente("Albertone", "garagnanialbertone@gmail.com");
		Utente u6 = new Utente("OscarGugliotta", "guglio72@gmail.com");
		Utente u7 = new Utente("MortellaroChris", "bisubusui@hotmail.com");
		this.utenti.add(u1);
		this.utenti.add(u2);
		this.utenti.add(u3);
		this.utenti.add(u4);
		this.utenti.add(u5);
		this.utenti.add(u6);
		this.utenti.add(u7);
		this.password.put(u1, "batman");
		this.password.put(u2, "qwerty");
		this.password.put(u3, "simplePassword");
		this.password.put(u4, "aimfromdowntown");
		this.password.put(u5, "Cihiciamo");
		this.password.put(u6, "NOOONOOsisiSI");
		this.password.put(u7, "Throenwsm");
		
		//Creazione moderatori
		Moderatore m1 = new Moderatore("MarcoRossi", "rossimarco@gmail.com");
		Moderatore m2 = new Moderatore("AntonioScarnera", "anthony11@gmail.com");
		this.moderatori.add(m1);
		this.moderatori.add(m2);
		this.password.put(m1, "12345");
		this.password.put(m2, "Scarpiera321");
		
		//Creazione admin
		Admin a1 = new Admin("Alberto", "garagnanialberto@gmail.com");
		Admin a2 = new Admin("Tommaso", "muzzitommaso@gmail.com");
		Admin a3 = new Admin("Andrea", "ruggieriandrea@gmail.com");
		this.admin.add(a1);
		this.admin.add(a2);
		this.admin.add(a3);
		this.password.put(a1, "Gara00");
		this.password.put(a2, "Muztheoneandonly!");
		this.password.put(a3, "RuggoTown");
		
		//Creazione recensioni mock
		Recensione r1 = new Recensione();
		r1.setId("RE0001");
		r1.setValutazione(4);
		r1.setTitolo("tuffi mozzafiato");
		r1.setDescrizione("Una delle scogliere migliori da cui tuffarsi e da cui ammirare il mare. Ottimo anche per snorkling. Consigliato ");
		
		Recensione r2 = new Recensione();
		r1.setId("RE0002");
		r2.setValutazione(3);
		
		Recensione r3 = new Recensione();
		r3.setId("RE0003");
		r3.setValutazione(5);
		r3.setTitolo("Bellissimo canestro");
		r3.setDescrizione("Veramente uno dei campi da basket piu belli in cui io abbia mai giocato");
		
		//Creazione spot
		Map<String,Double> mappa = new HashMap<>();
		List<Spot> spotPreferiti = new ArrayList<>();
		Spot sp = new Spot();
		sp.setId("SP0001");
		sp.setUsernameUtente(u5.getUsername());
		sp.setNome("Calamaretto");
		sp.setIndirizzo("Via dei calamaretti");
		sp.setAttivita(Attivita.CLIFFDIVING);
		sp.setDescrizione("Spot perfetto per HighJumping");
		sp.setImmagini(new File("/SpotsApp/images/calamaretto1.jpg"));
		sp.setImmagini(new File("/SpotsApp/images/calamaretto2.jpg"));
		sp.setPresenzeSegnalate(2);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r1);
		
		this.spots.add(sp);
		
		sp = new Spot();
		sp.setId("SP0002");
		sp.setIndirizzo("Viale Gino Cervi");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Unipol Arena");
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setDescrizione("Grande capienza ma molto dispersivo, più adatto per concerti che per eventi sportivi. Facile da raggiungere");
		sp.setImmagini(new File("/SpotsApp/images/unipolArena1.png"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r2);
		this.spots.add(sp);
		spotPreferiti.add(sp);
		
		sp = new Spot();
		sp.setId("SP0003");
		sp.setIndirizzo("Piazza Azzarita");
		sp.setUsernameUtente(u5.getUsername());
		sp.setNome("Paladozza");
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setDescrizione("Il tempio della pallacanestro. Atmosfera incredibile, peccato giochi spesso la squadra sbagliata");
		sp.setImmagini(new File("/SpotsApp/images/paladozza.png"));
		sp.setPresenzeSegnalate(100);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r3);
		this.spots.add(sp);
		spotPreferiti.add(sp);
		
		sp = new Spot();
		sp.setId("SP0004");
		sp.setIndirizzo("Viale Risorgimento 2");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("L'angolo del parkour");
		sp.setAttivita(Attivita.PARKOUR);
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		
		//Creazione preferiti
		this.preferiti.put(u2.getUsername(), spotPreferiti);
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public List<Moderatore> getModeratori() {
		return moderatori;
	}

	public void setModeratori(List<Moderatore> moderatori) {
		this.moderatori = moderatori;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

	public Map<Utente, String> getPassword() {
		return password;
	}

	public void setPassword(Map<Utente, String> password) {
		this.password = password;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}

	public Map<String, List<Spot>> getPreferiti() {
		return preferiti;
	}

	public void setPreferiti(Map<String, List<Spot>> preferiti) {
		this.preferiti = preferiti;
	}
	
	public void setPreferiti(String username, Spot spot) {
		this.preferiti.get(username).add(spot);
	}
}
