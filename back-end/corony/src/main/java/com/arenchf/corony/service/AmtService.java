package com.arenchf.corony.service;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.repo.AmtRepo;
import org.springframework.stereotype.Service;

@Service
public class AmtService {
    private final AmtRepo amtRepo;

    public AmtService(AmtRepo amtRepo) {
        this.amtRepo = amtRepo;
    }

    public void addAmt(String name, String beschreibung){
        Amt amt = new Amt();
        amt.setName(name);
        amt.setBeschreibung(beschreibung);
        amtRepo.save(amt);
    }

    public Amt getAmt(Integer amt_id){
        return amtRepo.findAmtById(amt_id);
    }

    public Amt getAmt(String amt_name){
        return amtRepo.findAmtByName(amt_name);
    }



}
