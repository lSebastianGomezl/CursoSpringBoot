package edu.eud.springBootTest.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.persistent.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String>{

}
