package com.arenchf.corony.service;

import com.arenchf.corony.domain.Kontakt;
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

    public void addKontakt(Integer person1_id, Integer person2_id, Long kontaktdatum){
        Person person1 = personService.getPerson(person1_id);
        Person person2 = personService.getPerson(person2_id);
        Kontakt kontakt = new Kontakt();
        kontakt.setKontaktDatum(new Timestamp(kontaktdatum));
        kontakt.setPerson1(person1);
        kontakt.setPerson2(person2);
        kontaktRepo.save(kontakt);
    }

    public Kontakt getKontakt(Integer kontakt_id){
        return kontaktRepo.findKontaktIntId(kontakt_id);
    }




}
