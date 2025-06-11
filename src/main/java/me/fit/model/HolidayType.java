package me.fit.model;

import jakarta.persistence.*;

@Entity
public class HolidayType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_type_seq")
    @SequenceGenerator(name = "holiday_type_seq", sequenceName = "holiday_type_seq", allocationSize = 1)
    private Long id;

    private String type;

    public HolidayType() {
    }

    public HolidayType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HolidayType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
