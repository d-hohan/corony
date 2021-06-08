package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Amt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AmtRepo extends JpaRepository<Amt,Integer> {

    @Query("SELECT a FROM Amt a WHERE a.id = :id")
    Amt findAmtById(Integer id);

    @Query("SELECT a FROM Amt a WHERE a.name = :name")
    Amt findAmtByName(String name);
}
