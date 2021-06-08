package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Test;
import com.arenchf.corony.service.TestService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test/")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/allpositive/")
    public List<Test> test(){
        return testService.getAllPositiveTests();
    }

    @PutMapping("/add")
    public Boolean addTest(@RequestParam Integer labor_id, @RequestParam Integer person_id, @RequestParam Long testdatum, @RequestParam Boolean result, @RequestParam(required = false) String type){
        testService.addTest(labor_id,testdatum,person_id,result,type);
        return true;
    }

}
