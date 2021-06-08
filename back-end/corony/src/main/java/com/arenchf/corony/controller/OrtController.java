package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.service.OrtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ort/")
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

}
