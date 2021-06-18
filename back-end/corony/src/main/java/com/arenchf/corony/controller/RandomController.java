package com.arenchf.corony.controller;

import com.arenchf.corony.service.DummyDatenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    private final DummyDatenService dummyDatenService;

    public RandomController(DummyDatenService dummyDatenService) {
        this.dummyDatenService = dummyDatenService;
    }

    @RequestMapping("random/generate")
    private String generateDBrandomly(){
        dummyDatenService.erzeugen();
        return "OK";
    }

}
