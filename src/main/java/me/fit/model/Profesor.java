package me.fit.model;

import java.sql.Date;
import java.util.Objects;

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
	@Override
	public String toString() {
		return "Profesor [ime=" + ime + ", jmbg=" + jmbg + ", datumRodjenja=" + datumRodjenja + ", jezik=" + jezik
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(datumRodjenja, ime, jezik, jmbg);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(datumRodjenja, other.datumRodjenja) && Objects.equals(ime, other.ime)
				&& Objects.equals(jezik, other.jezik) && Objects.equals(jmbg, other.jmbg);
	}
    
	
}
