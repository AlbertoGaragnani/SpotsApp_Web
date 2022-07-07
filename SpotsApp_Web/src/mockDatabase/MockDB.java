package mockDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Admin;
import model.Attivita;
import model.Moderatore;
import model.Permanenza;
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
		
		//Liste permanenza per comodita
		List<Permanenza> mattina = new ArrayList<>();
		mattina.add(Permanenza.MATTINA);
		List<Permanenza> pomeriggio = new ArrayList<>();
		pomeriggio.add(Permanenza.POMERIGGIO);
		List<Permanenza> sera = new ArrayList<>();
		sera.add(Permanenza.SERA);
		List<Permanenza> mattinaPomeriggio = new ArrayList<>();
		mattinaPomeriggio.add(Permanenza.MATTINA);
		mattinaPomeriggio.add(Permanenza.POMERIGGIO);
		List<Permanenza> mattinaSera = new ArrayList<>();
		mattinaSera.add(Permanenza.MATTINA);
		sera.add(Permanenza.SERA);
		List<Permanenza> pomeriggioSera = new ArrayList<>();
		pomeriggioSera.add(Permanenza.POMERIGGIO);
		sera.add(Permanenza.SERA);
		List<Permanenza> mattinaPomeriggioSera = new ArrayList<>();
		mattinaPomeriggioSera.add(Permanenza.MATTINA);
		mattinaPomeriggioSera.add(Permanenza.POMERIGGIO);
		mattinaPomeriggioSera.add(Permanenza.SERA);
		
		//Creazione recensioni mock
		Recensione r1 = new Recensione();
		r1.setId("RE0001");
		r1.setValutazione(4);
		r1.setTitolo("Mi sentivo la Cagnotto");
		r1.setTitolo("tuffi mozzafiato");
		r1.setDescrizione("Una delle scogliere migliori da cui tuffarsi e da cui ammirare il mare. Ottimo anche per snorkling. Consigliato ");
		r1.setPermanenza(mattinaPomeriggio);
		r1.setUsername(u1.getUsername());
		
		Recensione r2 = new Recensione();
		r2.setId("RE0002");
		r2.setValutazione(3);
		r2.setPermanenza(mattina);
		r2.setUsername(u2.getUsername());
		
		Recensione r3 = new Recensione();
		r3.setId("RE0003");
		r3.setValutazione(5);
		r3.setTitolo("Bellissimo canestro");
		r3.setDescrizione("Veramente uno dei campi da basket piu belli in cui io abbia mai giocato");
		r3.setPermanenza(pomeriggioSera);
		r3.setUsername(u3.getUsername());
		//Recensioni aggiunte da frayrtix
		Recensione r4 = new Recensione(); //Calamaretto
		r4.setId("RE0004");
		r4.setValutazione(3);
		r4.setTitolo("Mi è piaciuto? Si. Ci tornerò? vediamo..");
		r4.setPermanenza(pomeriggio);
		r4.setDescrizione("Bell'esperienza ma sconsigliata ai piccoli.. Tuffi PERICOLOSI");
		r4.setUsername(u6.getUsername());
		
		Recensione r5 = new Recensione(); //Paladozza
		r5.setId("RE0005");
		r5.setValutazione(5);
		r5.setTitolo("Oscura la vallataaa");
		r5.setPermanenza(sera);
		r5.setDescrizione("Dopo 16 anni torno a palazzo per vedere la V, quarti finale di Eurocup contro ULM, TIFO BELLISSIMO.. E poi alla stoppata di Kyle.. Fantastico, consigliato a tutti gli appassionati di basket");
		r5.setUsername(u4.getUsername());
		Recensione r6 = new Recensione(); //Elefante
		r6.setId("RE0006");
		r6.setValutazione(4);
		r6.setUsername(u5.getUsername());
		
		Recensione r7 = new Recensione(); //Elefante
		r7.setId("RE0007");
		r7.setValutazione(5);
		r7.setTitolo("TOP");
		r7.setDescrizione("La roccia sembra davvero il muso di un'elefante!!! I miei figli si sono divertiti moltissimo, sotto la sporgenza tutti anche per i piccini!");
		r7.setPermanenza(mattina);
		r7.setUsername(u2.getUsername());
		Recensione r8 = new Recensione(); //Elefante
		r8.setId("RE0008");
		r8.setValutazione(5);
		r8.setTitolo("L'elefante più grande mai visto!");
		r8.setPermanenza(pomeriggio);
		r8.setUsername(u4.getUsername());
		Recensione r9 = new Recensione(); //Parco della resistenza
		r9.setId("RE0009");
		r9.setValutazione(2);
		r9.setTitolo("Si può fare di piu, diceva qualcuno..");
		r9.setDescrizione("Tabelloni rovinati, quasi sempre pieno di gente.. Si salva solo il murales.. ");
		r9.setPermanenza(pomeriggioSera);
		r9.setUsername(u3.getUsername());
		
		Recensione r10 = new Recensione(); //Parco rosso
		r10.setId("RE0010");
		r10.setValutazione(5);
		r10.setTitolo("3vs3, ho vinto io!");
		r10.setDescrizione("Campo stupendo <3");
		r10.setPermanenza(pomeriggio);
		r10.setUsername(u3.getUsername());
		
		Recensione r11 = new Recensione(); //Parco rosso
		r11.setId("RE0011");
		r11.setValutazione(4);
		r11.setTitolo("Venite numerosi!!");
		r11.setDescrizione("Bellissimo ma poco frequentato, peccato");
		r11.setPermanenza(mattinaPomeriggio);
		r11.setUsername(u1.getUsername());
		
		
		Recensione r12 = new Recensione(); //Parco rosso
		r12.setId("RE0012");
		r12.setValutazione(2);
		r12.setTitolo("Così.. NON VA BENE");
		r12.setDescrizione("Finalmente il comune fa QUALCOSA per noi e il risultato?! La sera non si può giocare perchè l'illuminazione è pessima e ci vanno i ragazzini con la cassa a disturbare tutti quelli che vogliono stare nei dintorni in tranquillita.. BAH.. PRENDERE PROVVEDIMENTIII");
		r12.setPermanenza(pomeriggioSera);
		r12.setUsername(u6.getUsername());
		Recensione r13 = new Recensione(); //Porto Novo
		r13.setId("RE0013");
		r13.setValutazione(4);
		r13.setTitolo("Avventura a portata di mano");
		r13.setPermanenza(pomeriggio);
		r13.setUsername(u4.getUsername());
		
		Recensione r14 = new Recensione(); //Porto Novo
		r14.setId("RE0014");
		r14.setValutazione(4);
		r14.setPermanenza(pomeriggio);
		r14.setUsername(u2.getUsername());
		
		Recensione r15 = new Recensione(); //Porto Novo
		r15.setId("RE0015");
		r15.setValutazione(5);
		r15.setTitolo("MOZZAFIATO");
		r15.setDescrizione("MOZZAFIATO: ci sono stato insieme alla mia ragazza per l'anniversario, è quella giusta (la spiaggia..). Paesaggio mozzafiato, mare bellissimo e super tuffi attaccati alla spiaggia. Molto colpito da due ragazzi/adulti che stavano in cima a dare consigli ai visitatori su come buttarsi per evitare qualcuno si facesse male!");
		r15.setPermanenza(sera);
		r15.setUsername(u5.getUsername());
		
		Recensione r16 = new Recensione(); //Skate non fluo
		r16.setId("RE0016");
		r16.setValutazione(2);
		r16.setTitolo("Fake");
		r16.setDescrizione("Falso..Ci sono stato, magari per lo skate va bene ma per il parkour.. poca roba.. Molto meglio il J-Set a 100m da lì..");
		r16.setPermanenza(mattina);
		r16.setUsername(u1.getUsername());
		
		Recensione r17 = new Recensione(); //Skate non fluo
		r17.setId("RE0017");
		r17.setValutazione(4);
		r17.setDescrizione("Illuminato benissimo, bello anche di sera. Magari ecco, due rampe in piu..");
		r17.setPermanenza(sera);
		r17.setUsername(u4.getUsername());
		
		Recensione r18 = new Recensione(); //Frisbee 1 cusb
		r18.setId("RE0018");
		r18.setValutazione(1);
		r18.setTitolo("MOZZAFIATO");
		r18.setDescrizione("Mi sono scavigliato, campo tenuto malissimo che sul bagnato diventa una palude");
		r18.setPermanenza(sera);
		r18.setUsername(u4.getUsername());
		
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
		sp.setRecensioni(r4);
		
		this.spots.add(sp);
		
		sp = new Spot();
		sp.setId("SP0002");
		sp.setIndirizzo("Viale Gino Cervi");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Unipol Arena");
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setDescrizione("Grande capienza ma molto dispersivo, piu adatto per concerti che per eventi sportivi. Facile da raggiungere");
		sp.setImmagini(new File("/SpotsApp/images/unipolArena1.png"));
		sp.setImmagini(new File("/SpotsApp/images/unipol1.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/unipol2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/unipol3.jpeg"));
		sp.setPresenzeSegnalate(3);
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
		sp.setImmagini(new File("/SpotsApp/images/paladozza1.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/paladozza2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/paladozza3.jpeg"));
		sp.setPresenzeSegnalate(100);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r3);
		sp.setRecensioni(r5);
		this.spots.add(sp);
		spotPreferiti.add(sp);
		
		sp = new Spot();
		sp.setId("SP0004");
		sp.setIndirizzo("Viale Risorgimento 2");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("L'angolo del parkour");
		sp.setAttivita(Attivita.PARKOUR);
		sp.setAttivita(Attivita.SKATEBOARDING);
		sp.setImmagini(new File("/SpotsApp/images/parkourtmp.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkourtmp3.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkourtmp4.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkourtmp5.jpeg"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		
		//Spot aggiunti da fraytrix
		//Parkour 1
		sp = new Spot();
		sp.setId("SP0005");
		sp.setIndirizzo("Via dei Castani 13");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Parkour Gallarate");
		sp.setAttivita(Attivita.PARKOUR);
		sp.setDescrizione("Area parkour free entry principianti/intermedi/esperti");
		sp.setImmagini(new File("/SpotsApp/images/parkour1.jpeg"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Parkour 2
		sp = new Spot();
		sp.setId("SP0006");
		sp.setIndirizzo("Piazza del popolo 1A");
		sp.setUsernameUtente(u4.getUsername());
		sp.setNome("Happy Park");
		sp.setAttivita(Attivita.PARKOUR);
		sp.setDescrizione("Popkour-Fondazione MIST");
		sp.setImmagini(new File("/SpotsApp/images/parkour2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkour22.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkour222.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkour2222.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/parkour22222.jpeg"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Cliffdiving 2
		sp = new Spot();
		sp.setId("SP0007");
		sp.setIndirizzo("Roccia elefante");
		sp.setUsernameUtente(u1.getUsername());
		sp.setNome("Roccia elefante");
		sp.setAttivita(Attivita.CLIFFDIVING);
		sp.setDescrizione("Panarea, tuffi a Roccia elefante");
		sp.setImmagini(new File("/SpotsApp/images/cliffdiving11.jpeg"));
		sp.setPresenzeSegnalate(3);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r6);
		sp.setRecensioni(r7);
		sp.setRecensioni(r8);
		this.spots.add(sp);
		//Surf 1
		sp = new Spot();
		sp.setId("SP0008");
		sp.setIndirizzo("Spiaggia tornante");
		sp.setUsernameUtente(u3.getUsername());
		sp.setNome("Il tornante");
		sp.setAttivita(Attivita.SURF);
		sp.setDescrizione("Surf nella spiaggia più bella dell'isola, possibilità di lezioni con maestri e noleggio tavole a 50m");
		sp.setImmagini(new File("/SpotsApp/images/surf1.jpeg"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Surf 2
		sp = new Spot();
		sp.setId("SP0009");
		sp.setIndirizzo("Via Monopoli 3");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Spiaggia Margot");
		sp.setAttivita(Attivita.SURF);
		sp.setDescrizione("Onde alte da giugno a settembre, servizio bagnini 9-18");
		sp.setImmagini(new File("/SpotsApp/images/surf22.jpeg"));
		sp.setPresenzeSegnalate(2);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Skate 1
		sp = new Spot();
		sp.setId("SP0010");
		sp.setIndirizzo("Corso Garibaldi 27");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Skate park Triennale di Milano");
		sp.setDescrizione("Parco realizzato in occasione della Triennale di Milano del 2021, in collaborazione con l'istituto artistico Carlo V");
		sp.setImmagini(new File("/SpotsApp/images/skate2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/skate22.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/skate222.jpeg"));
		sp.setAttivita(Attivita.SKATEBOARDING);
		sp.setAttivita(Attivita.PARKOUR);
		sp.setPresenzeSegnalate(14);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r16);
		sp.setRecensioni(r17);
		this.spots.add(sp);
		//Skate 2
		sp = new Spot();
		sp.setId("SP0011");
		sp.setIndirizzo("Via giardini mosaico 4");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("GallaraSkate");
		sp.setAttivita(Attivita.SKATEBOARDING);
		sp.setDescrizione("FluoPark di Christian Daloni, AXExchange senior devoloper, per i ragazzi del centro ricreativo di Giorgio Santamaria");
		sp.setImmagini(new File("/SpotsApp/images/skate111.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/skate1111.jpeg"));
		sp.setPresenzeSegnalate(9);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Frisbee 1
		sp = new Spot();
		sp.setId("SP0012");
		sp.setIndirizzo("Via del terrapieno 18");
		sp.setUsernameUtente(u1.getUsername());
		sp.setNome("Campi sportivi CUSB terrapieno");
		sp.setAttivita(Attivita.FRISBEE);
		sp.setDescrizione("Centro Universitario Sportivo Bologna mette a disposizione 3 campi per il frisbee lun-mer 10-13 e sab-dom 19-22");
		sp.setImmagini(new File("/SpotsApp/images/frisbee111.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/frisbee1111.jpg"));
		sp.setPresenzeSegnalate(2);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r18);
		this.spots.add(sp);
		//Frisbee 2
		sp = new Spot();
		sp.setId("SP0013");
		sp.setIndirizzo("Via internazionale 74");
		sp.setUsernameUtente(u1.getUsername());
		sp.setNome("Spiaggia libera Paganello");
		sp.setAttivita(Attivita.FRISBEE);
		sp.setDescrizione("Campi da ultimate frisbee spiaggia del Paganello");
		sp.setImmagini(new File("/SpotsApp/images/frisbee2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/frisbee222.jpeg"));
		sp.setPresenzeSegnalate(31);
		sp.setAffluenza(mappa);
		this.spots.add(sp);
		//Basket 3
		sp = new Spot();
		sp.setId("SP0014");
		sp.setIndirizzo("Parco della Resistenza");
		sp.setUsernameUtente(u2.getUsername());
		sp.setNome("Campetto parco della resistenza");
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setDescrizione("Campo parco della Resistenza San Lazzaro, restaurato nel 2019 sempre a disposizione, murales scuole medie Pacinotti Jordan-Bryant-James-Bird");
		sp.setImmagini(new File("/SpotsApp/images/basket1.jpg"));
		sp.setPresenzeSegnalate(4);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r9);
		this.spots.add(sp);
		//Basket 4
		sp = new Spot();
		sp.setId("SP0015");
		sp.setIndirizzo("Via Orlandi 15");
		sp.setUsernameUtente(u2.getUsername());
		sp.setNome("Nuovo campo 3vs3 scuole Modigliani");
		sp.setDescrizione("Campo nuovo 2022 ridipinto in collaborazione con l'istuto artistico-tecnico-industriale Modigliani di Pesaro");
		sp.setImmagini(new File("/SpotsApp/images/basket2.jpeg"));
		sp.setImmagini(new File("/SpotsApp/images/basket222.jpeg"));
		sp.setAttivita(Attivita.BASKETBALL);
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r10);
		sp.setRecensioni(r11);
		sp.setRecensioni(r12);
		this.spots.add(sp);
		//Cliffdiving 3
		sp = new Spot();
		sp.setId("SP0016");
		sp.setIndirizzo("Porta Tuscolano 4");
		sp.setUsernameUtente(u6.getUsername());
		sp.setNome("Scoglio del Tuscolano");
		sp.setAttivita(Attivita.CLIFFDIVING);
		sp.setDescrizione("Scogli sicuri a Porto Novo, spiaggia dei sassi bianchi Tuscolano bellissima per tuffi");
		sp.setImmagini(new File("/SpotsApp/images/cliffdiving3.jpeg"));
		sp.setPresenzeSegnalate(0);
		sp.setAffluenza(mappa);
		sp.setRecensioni(r13);
		sp.setRecensioni(r14);
		sp.setRecensioni(r15);
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