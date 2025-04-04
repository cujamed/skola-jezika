package me.fit.model;

import java.util.Objects;

public class Jezik {
	private String naziv;

	public Jezik() {
		super();
	}

	public Jezik(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Jezik [naziv=" + naziv + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jezik other = (Jezik) obj;
		return Objects.equals(naziv, other.naziv);
	}
	
	
}
