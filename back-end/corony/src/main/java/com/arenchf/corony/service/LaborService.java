package com.arenchf.corony.service;
import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.LaborRepo;
import org.springframework.stereotype.Service;


@Service
public class LaborService {
    private final OrtService ortService;
    private final LaborRepo laborRepo;

    public LaborService(OrtService ortService, LaborRepo laborRepo) {
        this.ortService = ortService;
        this.laborRepo = laborRepo;
    }

    public Labor addLabor(Integer ort_id){
        Ort ort = ortService.getOrt(ort_id);
        Labor labor = new Labor();
        labor.setOrt(ort);
        laborRepo.save(labor);
        return labor;
    }

    public Labor getLabor(Integer labor_id){
        return laborRepo.findLaborIntId(labor_id);
    }

    public void updateLabor(Integer id, Long anzahlTest,Integer ort_id){
        Ort ort = null;
        if(ort_id != null){
            ort = ortService.getOrt(ort_id);
        }
        laborRepo.updateLabor(id,ort,anzahlTest);
    }

    public void deleteLabor(Integer id){
        laborRepo.deleteLabor(id);
    }


}
