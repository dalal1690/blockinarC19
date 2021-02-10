package com.blockinarC19.Repository;

import com.blockinarC19.Model.Infected;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface InfectedRepository extends JpaRepository<Infected,Integer>, PagingAndSortingRepository <Infected,Integer> {

    // FIND INFECTED BY ID
    @Query ("SELECT u FROM infected u WHERE u.infected_id = ?1")
    Infected findByInfectedId(Integer id);

    //GET A LIST OF INFECTED BY ID
    @Query("SELECT p FROM infected p WHERE p.infected.infected_id = ?1")
    List<Infected> findAllInfectedById(Integer infected_id);

    // FIND INFECTED BY FIRST NAME
    @Query("SELECT u FROM infected u WHERE u.first_name = ?1")
    Infected findByFirstName(String first_name);

    // FIND INFECTED BY LAST NAME
    @Query("SELECT u FROM infected u WHERE u.last_name = ?1")
    Infected findByLastName(String last_name);

    // FIND INFECTED BY COUNTRY
    @Query("SELECT u FROM infected u WHERE u.country = ?1")
    Infected findByCountry(String country);

    // FIND INFECTED BY AGE
    @Query("SELECT u FROM infected u WHERE u.age = ?1")
    Infected findByAge(Integer age);

    // LIST OF ALL INFECTED ASCENDING ORDER BY NAME
    @Query(value= "SELECT u FROM infected u ORDER BY u.first_name ASC")
    List<Infected> findByFirstNameAsc();

    // LIST OF ALL INFECTED ASCENDING ORDER BY COUNTRY
    @Query(value= "SELECT u FROM infected u ORDER BY u.country ASC")
    List<Infected> findByCountryAsc();

}
