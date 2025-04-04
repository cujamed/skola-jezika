package me.fit.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

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

	@Override
	public String toString() {
		return "Polaznik [ime=" + ime + ", prezime=" + prezime + ", brIndeksa=" + brIndeksa + ", datumRodjenja="
				+ datumRodjenja + ", datumPocetka=" + datumPocetka + ", kursevi=" + kursevi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brIndeksa, datumPocetka, datumRodjenja, ime, kursevi, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polaznik other = (Polaznik) obj;
		return Objects.equals(brIndeksa, other.brIndeksa) && Objects.equals(datumPocetka, other.datumPocetka)
				&& Objects.equals(datumRodjenja, other.datumRodjenja) && Objects.equals(ime, other.ime)
				&& Objects.equals(kursevi, other.kursevi) && Objects.equals(prezime, other.prezime);
	}
    
	
    
}
