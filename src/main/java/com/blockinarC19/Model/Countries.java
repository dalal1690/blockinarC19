package com.blockinarC19.Model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Entity name for the queries.
@Entity(name = "countries")
//MySql Table Name
@Table(name = "countries")

public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer country_id;
    @NotBlank(message = "Please select a country")
    @Column(name = "country", length = 255)
    private String country;

    @ManyToOne
    @JoinColumn(name="infected_id", referencedColumnName = "infected_id")
    private Infected infected;


    //CONTRUCTOR

    public Countries() {
    }

    public Countries(Integer country_id, @NotBlank(message = "Please select a country") String country, Infected infected) {
        this.country_id = country_id;
        this.country = country;
        this.infected = infected;
    }

    //GETTERS AND SETTERS

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Infected getInfected() {
        return infected;
    }

    public void setInfected(Infected infected) {
        this.infected = infected;
    }
}
