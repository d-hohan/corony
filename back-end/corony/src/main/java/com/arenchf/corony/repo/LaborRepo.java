package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LaborRepo extends JpaRepository<Labor,Integer> {

    @Query("SELECT l FROM Labor l WHERE l.id = :id")
    Labor findLaborIntId(Integer id);


    @Modifying
    @Query("UPDATE Labor l SET " +
            "l.anzahlTest = (CASE WHEN :anzahlTest IS NULL THEN l.anzahlTest ELSE :anzahlTest END)," +
            "l.ort = (CASE WHEN :ort IS NULL THEN l.ort ELSE :ort END) " +
            " WHERE l.id = :id")
    void updateLabor(@Param("id") Integer id, @Param("ort") Ort ort,@Param("anzahlTest") Long anzahlTest);


    @Modifying
    @Query("DELETE FROM Labor l WHERE l.id = :id")
    void deleteLabor(@Param("id") Integer id);


}
