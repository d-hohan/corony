package com.arenchf.corony.service;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.AmtRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AmtService {
    private final AmtRepo amtRepo;

    public AmtService(AmtRepo amtRepo) {
        this.amtRepo = amtRepo;
    }

    public Amt addAmt(String name, String beschreibung){
        Amt amt = new Amt();
        amt.setName(name);
        amt.setBeschreibung(beschreibung);
        amtRepo.save(amt);
        return amt;
    }

    public Amt getAmt(Integer amt_id){
        return amtRepo.findAmtById(amt_id);
    }

    public Amt getAmt(String amt_name){
        return amtRepo.findAmtByName(amt_name);
    }


    public void updateAmt(Integer id, String name, String beschreibung){
        amtRepo.updateAmt(id,name,beschreibung);
    }

    public void deleteAmt(Integer id){
        amtRepo.deleteAmt(id);
    }


}
