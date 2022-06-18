package mockDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Moderatore;

public class ModeratoriDB {

	private List<Moderatore> moderatori;
	private Map<Moderatore, String> password;
	
	public ModeratoriDB() {
		this.moderatori = new ArrayList<>();
		this.password = new HashMap<>();
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

	private void init() {
		Moderatore m1 = new Moderatore("MarcoRossi", "rossimarco@gmail.com");
		Moderatore m2 = new Moderatore("AntonioScarnera", "anthony11@gmail.com");
		this.moderatori.add(m1);
		this.moderatori.add(m2);
		this.password.put(m1, "12345");
		this.password.put(m2, "Scarpiera321");
	}
}
