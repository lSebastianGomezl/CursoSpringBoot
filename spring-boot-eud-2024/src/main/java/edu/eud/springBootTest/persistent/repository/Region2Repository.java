package edu.eud.springBootTest.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.persistent.entity.RegionEntity;

@Repository
public interface Region2Repository extends JpaRepository<RegionEntity, Long>{

}
