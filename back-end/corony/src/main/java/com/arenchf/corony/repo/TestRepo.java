package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Person;
import com.arenchf.corony.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TestRepo extends JpaRepository<Test,Integer> {

    @Query("SELECT t FROM Test t WHERE t.id = :id")
    Test findTestIntId(Integer id);


    @Query(value = "Select dbs2.getPercentageOfPositiveTest(:ort_name)",nativeQuery = true)
    Float getPercentageOfPositiveTestVonOrt(String ort_name);

    List<Test> findTestByResultat(Boolean resultat);

    @Query("SELECT u FROM Test u WHERE u.resultat = false ")
    List<Test> allFalseTests();

    @Query("SELECT u FROM Test u WHERE u.resultat = true ")
    List<Test> allTrueTests();


    @Modifying
    @Query("UPDATE Test t SET t.type = (CASE WHEN :type IS NULL THEN t.type ELSE :type END)," +
            "t.resultat = (CASE WHEN :resultat IS NULL THEN t.resultat ELSE :resultat END)," +
            "t.testDatum = (CASE WHEN :test_datum IS NULL THEN t.testDatum ELSE :test_datum END)," +
            "t.labor = (CASE WHEN :labor IS NULL THEN t.labor ELSE :labor END)," +
            "t.person = (CASE WHEN :person IS NULL THEN t.person ELSE :person END)" +
            " WHERE t.id = :id")
    void updateTest(@Param("id") Integer id, @Param("type") String type, @Param("resultat") Boolean resultat, @Param("test_datum") Timestamp test_datum, @Param("labor") Labor labor, @Param("person") Person person);


    @Modifying
    @Query("DELETE FROM Test t WHERE t.id = :id")
    void deleteTest(@Param("id") Integer id);

}
