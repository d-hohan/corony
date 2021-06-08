package com.arenchf.corony.service;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.OrtRepo;
import org.springframework.stereotype.Service;

@Service
public class OrtService {
    private final RegelungService regelungService;
    private final BundeslandService bundeslandService;
    private final OrtRepo ortRepo;

    public OrtService(RegelungService regelungService, BundeslandService bundeslandService, OrtRepo ortRepo) {
        this.regelungService = regelungService;
        this.bundeslandService = bundeslandService;
        this.ortRepo = ortRepo;
    }

    public void addOrt(String name, Integer regelung_id, Integer bundesland_id, Integer einwohner, Integer flaeche){
       Regelung regelung = regelungService.getRegelung(regelung_id);
       Bundesland bundesland = bundeslandService.getBundesland(bundesland_id);
       Ort ort = new Ort();
       ort.setBundesland(bundesland);
       ort.setRegelung(regelung);
       ort.setEinwohner(einwohner);
       ort.setFlaeche(flaeche);
       ort.setName(name);
       ortRepo.save(ort);
   }

   public Ort getOrt(Integer ort_id){
        return ortRepo.findOrtIntId(ort_id);
   }



}
