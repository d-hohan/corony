package com.arenchf.corony.service;

import com.arenchf.corony.domain.Kontakt;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.KontaktRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class KontaktService {
    private final PersonService personService;
    private final KontaktRepo kontaktRepo;


    public KontaktService(PersonService personService, KontaktRepo kontaktRepo) {
        this.personService = personService;
        this.kontaktRepo = kontaktRepo;
    }

    public Kontakt addKontakt(Integer person1_id, Integer person2_id, Long kontaktdatum){
        Person person1 = personService.getPerson(person1_id);
        Person person2 = personService.getPerson(person2_id);
        Kontakt kontakt = new Kontakt();
        kontakt.setKontaktDatum(new Timestamp(kontaktdatum));
        kontakt.setPerson1(person1);
        kontakt.setPerson2(person2);
        kontaktRepo.save(kontakt);
        return kontakt;
    }

    public Kontakt getKontakt(Integer kontakt_id){
        return kontaktRepo.findKontaktIntId(kontakt_id);
    }

    public void updateKontakt(Integer id, Long kontakt_datum, Integer person1_id,Integer person2_id){
        Person person1 = null;
        Person person2 = null;
        Timestamp timestamp = null;
        if(person1_id != null){
            person1 = personService.getPerson(person1_id);
        }
        if(person2_id != null){
            person2 = personService.getPerson(person2_id);
        }
        if(kontakt_datum != null){
            timestamp = new Timestamp(kontakt_datum);
        }
        kontaktRepo.updateKontakt(id,timestamp,person1,person2);
    }

    public void deleteKontakt(Integer id){
        kontaktRepo.deleteKontakt(id);
    }


}
