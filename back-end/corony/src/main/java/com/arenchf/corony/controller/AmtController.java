package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.service.AmtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amt/")
@CrossOrigin(origins = "*")
public class AmtController {
    private final AmtService amtService;

    public AmtController(AmtService amtService) {
        this.amtService = amtService;
    }

    @PostMapping("/add")
    public Boolean addTest(@RequestParam String name, @RequestParam(required = false) String beschreibung){
        amtService.addAmt(name,beschreibung);
        return true;
    }
    @GetMapping("/getbyid/{id}")
    public Amt getAmtById(@PathVariable("id") Integer id){
        return amtService.getAmt(id);
    }

    @PatchMapping("/update/{id}")
    public void updateAmt(@PathVariable("id") Integer id, @RequestParam(required = false) String name,  @RequestParam(required = false) String beschreibung){
        System.out.println("RECEIVED");
        amtService.updateAmt(id,name,beschreibung);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAmt(@PathVariable("id") Integer id){
        amtService.deleteAmt(id);
    }

}
