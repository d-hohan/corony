package com.arenchf.corony.controller;

import com.arenchf.corony.domain.Test;
import com.arenchf.corony.service.TestService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/")
@CrossOrigin(origins = "*")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }
    
    @RequestMapping("/allpositive/")
    public List<Test> test(){
        return testService.getAllPositiveTests();
    }

    @RequestMapping("/allpositivetests/ort/{ort_name}")
    public Float testfunctionpositive(@PathVariable String ort_name){
        return testService.getAllPositiveTestsWithFunction(ort_name);
    }

    @GetMapping("/get/{test_id}")
    public Test getTest(@PathVariable Integer test_id){
        return testService.getTest(test_id);
    }

    @PostMapping("/add")
    public Boolean addTest(@RequestParam Integer labor_id, @RequestParam Integer person_id, @RequestParam Long testdatum, @RequestParam Boolean result, @RequestParam(required = false) String type){
        System.out.println("ADD RECEIVED");
        testService.addTest(labor_id,testdatum,person_id,result,type);
        return true;
    }

    @PatchMapping("/update/{id}/")
    public void updateTest(@PathVariable("id") Integer id, @RequestParam(required = false) Boolean resultat,@RequestParam(required = false) Long test_datum, @RequestParam(required = false) String type, @RequestParam(required = false) Integer labor_id, @RequestParam(required = false) Integer person_id ){
        testService.updateTest(id,resultat,test_datum,type,labor_id,person_id);
    }

    @DeleteMapping("/delete/{test_id}")
    public void deleteTest(@PathVariable("test_id") Integer id){
        testService.deleteTest(id);
    }



}
