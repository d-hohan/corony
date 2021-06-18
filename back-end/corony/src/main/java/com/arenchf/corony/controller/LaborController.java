package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.service.LaborService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labor/")
@CrossOrigin(origins = "*")
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

    @PatchMapping("/update/{id}")
    public void updateLabor(@PathVariable("id") Integer id, @RequestParam(required = false) Long anzahlTest,@RequestParam(required = false) Integer ort_id ){
        System.out.println("RECEIVED");
        laborService.updateLabor(id,anzahlTest,ort_id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLabor(@PathVariable("id") Integer id){
        laborService.deleteLabor(id);
    }

}
