package com.arenchf.corony.service;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.HaushaltRepo;
import org.springframework.stereotype.Service;

@Service
public class HaushaltService {

    private final OrtService ortService;
    private final AmtService amtService;
    private final HaushaltRepo haushaltRepo;

    public HaushaltService(OrtService ortService, AmtService amtService, HaushaltRepo haushaltRepo) {
        this.ortService = ortService;
        this.amtService = amtService;
        this.haushaltRepo = haushaltRepo;
    }


    public void addHaushalt(Integer amt_id, Integer ort_id, String starsse, Long festnetznummer){
        Amt amt = amtService.getAmt(amt_id);
        Ort ort = ortService.getOrt(ort_id);

        Haushalt haushalt = new Haushalt();
        haushalt.setAmt(amt);
        haushalt.setOrt(ort);
        haushalt.setStrasse(starsse);
        haushalt.setFestnetznummer(festnetznummer);
        haushaltRepo.save(haushalt);

    }

    public Haushalt getHaushalt(Integer haushalt_id){
        return haushaltRepo.findHaushaltIntId(haushalt_id);
    }

}
