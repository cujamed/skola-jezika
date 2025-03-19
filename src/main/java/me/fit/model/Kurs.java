package me.fit.model;

import java.util.List;

public class Kurs {
    private String naziv;
    private double cijena;
    private int brCasova;
    private Nivo nivo;
    private Profesor profesor;
    private List<Polaznik> polaznici;
	public Kurs() {
		super();
	}
	public Kurs(String naziv, double cijena, int brCasova, Nivo nivo, Profesor profesor, List<Polaznik> polaznici) {
		super();
		this.naziv = naziv;
		this.cijena = cijena;
		this.brCasova = brCasova;
		this.nivo = nivo;
		this.profesor = profesor;
		this.polaznici = polaznici;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public int getBrCasova() {
		return brCasova;
	}
	public void setBrCasova(int brCasova) {
		this.brCasova = brCasova;
	}
	public Nivo getNivo() {
		return nivo;
	}
	public void setNivo(Nivo nivo) {
		this.nivo = nivo;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public List<Polaznik> getPolaznici() {
		return polaznici;
	}
	public void setPolaznici(List<Polaznik> polaznici) {
		this.polaznici = polaznici;
	}

    
}