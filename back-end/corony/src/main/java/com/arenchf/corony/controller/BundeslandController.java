package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.RegelungRepo;
import com.arenchf.corony.service.BundeslandService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bundesland/")
public class BundeslandController {
    private final BundeslandService bundeslandService;

    public BundeslandController(BundeslandService bundeslandService) {
        this.bundeslandService = bundeslandService;
    }


    @PostMapping("/add")
    public Boolean addBundesland(@RequestParam String name, @RequestParam Integer regelung_id, @RequestParam(required = false) Integer einwohner, @RequestParam(required = false) Integer flaeche){
        bundeslandService.addBundesland(name,regelung_id,einwohner,flaeche);
        return true;
    }

    @GetMapping("/get/{id}")
    public Bundesland getBundeslandById(@PathVariable("id") Integer id){
        return bundeslandService.getBundesland(id);
    }

}
