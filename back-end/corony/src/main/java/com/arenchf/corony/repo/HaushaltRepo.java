package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HaushaltRepo extends JpaRepository<Haushalt,Integer> {

    @Query("SELECT h FROM Haushalt h WHERE h.id = :id")
    Haushalt findHaushaltIntId(Integer id);

}
