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


    public Bundesland addBundesland(String name, Integer regelung_id,Integer einwohner,Integer flaeche){
        Regelung regelung = regelungService.getRegelung(regelung_id);
        System.out.println("GOT REGELUNG: "+regelung);
        Bundesland bundesland = new Bundesland();
        bundesland.setName(name);
        bundesland.setEinwohner(einwohner);
        bundesland.setFlaeche(flaeche);
        bundesland.setRegelung(regelung);
        bundeslandRepo.save(bundesland);
        return bundesland;
    }

    public Bundesland getBundesland(Integer bundesland_id){
        return bundeslandRepo.findBundeslandbyid(bundesland_id);
    }


    public void updateBundesland(Integer id, Integer einwohner, Integer flaeche, String name,Integer regelung_id){
        Regelung regelung = null;
        if(regelung_id != null){
            regelung = regelungService.getRegelung(regelung_id);
        }
        bundeslandRepo.updateBundesland(id,regelung,name,einwohner,flaeche);
    }

    public void deleteBundesland(Integer id){
        bundeslandRepo.deleteBundesland(id);
    }



}
