package mockDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Utente;

public class UsersDB {
	
	private List<Utente> utenti;
	private Map<Utente, String> password;
	
	public UsersDB() {
		utenti = new ArrayList<>();
		password = new HashMap<>();
		init();		
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public Map<Utente, String> getPassword() {
		return password;
	}

	public void setPassword(Map<Utente, String> password) {
		this.password = password;
	}
	
	private void init() {
		Utente u1 = new Utente("GiulioFabbri", "fabbrigiulio2@libero.it");
		Utente u2 = new Utente("Ceron", "marcoceron@libero.it");
		Utente u3 = new Utente("KGW34", "kyleweems@gmail.it");
		Utente u4 = new Utente("GinoCuccarolo", "cuccathepivot@libero.it");
		Utente a1 = new Utente("Alberto", "garagnanialberto@gmail.com");
		Utente a2 = new Utente("OscarGugliotta", "guglio72@gmail.com");
		Utente a3 = new Utente("MortellaroChris", "bisubusui@hotmail.com");
		this.utenti.add(u1);
		this.utenti.add(u2);
		this.utenti.add(u3);
		this.utenti.add(u4);
		this.utenti.add(a1);
		this.utenti.add(a2);
		this.utenti.add(a3);
		this.password.put(u1, "batman");
		this.password.put(u2, "qwerty");
		this.password.put(u3, "simplePassword");
		this.password.put(u4, "aimfromdowntown");
		this.password.put(a1, "Cihiciamo");
		this.password.put(a2, "NOOONOOsisiSI");
		this.password.put(a3, "Throenwsm");
	}
}
