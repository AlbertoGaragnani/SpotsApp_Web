package mockDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Admin;

public class AdminDB {

	private List<Admin> admin;
	private Map<Admin, String> password;
	
	public AdminDB() {
		this.admin = new ArrayList<>();
		this.password = new HashMap<>();
		init();		
	}
	
	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

	public Map<Admin, String> getPassword() {
		return password;
	}

	public void setPassword(Map<Admin, String> password) {
		this.password = password;
	}

	private void init() {
		Admin a1 = new Admin("Alberto", "garagnanialberto@gmail.com");
		Admin a2 = new Admin("Tommaso", "muzzitommaso@gmail.com");
		Admin a3 = new Admin("Andrea", "ruggieriandrea@gmail.com");
		this.admin.add(a1);
		this.admin.add(a2);
		this.admin.add(a3);
		this.password.put(a1, "Gara00");
		this.password.put(a2, "Muztheoneandonly!");
		this.password.put(a3, "RuggoTown");
	}
}
