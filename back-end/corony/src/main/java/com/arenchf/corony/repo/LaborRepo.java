package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Labor;
import com.arenchf.corony.domain.Ort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborRepo extends JpaRepository<Labor,Integer> {

    @Query("SELECT l FROM Labor l WHERE l.id = :id")
    Labor findLaborIntId(Integer id);
}
