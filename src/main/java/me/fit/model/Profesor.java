package me.fit.model;

import java.sql.Date;

public class Profesor {
	private String ime;
    private String jmbg;
    private Date datumRodjenja;
    private Jezik jezik;
	public Profesor() {
		super();
	}
	public Profesor(String ime, String jmbg, Date datumRodjenja, Jezik jezik) {
		super();
		this.ime = ime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.jezik = jezik;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public Jezik getJezik() {
		return jezik;
	}
	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}
    
}
