package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.service.LaborService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labor/")
public class LaborController {
    private final LaborService laborService;

    public LaborController(LaborService laborService) {
        this.laborService = laborService;
    }


    @PostMapping("/add")
    public Boolean postLabor(@RequestParam Integer ort_id){
        laborService.addLabor(ort_id);
        return true;
    }

    @GetMapping("/get/{id}")
    public Labor getLaborById(@PathVariable("id") Integer id){
        return laborService.getLabor(id);
    }


}
