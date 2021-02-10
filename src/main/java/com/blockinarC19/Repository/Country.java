package com.blockinarC19.Repository;

import com.blockinarC19.Model.Infected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Country extends JpaRepository<Infected,Integer> {
    // FIND COUNTRY
    @Query("SELECT u FROM countries u WHERE u.country = ?1")
    Infected findByCountry(String first_name);

}
