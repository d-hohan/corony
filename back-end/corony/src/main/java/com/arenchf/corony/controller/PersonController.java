package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public Boolean addPerson(@RequestParam Integer haushalt_id, @RequestParam Integer regelung_id, @RequestParam(required = false) String nachname, @RequestParam(required = false) String vorname, @RequestParam(required = false) Long geburtdatum, @RequestParam Integer geburtsjahr, @RequestParam(required = false) Long mobilnummer){
        personService.addPerson(haushalt_id,regelung_id,nachname,vorname,geburtdatum,geburtsjahr,mobilnummer);
        return true;
    }

    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        return personService.getPerson(id);
    }

}
