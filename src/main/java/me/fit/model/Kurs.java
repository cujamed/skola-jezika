package me.fit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import me.fit.model.client.PolaznikKurs;

@Entity
@NamedQuery(name = Kurs.GET_COURSES_FOR_LEVEL, query = "Select k from Kurs k where k.nivo.id = :id")
public class Kurs {
    public static final String GET_COURSES_FOR_LEVEL = "Kurs.getCoursesForLevel";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_seq")
    @SequenceGenerator(name = "kurs_seq", sequenceName = "kurs_seq", allocationSize = 1)
    private Long id;

    private String naziv;
    private double cijena;
    private int brCasova;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nivo_id")
    @JsonBackReference
    private Nivo nivo;

    //private Profesor profesor;

    @OneToMany(mappedBy = "kurs", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PolaznikKurs> polaznikKursevi = new HashSet<>();

    public Kurs() {
        super();
    }

    public Kurs(Long id, String naziv, double cijena, int brCasova, Nivo nivo/*, Profesor profesor*/) {
        super();
        this.id = id;
        this.naziv = naziv;
        this.cijena = cijena;
        this.brCasova = brCasova;
        this.nivo = nivo;
        //this.profesor = profesor;
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

    /*
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    */

    public Set<PolaznikKurs> getPolaznikKursevi() {
        return polaznikKursevi;
    }

    public void setPolaznikKursevi(Set<PolaznikKurs> polaznikKursevi) {
        this.polaznikKursevi = polaznikKursevi;
    }

    @Override
    public String toString() {
        return "Kurs [naziv=" + naziv + ", cijena=" + cijena + ", brCasova=" + brCasova + ", nivo=" + nivo
                /*+ ", profesor=" + profesor*/ + ", polaznikKursevi=" + polaznikKursevi + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(brCasova, cijena, naziv, nivo/*, profesor*/, polaznikKursevi);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Kurs other = (Kurs) obj;
        return brCasova == other.brCasova && Double.doubleToLongBits(cijena) == Double.doubleToLongBits(other.cijena)
                && Objects.equals(naziv, other.naziv) && Objects.equals(nivo, other.nivo)
                /*&& Objects.equals(profesor, other.profesor)*/ && Objects.equals(polaznikKursevi, other.polaznikKursevi);
    }
}