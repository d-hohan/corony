package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Amt;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegelungRepo extends JpaRepository<Regelung,Integer> {

    @Query("SELECT r FROM Regelung r WHERE r.id = :id")
    Regelung findRegelungIntId(Integer id);

}
