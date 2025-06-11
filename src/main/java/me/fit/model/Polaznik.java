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
    private String filePath;

    @OneToMany(mappedBy = "polaznik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PolaznikKurs> polaznikKursevi = new HashSet<>();

    public Polaznik() {
        super();
    }

    public Polaznik(String ime, String prezime, String brIndeksa, Date datumRodjenja, Date datumPocetka, String filePath) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa = brIndeksa;
        this.datumRodjenja = datumRodjenja;
        this.datumPocetka = datumPocetka;
        this.filePath = filePath;
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
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Polaznik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", brIndeksa=" + brIndeksa
                + ", datumRodjenja=" + datumRodjenja + ", datumPocetka=" + datumPocetka + ", filePath=" + filePath
                + ", polaznikKursevi=" + polaznikKursevi + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ime == null) ? 0 : ime.hashCode());
        result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
        result = prime * result + ((brIndeksa == null) ? 0 : brIndeksa.hashCode());
        result = prime * result + ((datumRodjenja == null) ? 0 : datumRodjenja.hashCode());
        result = prime * result + ((datumPocetka == null) ? 0 : datumPocetka.hashCode());
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        result = prime * result + ((polaznikKursevi == null) ? 0 : polaznikKursevi.hashCode());
        return result;
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ime == null) {
            if (other.ime != null)
                return false;
        } else if (!ime.equals(other.ime))
            return false;
        if (prezime == null) {
            if (other.prezime != null)
                return false;
        } else if (!prezime.equals(other.prezime))
            return false;
        if (brIndeksa == null) {
            if (other.brIndeksa != null)
                return false;
        } else if (!brIndeksa.equals(other.brIndeksa))
            return false;
        if (datumRodjenja == null) {
            if (other.datumRodjenja != null)
                return false;
        } else if (!datumRodjenja.equals(other.datumRodjenja))
            return false;
        if (datumPocetka == null) {
            if (other.datumPocetka != null)
                return false;
        } else if (!datumPocetka.equals(other.datumPocetka))
            return false;
        if (filePath == null) {
            if (other.filePath != null)
                return false;
        } else if (!filePath.equals(other.filePath))
            return false;
        if (polaznikKursevi == null) {
            if (other.polaznikKursevi != null)
                return false;
        } else if (!polaznikKursevi.equals(other.polaznikKursevi))
            return false;
        return true;
    }

    
}
