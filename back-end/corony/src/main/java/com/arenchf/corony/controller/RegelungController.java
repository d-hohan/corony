package com.arenchf.corony.controller;


import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.service.RegelungService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regelung/")
@CrossOrigin(origins = "*")
public class RegelungController {
    private final RegelungService regelungService;

    public RegelungController(RegelungService regelungService) {
        this.regelungService = regelungService;
    }

    @PostMapping("/add")
    public Boolean addTest(@RequestParam Integer amt_id, @RequestParam String vorschrift, @RequestParam(required = false) Long regelung_von, @RequestParam(required = false) Long regelung_bis){
        regelungService.addRegelung(amt_id,vorschrift,regelung_von,regelung_bis);
        return true;
    }

    @GetMapping("/get/{id}")
    public Regelung getAmtById(@PathVariable("id") Integer id){
        return regelungService.getRegelung(id);
    }


    @PatchMapping("/update/{id}")
    public void updateRegelung(@PathVariable("id") Integer id, @RequestParam(required = false) Long regelung_von, @RequestParam(required = false) Long regelung_bis, @RequestParam(required = false) String vorschrift, @RequestParam(required = false) Integer amt_id ){
        System.out.println("RECEIVED");
        regelungService.updateRegelung(id,regelung_von,regelung_bis,vorschrift,amt_id);
    }

    @DeleteMapping("/delete/{regelung_id}")
    public void deletePerson(@PathVariable("regelung_id") Integer id){
        regelungService.deleteRegelung(id);
    }


}
