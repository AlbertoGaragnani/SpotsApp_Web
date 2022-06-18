package mockDatabase;

import java.util.List;
import java.util.Map;

import model.Admin;
import model.Moderatore;
import model.Utente;

public class ModeratoriDB {

	private List<Moderatore> moderatori;
	private Map<Moderatore, String> password;
	
	public ModeratoriDB() {
		init();
		
	}
	
	public List<Moderatore> getModeratori() {
		return moderatori;
	}

	public void setModeratori(List<Moderatore> moderatori) {
		this.moderatori = moderatori;
	}

	public Map<Moderatore, String> getPassword() {
		return password;
	}

	public void setPassword(Map<Moderatore, String> password) {
		this.password = password;
	}

	private static void init() {
		Moderatore m1 = new Moderatore("MarcoRossi", "rossimarco@gmail.com");
		Moderatore m2 = new Moderatore("AntonioScarnera", "anthony11@gmail.com");	
	}
}
