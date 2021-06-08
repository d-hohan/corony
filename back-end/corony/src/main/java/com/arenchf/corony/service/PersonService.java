package com.arenchf.corony.service;

import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PersonService {
    private final HaushaltService haushaltService;
    private final RegelungService regelungService;
    private final PersonRepo personRepo;

    public PersonService(HaushaltService haushaltService, RegelungService regelungService, PersonRepo personRepo) {
        this.haushaltService = haushaltService;
        this.regelungService = regelungService;
        this.personRepo = personRepo;
    }

    public void addPerson(Integer haushalt_id, Integer regelung_id, String nachname, String vorname, Long geburtsdatum, Integer geburtsjahr, Long mobilnummer){
        Haushalt haushalt = haushaltService.getHaushalt(haushalt_id);
        Regelung regelung = regelungService.getRegelung(regelung_id);
        Person person = new Person();
        if(geburtsdatum!=null){
            person.setGeburtsdatum(new Timestamp(geburtsdatum));
        }else person.setGeburtsdatum(null);

        person.setHaushalt(haushalt);
        person.setRegelung(regelung);
        person.setMobilnummer(mobilnummer);
        person.setNachname(nachname);
        person.setVorname(vorname);
        person.setGeburtsjahr(geburtsjahr);
        personRepo.save(person);

    }

    public Person getPerson(Integer person_id){
        return personRepo.findPersonIntId(person_id);
    }


}
