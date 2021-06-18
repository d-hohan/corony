package com.arenchf.corony.repo;

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
public interface BundeslandRepo extends JpaRepository<Bundesland,Integer> {

    @Query("SELECT b FROM Bundesland b WHERE b.id = :id")
    Bundesland findBundeslandbyid(Integer id);


    @Modifying
    @Query("UPDATE Bundesland b SET " +
            "b.name = (CASE WHEN :name IS NULL THEN b.name ELSE :name END)," +
            "b.einwohner = (CASE WHEN :einwohner IS NULL THEN b.einwohner ELSE :einwohner END)," +
            "b.flaeche = (CASE WHEN :flaeche IS NULL THEN b.flaeche ELSE :flaeche END)," +
            "b.regelung = (CASE WHEN :regelung IS NULL THEN b.regelung ELSE :regelung END)" +
            " WHERE b.id = :id")
    void updateBundesland(@Param("id") Integer id, @Param("regelung") Regelung regelung, @Param("name") String name, @Param("einwohner") Integer einwohner, @Param("flaeche") Integer flaeche );


    @Modifying
    @Query("DELETE FROM Bundesland b WHERE b.id = :id")
    void deleteBundesland(@Param("id") Integer id);


}
