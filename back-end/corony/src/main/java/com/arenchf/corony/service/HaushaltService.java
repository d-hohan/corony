package com.arenchf.corony.service;

import com.arenchf.corony.domain.*;
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


    public Haushalt addHaushalt(Integer amt_id, Integer ort_id, String strasse, Long festnetznummer){
        Amt amt = amtService.getAmt(amt_id);
        Ort ort = ortService.getOrt(ort_id);

        Haushalt haushalt = new Haushalt();
        haushalt.setAmt(amt);
        haushalt.setOrt(ort);
        haushalt.setStrasse(strasse);
        haushalt.setFestnetznummer(festnetznummer);
        haushaltRepo.save(haushalt);
        return haushalt;

    }

    public Haushalt getHaushalt(Integer haushalt_id){
        return haushaltRepo.findHaushaltIntId(haushalt_id);
    }


    public void updateHaushalt(Integer id, Long festnetznummer, String strasse, Integer amt_id,Integer ort_id){
        Ort ort = null;
        Amt amt = null;
        if(ort_id != null){
            ort = ortService.getOrt(ort_id);
        }
        if(amt_id != null){
            amt = amtService.getAmt(amt_id);
        }
        haushaltRepo.updateHaushalt(id,ort,amt,strasse,festnetznummer);
    }

    public void deleteHaushalt(Integer id){
        haushaltRepo.deleteHaushalt(id);
    }


}
