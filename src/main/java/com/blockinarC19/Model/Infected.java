package com.blockinarC19.Model;

import com.blockinarC19.Enums.Gender;
import com.blockinarC19.Enums.Live;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

//Entity name for the queries.
@Entity(name = "infected")
//MySql Table Name
@Table(name = "infected")

public class Infected {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "infected_id")
    private Integer infected_id;
    @NotBlank(message = "Ingrese su nombre")
    @Column(name = "first_name", length = 255 , nullable=false)
    private String first_name;
    @NotBlank(message = "Ingrese su apellido")
    @Column(name = "last_name", length = 255, nullable=false)
    private String last_name;
    //Live handled with an enum class
    @Column(name = "live")
    @Enumerated(EnumType.STRING)
    private Live live;
    //Gender handle with an enum class
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "age", length = 3)
    private Integer age;
    //Time handle with a temporal notation
    @Column(name = "infect_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infect_date;

    @OneToMany (mappedBy="infected", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JsonIgnore
    private List<Countries> countriesList;

    //CONSTRUCTOR
    public Infected() {
    }

    public Infected(Integer infected_id, @NotBlank(message = "Ingrese su nombre") String first_name, @NotBlank(message = "Ingrese su apellido") String last_name, Live live, Gender gender, Integer age, Date infect_date, List<Countries> countriesList) {
        this.infected_id = infected_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.live = live;
        this.gender = gender;
        this.age = age;
        this.infect_date = infect_date;
        this.countriesList = countriesList;
    }

    //GETTERS AND SETTERS

    public Integer getInfected_id() {
        return infected_id;
    }

    public void setInfected_id(Integer infected_id) {
        this.infected_id = infected_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Live getLive() {
        return live;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getInfect_date() {
        return infect_date;
    }

    public void setInfect_date(Date infect_date) {
        this.infect_date = infect_date;
    }

    public List<Countries> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Countries> countriesList) {
        this.countriesList = countriesList;
    }
}
