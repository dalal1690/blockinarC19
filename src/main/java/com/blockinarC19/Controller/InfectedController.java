package com.blockinarC19.Controller;

import com.blockinarC19.Model.Infected;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.blockinarC19.Service.InfectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/infected")
public class InfectedController {
    @Autowired
    InfectedService infectedService;

    Log log = LogFactory.getLog(InfectedController.class);

    //REGISTER A NEW INFECTED
    @PostMapping(path = "/register")
    @Operation(summary = "Register a new infected", description = "Saves a new infected in the data base")
    public ResponseEntity<Infected> registerInfected(@RequestBody Infected infected) {
        log.info("Register new infected: " + infected.getInfected_id());
        infectedService.newInfected(infected);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

     //GET A INFECTED BY ID
     @GetMapping(path = "/{infected_id}")
     @Operation(summary = "Finds an infected already saved", description = "Finds an infected already saved ind database")
     public ResponseEntity<Infected> findAnInfectedById(@PathVariable Integer infected_id, HttpServletRequest request) {
         infected_id = (Integer) request.getSession().getAttribute("infected_id");
         log.info("Infected called by id: " + infected_id);
         Infected foundInfected = infectedService.getInfectedById(infected_id);
         return new ResponseEntity<>(foundInfected,HttpStatus.OK);
     }

    //GET A LIST OF INFECTED
    @GetMapping(path = "/infected")
    @Operation(summary = "Finds all infected already saved", description = "Finds all infected already saved in database")
    public ResponseEntity<List<Infected>> infectedList(HttpServletRequest request) {
        Integer infected_id = (Integer) request.getSession().getAttribute("infected_id");
        log.info("List of infected called by id: " + infected_id);
        List<Infected> infected = infectedService.InfectedListbyId(infected_id);
        return new ResponseEntity<>(infected, HttpStatus.OK);
    }
}
