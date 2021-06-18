package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AmtRepo extends JpaRepository<Amt,Integer> {

    @Query("SELECT a FROM Amt a WHERE a.id = :id")
    Amt findAmtById(Integer id);

    @Query("SELECT a FROM Amt a WHERE a.name = :name")
    Amt findAmtByName(String name);

    @Modifying
    @Query("UPDATE Amt a SET " +
            "a.name = (CASE WHEN :name IS NULL THEN a.name ELSE :name END)," +
            "a.beschreibung = (CASE WHEN :beschreibung IS NULL THEN a.beschreibung ELSE :beschreibung END) " +
            " WHERE a.id = :id")
    void updateAmt(@Param("id") Integer id, @Param("name") String name, @Param("beschreibung") String beschreibung );


    @Modifying
    @Query("DELETE FROM Amt a WHERE a.id = :id")
    void deleteAmt(@Param("id") Integer id);


}
