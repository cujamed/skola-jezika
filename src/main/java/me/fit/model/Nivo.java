package me.fit.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
@NamedQuery(name = Nivo.GET_ALL_LEVELS, query="Select n from Nivo n")
public class Nivo {
	public static final String GET_ALL_LEVELS = "Nivo.getAllLevels";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nivo_seq")
	@SequenceGenerator(name = "nivo_seq", sequenceName = "nivo_seq", allocationSize = 1)
	private Long id;
	
	private String naziv;
	
	@OneToMany(mappedBy = "nivo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Kurs> kursevi;

	public Nivo(Long id,String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Nivo() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Set<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(Set<Kurs> kursevi) {
		this.kursevi = kursevi;
	}

	@Override
	public String toString() {
		return "Nivo [naziv=" + naziv + "]";
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
		Nivo other = (Nivo) obj;
		return Objects.equals(naziv, other.naziv);
	}
	
	
}
