package com.arenchf.corony.service;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.BundeslandRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BundeslandService {
    private final BundeslandRepo bundeslandRepo;
    private final RegelungService regelungService;

    public BundeslandService(BundeslandRepo bundeslandRepo, RegelungService regelungService) {
        this.bundeslandRepo = bundeslandRepo;
        this.regelungService = regelungService;
    }


    public void addBundesland(String name, Integer regelung_id,Integer einwohner,Integer flaeche){
        Regelung regelung = regelungService.getRegelung(regelung_id);
        Bundesland bundesland = new Bundesland();
        bundesland.setName(name);
        bundesland.setEinwohner(einwohner);
        bundesland.setFlaeche(flaeche);
        bundesland.setRegelung(regelung);
        bundeslandRepo.save(bundesland);
    }

    public Bundesland getBundesland(Integer bundesland_id){
        return bundeslandRepo.findBundeslandbyid(bundesland_id);
    }
}
