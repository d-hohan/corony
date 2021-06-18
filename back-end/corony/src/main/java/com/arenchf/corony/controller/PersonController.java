package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public Boolean addPerson(@RequestParam Integer haushalt_id, @RequestParam Integer regelung_id, @RequestParam(required = false) String nachname, @RequestParam(required = false) String vorname, @RequestParam(required = false) Long geburtsdatum, @RequestParam Integer geburtsjahr, @RequestParam(required = false) Long mobilnummer){
        System.out.println(geburtsdatum);
        personService.addPerson(haushalt_id,regelung_id,nachname,vorname,geburtsdatum,geburtsjahr,mobilnummer);
        return true;
    }

    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        return personService.getPerson(id);
    }

    @PatchMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") Integer id, @RequestParam(required = false) Long geburtsdatum, @RequestParam(required = false) Integer geburtsjahr, @RequestParam(required = false) Long mobilnummer,@RequestParam(required = false) String nachname, @RequestParam(required = false) String vorname, @RequestParam(required = false) Integer haushalt_id,@RequestParam(required = false) Integer regelung_id ){
        System.out.println("RECEIVED");
        personService.updatePerson(id,geburtsdatum,geburtsjahr,mobilnummer,nachname,vorname,haushalt_id,regelung_id);
    }

    @DeleteMapping("/delete/{person_id}")
    public void deletePerson(@PathVariable("person_id") Integer id){
        personService.deletePerson(id);
    }

}
