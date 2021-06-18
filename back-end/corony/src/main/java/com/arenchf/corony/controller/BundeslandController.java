package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Regelung;
import com.arenchf.corony.repo.RegelungRepo;
import com.arenchf.corony.service.BundeslandService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bundesland/")
@CrossOrigin(origins = "*")
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



    @PatchMapping("/update/{id}")
    public void updateBundesland(@PathVariable("id") Integer id, @RequestParam(required = false) Integer flaeche, @RequestParam(required = false) Integer einwohner, @RequestParam(required = false) String name, @RequestParam(required = false) Integer regelung_id ){
        System.out.println("RECEIVED");
        bundeslandService.updateBundesland(id,einwohner,flaeche,name,regelung_id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBundesland(@PathVariable("id") Integer id){
        bundeslandService.deleteBundesland(id);
    }


}
