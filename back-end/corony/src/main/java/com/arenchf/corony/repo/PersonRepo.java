package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Person;
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
public interface PersonRepo extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM Person p WHERE p.id = :id")
    Person findPersonIntId(Integer id);


    @Modifying
    @Query("UPDATE Person p SET " +
            "p.geburtsdatum = (CASE WHEN :geburtsdatum IS NULL THEN p.geburtsdatum ELSE :geburtsdatum END)," +
            "p.mobilnummer = (CASE WHEN :mobilnummer IS NULL THEN p.mobilnummer ELSE :mobilnummer END), " +
            "p.nachname = (CASE WHEN :nachname IS NULL THEN p.nachname ELSE :nachname END)," +
            "p.geburtsjahr = (CASE WHEN :geburtsjahr IS NULL THEN p.geburtsjahr ELSE :geburtsjahr END)," +
            "p.haushalt = (CASE WHEN :haushalt IS NULL THEN p.haushalt ELSE :haushalt END), " +
            "p.regelung = (CASE WHEN :regelung IS NULL THEN p.regelung ELSE :regelung END)," +
            "p.vorname = (CASE WHEN :vorname IS NULL THEN p.vorname ELSE :vorname END)" +
            " WHERE p.id = :id")
    void updatePerson(@Param("id") Integer id,@Param("geburtsjahr") Integer geburtsjahr, @Param("geburtsdatum") Timestamp geburtsdatum, @Param("mobilnummer") Long mobilnummer, @Param("vorname") String vorname, @Param("nachname") String nachname, @Param("haushalt") Haushalt haushalt,@Param("regelung") Regelung regelung );


    @Modifying
    @Query("DELETE FROM Person p WHERE p.id = :id")
    void deletePerson(@Param("id") Integer id);


}
