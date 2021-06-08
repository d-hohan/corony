package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Kontakt;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepo extends JpaRepository<Kontakt,Integer> {
    @Query("SELECT k FROM Kontakt k WHERE k.id = :id")
    Kontakt findKontaktIntId(Integer id);
}
