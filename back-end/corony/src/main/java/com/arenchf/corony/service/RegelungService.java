package com.arenchf.corony.service;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.RegelungRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;


@Service
@RequestMapping("/regelung/")
public class RegelungService {
    private final AmtService amtService;
    private final RegelungRepo regelungRepo;

    public RegelungService(AmtService amtService, RegelungRepo regelungRepo) {
        this.amtService = amtService;
        this.regelungRepo = regelungRepo;
    }

    public Regelung addRegelung(Integer amt_id, String vorschrift, Long regelung_von, Long regelung_bis){
        Amt amt = amtService.getAmt(amt_id);
        Regelung regelung = new Regelung();
        regelung.setAmt(amt);
        regelung.setVorschrift(vorschrift);
        regelung.setRegelung_von(new Timestamp(regelung_von));
        regelung.setRegelung_bis(new Timestamp(regelung_bis));
        regelungRepo.save(regelung);
        return regelung;
    }

    public Regelung getRegelung(Integer regelung_id){
        return regelungRepo.findRegelungIntId(regelung_id);
    }


    public void updateRegelung(Integer id, Long regelung_von, Long regelung_bis, String vorschrift, Integer amt_id){
        Amt amt = null;
        Timestamp timestamp_von = null;
        Timestamp timestamp_bis = null;
        if(amt_id != null){
            amt = amtService.getAmt(amt_id);
        }
        if(regelung_bis != null){
            timestamp_bis = new Timestamp(regelung_bis);
        }

        if(regelung_von != null){
            timestamp_von = new Timestamp(regelung_von);
        }
        regelungRepo.updatePerson(id,timestamp_bis,timestamp_von,vorschrift,amt);
    }

    public void deleteRegelung(Integer id){
        regelungRepo.deleteRegelung(id);
    }

}
