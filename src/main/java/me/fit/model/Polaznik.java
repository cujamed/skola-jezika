package me.fit.model;

import jakarta.persistence.*;
import me.fit.model.client.PolaznikKurs;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Polaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "polaznik_seq")
    @SequenceGenerator(name = "polaznik_seq", sequenceName = "polaznik_seq", allocationSize = 1)
    private Long id;

    private String ime;
    private String prezime;
    private String brIndeksa;
    private Date datumRodjenja;
    private Date datumPocetka;

    @OneToMany(mappedBy = "polaznik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PolaznikKurs> polaznikKursevi = new HashSet<>();

    public Polaznik() {
        super();
    }

    public Polaznik(String ime, String prezime, String brIndeksa, Date datumRodjenja, Date datumPocetka) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa = brIndeksa;
        this.datumRodjenja = datumRodjenja;
        this.datumPocetka = datumPocetka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<PolaznikKurs> getPolaznikKursevi() {
        return polaznikKursevi;
    }

    public void setPolaznikKursevi(Set<PolaznikKurs> polaznikKursevi) {
        this.polaznikKursevi = polaznikKursevi;
    }

    @Override
    public String toString() {
        return "Polaznik [ime=" + ime + ", prezime=" + prezime + ", brIndeksa=" + brIndeksa + ", datumRodjenja="
                + datumRodjenja + ", datumPocetka=" + datumPocetka + ", polaznikKursevi=" + polaznikKursevi + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(brIndeksa, datumPocetka, datumRodjenja, ime, polaznikKursevi, prezime);
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
                && Objects.equals(polaznikKursevi, other.polaznikKursevi) && Objects.equals(prezime, other.prezime);
    }
}
