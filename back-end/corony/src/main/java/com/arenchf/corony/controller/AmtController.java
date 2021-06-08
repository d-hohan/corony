package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.service.AmtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amt/")
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
    @RequestMapping("/getbyid/{id}")
    public Amt getAmtById(@PathVariable("id") Integer id){
        return amtService.getAmt(id);
    }

}
