package me.fit.model.client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import me.fit.model.Kurs;
import me.fit.model.Polaznik;

@Entity
public class PolaznikKurs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "polaznik_kurs_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    Polaznik polaznik;

    @ManyToOne(cascade = CascadeType.ALL)
    Kurs kurs;

    public PolaznikKurs() {
        super();
    }

    public PolaznikKurs(Polaznik polaznik, Kurs kurs) {
        super();
        this.polaznik = polaznik;
        this.kurs = kurs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((kurs == null) ? 0 : kurs.hashCode());
        result = prime * result + ((polaznik == null) ? 0 : polaznik.hashCode());
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
        PolaznikKurs other = (PolaznikKurs) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (kurs == null) {
            if (other.kurs != null)
                return false;
        } else if (!kurs.equals(other.kurs))
            return false;
        if (polaznik == null) {
            if (other.polaznik != null)
                return false;
        } else if (!polaznik.equals(other.polaznik))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PolaznikKurs [id=" + id + ", polaznik=" + polaznik + ", kurs=" + kurs + "]";
    }
}
