package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Bundesland;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BundeslandRepo extends JpaRepository<Bundesland,Integer> {

    @Query("SELECT b FROM Bundesland b WHERE b.id = :id")
    Bundesland findBundeslandbyid(Integer id);

}
