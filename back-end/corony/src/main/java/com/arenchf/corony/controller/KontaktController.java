package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Kontakt;
import com.arenchf.corony.service.KontaktService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kontakt/")
@CrossOrigin(origins = "*")
public class KontaktController {
    private final KontaktService kontaktService;

    public KontaktController(KontaktService kontaktService) {
        this.kontaktService = kontaktService;
    }

    @PostMapping("/add")
    public Boolean addKontakt(@RequestParam Integer person1_id, @RequestParam Integer person2_id, @RequestParam Long kontaktdatum){
        kontaktService.addKontakt(person1_id,person2_id,kontaktdatum);
        return true;
    }

    @GetMapping("/get/{id}")
    public Kontakt getKontaktById(@PathVariable("id") Integer id){
        return kontaktService.getKontakt(id);
    }


    @PatchMapping("/update/{id}")
    public void updateKontakt(@PathVariable("id") Integer id, @RequestParam(required = false) Long kontakt_datum, @RequestParam(required = false) Integer person1_id, @RequestParam(required = false) Integer person2_id ){
       System.out.println("RECEIVED");
        kontaktService.updateKontakt(id,kontakt_datum,person1_id,person2_id);
    }

    @DeleteMapping("/delete/{test_id}")
    public void deleteKontakt(@PathVariable("test_id") Integer id){
        kontaktService.deleteKontakt(id);
    }

}
