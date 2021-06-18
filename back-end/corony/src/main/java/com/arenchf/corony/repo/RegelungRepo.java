package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Haushalt;
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
public interface RegelungRepo extends JpaRepository<Regelung,Integer> {

    @Query("SELECT r FROM Regelung r WHERE r.id = :id")
    Regelung findRegelungIntId(Integer id);

    @Modifying
    @Query("UPDATE Regelung r SET " +
            "r.regelung_bis = (CASE WHEN :regelung_bis IS NULL THEN r.regelung_bis ELSE :regelung_bis END)," +
            "r.regelung_von = (CASE WHEN :regelung_von IS NULL THEN r.regelung_von ELSE :regelung_von END), " +
            "r.vorschrift = (CASE WHEN :vorschrift IS NULL THEN r.vorschrift ELSE :vorschrift END)," +
            "r.amt = (CASE WHEN :amt IS NULL THEN r.amt ELSE :amt END)" +
            " WHERE r.id = :id")
    void updatePerson(@Param("id") Integer id, @Param("regelung_bis") Timestamp regelung_bis,@Param("regelung_von") Timestamp regelung_von, @Param("vorschrift") String vorschrift, @Param("amt") Amt amt );


    @Modifying
    @Query("DELETE FROM Regelung r WHERE r.id = :id")
    void deleteRegelung(@Param("id") Integer id);

}
