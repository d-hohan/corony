package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.service.OrtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ort")
@CrossOrigin(origins = "*")
public class OrtController {

    private final OrtService ortService;

    public OrtController(OrtService ortService) {
        this.ortService = ortService;
    }

    @PostMapping("/add")
    public Boolean addOrt(@RequestParam String name, @RequestParam Integer regelung_id, @RequestParam Integer bundesland_id, @RequestParam(required = false) Integer einwohner, @RequestParam(required = false) Integer flaeche){
        ortService.addOrt(name,regelung_id,bundesland_id,einwohner,flaeche);
        return true;
    }

    @GetMapping("/get/{id}")
    public Ort getOrt(@PathVariable("id") Integer id){
        return ortService.getOrt(id);
    }


    @PatchMapping("/update/{id}")
    public void updateOrt(@PathVariable("id") Integer id, @RequestParam(required = false) Integer flaeche, @RequestParam(required = false) Integer einwohner, @RequestParam(required = false) String name, @RequestParam(required = false) Integer bundesland_id,@RequestParam(required = false) Integer regelung_id ){
        System.out.println("RECEIVED");
        ortService.updateOrt(id,einwohner,flaeche,name,bundesland_id,regelung_id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrt(@PathVariable("id") Integer id){
        ortService.deleteOrt(id);
    }

}
