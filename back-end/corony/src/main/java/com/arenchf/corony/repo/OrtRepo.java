package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Ort;
import com.arenchf.corony.domain.Regelung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtRepo extends JpaRepository<Ort,Integer> {

    @Query("SELECT o FROM Ort o WHERE o.id = :id")
    Ort findOrtIntId(Integer id);
}
