package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.service.HaushaltService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/haushalt/")
public class HaushaltController {
    private final HaushaltService haushaltService;

    public HaushaltController(HaushaltService haushaltService) {
        this.haushaltService = haushaltService;
    }


    @PostMapping("/add")
    public Boolean addHaushalt(@RequestParam Integer ort_id, @RequestParam Integer amt_id, @RequestParam String strasse, @RequestParam(required = false) Long festnetznummer){
        haushaltService.addHaushalt(amt_id,ort_id,strasse,festnetznummer);
        return true;
    }

    @GetMapping("/get/{id}")
    public Haushalt getHaushaltById(@PathVariable("id") Integer id){
        return haushaltService.getHaushalt(id);
    }


}
