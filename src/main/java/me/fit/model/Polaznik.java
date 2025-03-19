package me.fit.model;

import java.sql.Date;
import java.util.List;

public class Polaznik {
	private String ime;
    private String prezime;
    private String brIndeksa;
    private Date datumRodjenja;
    private Date datumPocetka;
    private List <Kurs> kursevi;
	
    public Polaznik() {
		super();
	}

	public Polaznik(String ime, String prezime, String brIndeksa, Date datumRodjenja, Date datumPocetka,
			List<Kurs> kursevi) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
		this.datumRodjenja = datumRodjenja;
		this.datumPocetka = datumPocetka;
		this.kursevi = kursevi;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public List<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
    
    
}
