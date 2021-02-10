package com.blockinarC19.Service;

import com.blockinarC19.Exception.BadRequestException;
import com.blockinarC19.Exception.NotFoundException;
import com.blockinarC19.Model.Infected;
import com.blockinarC19.Repository.InfectedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InfectedService {

    @Autowired
    InfectedRepository infectedRepository;
    //REPOSITORY METHODS IMPLEMENTATION

    //ADDING NEW INFECTED
    public Infected newInfected (Infected infected) {
        if (infected.getFirst_name() == null || infected.getFirst_name().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el nombre del contagiado");
        }
        if (infected.getLast_name() == null || infected.getLast_name().isEmpty()) {
            throw new BadRequestException("Usuario debe indicar el apellido del contagiado");
        } else {
            return infectedRepository.save(infected);
        }
    }

    //GET INFECTED BY ID
    public Infected getInfectedById(Integer infected_id) {
        Infected infectedSaved = infectedRepository.findByInfectedId(infected_id);
        if (infectedSaved == null) {
            throw new NotFoundException ("Infected does not exist in the database");
        } else {
            return infectedSaved;
        }
    }
    // GET A LIST OF INFECTED BY ID
    public List<Infected> InfectedListbyId(Integer infected_id) {
        List<Infected> InfectedListbyId = infectedRepository.findAllInfectedById(infected_id);
        return InfectedListbyId;
    }

    //GET INFECTED BY NAME
    public Infected getInfectedByFirstName(String first_name) {
        Infected findInfectedByName = infectedRepository.findByFirstName(first_name);
        if (findInfectedByName == null) {
            throw new NotFoundException("Infected does not exist in the database");
        } else {
            return findInfectedByName;
        }
    }

    //GET INFECTED BY LAST NAME
    public Infected getInfectedByLastName(String last_name) {
        Infected findInfectedByLastName = infectedRepository.findByLastName(last_name);
        if (findInfectedByLastName == null) {
            throw new NotFoundException("Infected does not exist in the database");
        } else {
            return findInfectedByLastName;
        }
    }

    //GET INFECTED BY COUNTRY
    public Infected getInfectedByCountry(String country) {
        Infected findInfectedCountry = infectedRepository.findByCountry(country);
        if (findInfectedCountry == null) {
            throw new NotFoundException("Country is not registered in the database");
        } else {
            return findInfectedCountry;
        }
    }

    //GET INFECTED BY AGE
    public Infected getInfectedByAge(Integer age) {
        Infected findInfectedbyAge = infectedRepository.findByAge(age);
        if (findInfectedbyAge == null) {
            throw new NotFoundException("There are no infected with that age");
        } else {
            return findInfectedbyAge;
        }
    }

    //GET LIST OF INFECTED ORDER BY NAME
    public List<Infected> InfectedListOrderByName(String first_name) {
        List<Infected> InfectedListOrderByName = infectedRepository.findByFirstNameAsc();
        return InfectedListOrderByName;
    }

    //GET LIST OF INFECTED ORDER BY COUNNTRY
    public List<Infected> InfectedListByCountry(String country) {
        List<Infected> InfectedListByCountry = infectedRepository.findByCountryAsc();
        return InfectedListByCountry;
    }

}


