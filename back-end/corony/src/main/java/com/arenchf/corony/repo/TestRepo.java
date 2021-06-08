package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TestRepo extends JpaRepository<Test,Integer> {

    @Query("SELECT t FROM Test t WHERE t.id = :id")
    Test findTestIntId(Integer id);


    List<Test> findTestByResultat(Boolean resultat);

    @Query("SELECT u FROM Test u WHERE u.resultat = false ")
    List<Test> allFalseTests();

    @Query("SELECT u FROM Test u WHERE u.resultat = true ")
    List<Test> allTrueTests();


}
