package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

public class Utente {
	private String username;
	private String email;
	private Privilegio privilegio;
	private List<Spot> spot;
	private List<Recensione> recensioni;
	private List<Segnalazione> segnalazioni;
	private HttpSession session;
	
	public Utente() {
		this.spot = new ArrayList<>();
		this.recensioni = new ArrayList<>();
		this.segnalazioni = new ArrayList<>();
	}
	
	public Utente(String username, String email, HttpSession session) {
		super();
		this.username = username;
		this.email = email;
		this.session = session;
		this.privilegio = Privilegio.BASE;
		this.spot = new ArrayList<>();
		this.recensioni = new ArrayList<>();
		this.segnalazioni = new ArrayList<>();
	}
	
	public Utente(String username, String email) {
		super();
		this.username = username;
		this.email = email;
		this.privilegio = Privilegio.BASE;
		this.spot = new ArrayList<>();
		this.recensioni = new ArrayList<>();
		this.segnalazioni = new ArrayList<>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public HttpSession getSession() {
		return session;
	}
	
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	public Privilegio getPrivilegio() {
		return privilegio;
	}
	
	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}

	public List<Spot> getSpot() {
		return spot;
	}

	public void setSpot(List<Spot> spot) {
		this.spot = spot;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}
	
	
}
