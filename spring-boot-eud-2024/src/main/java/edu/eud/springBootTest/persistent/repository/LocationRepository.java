package edu.eud.springBootTest.persistent.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.persistent.entity.LocationEntity;

@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Long>{

}
