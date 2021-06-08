package com.arenchf.corony.service;

import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Test;
import com.arenchf.corony.repo.TestRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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


    public void addTest(Integer labor_id,Long testdatum, Integer person_id,Boolean resultat,String type){
        Labor labor = laborService.getLabor(labor_id);
        Person person = personService.getPerson(person_id);
        Test test = new Test();
        test.setLabor(labor);
        test.setPerson(person);
        test.setResultat(resultat);
        test.setTestDatum(new Timestamp(testdatum));
        test.setType(type);
        testRepo.save(test);
    }

    public Test getTest(Integer test_id){
        return testRepo.findTestIntId(test_id);
    }

    public List<Test> getAllPositiveTests(){
        return testRepo.allTrueTests();
    }


}
