package com.arenchf.corony.repo;

import com.arenchf.corony.domain.Haushalt;
import com.arenchf.corony.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {

    @Query("SELECT p FROM Person p WHERE p.id = :id")
    Person findPersonIntId(Integer id);
}
