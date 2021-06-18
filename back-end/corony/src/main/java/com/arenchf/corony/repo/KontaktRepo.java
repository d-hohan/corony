package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Kontakt;
import com.arenchf.corony.domain.Labor;
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
public interface KontaktRepo extends JpaRepository<Kontakt,Integer> {
    @Query("SELECT k FROM Kontakt k WHERE k.id = :id")
    Kontakt findKontaktIntId(Integer id);


    @Modifying
    @Query("UPDATE Kontakt k SET " +
            "k.kontaktDatum = (CASE WHEN :kontakt_datum IS NULL THEN k.kontaktDatum ELSE :kontakt_datum END)," +
            "k.person1 = (CASE WHEN :person1 IS NULL THEN k.person1 ELSE :person1 END)," +
            "k.person2 = (CASE WHEN :person2 IS NULL THEN k.person2 ELSE :person2 END)" +
            " WHERE k.id = :id")
    void updateKontakt(@Param("id") Integer id, @Param("kontakt_datum") Timestamp kontakt_datum, @Param("person1") Person person1,@Param("person2") Person person2);


    @Modifying
    @Query("DELETE FROM Kontakt k WHERE k.id = :id")
    void deleteKontakt(@Param("id") Integer id);


}
