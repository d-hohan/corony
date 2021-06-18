package com.arenchf.corony.service;

import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Test;
import com.arenchf.corony.repo.TestRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepo testRepo;
    private final LaborService laborService;
    private final PersonService personService;

    public TestService(TestRepo testRepo, LaborService laborService, PersonService personService) {
        this.testRepo = testRepo;
        this.laborService = laborService;
        this.personService = personService;
    }


    public Test addTest(Integer labor_id,Long testdatum, Integer person_id,Boolean resultat,String type){
        Labor labor = laborService.getLabor(labor_id);
        Person person = personService.getPerson(person_id);
        Test test = new Test();
        test.setLabor(labor);
        test.setPerson(person);
        test.setResultat(resultat);
        test.setTestDatum(new Timestamp(testdatum));
        test.setType(type);
        testRepo.save(test);
        return test;
    }
    public Float getAllPositiveTestsWithFunction(String ort_name){
        Float flo = testRepo.getPercentageOfPositiveTestVonOrt(ort_name);
        System.out.println(flo);
        return flo;
    }

    public Test getTest(Integer test_id){
        return testRepo.findTestIntId(test_id);
    }

    public List<Test> getAllPositiveTests(){
        return testRepo.allTrueTests();
    }

    public void updateTest(Integer id, Boolean resultat, Long test_datum, String type, Integer labor_id, Integer person_id){
        Person person = null;
        Timestamp timestamp = null;
        Labor labor = null;
        if(person_id != null){
            person = personService.getPerson(person_id);
        }
        if(labor_id != null){
            labor = laborService.getLabor(labor_id);
        }
        if(test_datum != null){
            timestamp = new Timestamp(test_datum);
        }
        testRepo.updateTest(id,type,resultat,timestamp,labor,person);
    }

    public void deleteTest(Integer id){
        testRepo.deleteTest(id);
    }

}
