package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Bundesland;
import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
@Transactional
public interface OrtRepo extends JpaRepository<Ort,Integer> {

    @Query("SELECT o FROM Ort o WHERE o.id = :id")
    Ort findOrtIntId(Integer id);




    @Modifying
    @Query("UPDATE Ort o SET " +
            "o.name = (CASE WHEN :name IS NULL THEN o.name ELSE :name END)," +
            "o.bundesland = (CASE WHEN :bundesland IS NULL THEN o.bundesland ELSE :bundesland END), " +
            "o.einwohner = (CASE WHEN :einwohner IS NULL THEN o.einwohner ELSE :einwohner END)," +
            "o.flaeche = (CASE WHEN :flaeche IS NULL THEN o.flaeche ELSE :flaeche END)," +
            "o.regelung = (CASE WHEN :regelung IS NULL THEN o.regelung ELSE :regelung END)" +
            " WHERE o.id = :id")
    void updateOrt(@Param("id") Integer id, @Param("regelung") Regelung regelung, @Param("bundesland") Bundesland bundesland, @Param("name") String name, @Param("einwohner") Integer einwohner, @Param("flaeche") Integer flaeche );


    @Modifying
    @Query("DELETE FROM Ort o WHERE o.id = :id")
    void deleteOrt(@Param("id") Integer id);


}
