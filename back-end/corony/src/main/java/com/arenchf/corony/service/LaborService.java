package com.arenchf.corony.service;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.repo.LaborRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LaborService {
    private final OrtService ortService;
    private final LaborRepo laborRepo;

    public LaborService(OrtService ortService, LaborRepo laborRepo) {
        this.ortService = ortService;
        this.laborRepo = laborRepo;
    }

    public void addLabor(Integer ort_id){
        Ort ort = ortService.getOrt(ort_id);
        Labor labor = new Labor();
        labor.setOrt(ort);
        laborRepo.save(labor);
    }

    public Labor getLabor(Integer labor_id){
        return laborRepo.findLaborIntId(labor_id);
    }

}
