package com.arenchf.corony.repo;

import com.arenchf.corony.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HaushaltRepo extends JpaRepository<Haushalt,Integer> {

    @Query("SELECT h FROM Haushalt h WHERE h.id = :id")
    Haushalt findHaushaltIntId(Integer id);


    @Modifying
    @Query("UPDATE Haushalt h SET " +
            "h.ort = (CASE WHEN :ort IS NULL THEN h.ort ELSE :ort END)," +
            "h.amt = (CASE WHEN :amt IS NULL THEN h.amt ELSE :amt END), " +
            "h.festnetznummer = (CASE WHEN :festnetznummer IS NULL THEN h.festnetznummer ELSE :festnetznummer END)," +
            "h.strasse = (CASE WHEN :strasse IS NULL THEN h.strasse ELSE :strasse END)" +
            " WHERE h.id = :id")
    void updateHaushalt(@Param("id") Integer id, @Param("ort") Ort ort, @Param("amt") Amt amt, @Param("strasse") String strasse, @Param("festnetznummer") Long festnetznummer );


    @Modifying
    @Query("DELETE FROM Haushalt h WHERE h.id = :id")
    void deleteHaushalt(@Param("id") Integer id);


}
