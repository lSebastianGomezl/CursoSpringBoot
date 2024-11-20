package edu.eud.springBootTest.persistent.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.eud.springBootTest.persistent.entity.RegionEntity;

@Repository
public interface RegionRepository extends CrudRepository<RegionEntity, Long>{
	
	@Transactional
	@Modifying
	@Query(value = ""
			+ "DELETE FROM RegionEntity r "
			+ "WHERE r.id = ?1",
			nativeQuery = false)
	void borrarPorId(Long id);
	
	@Transactional
	@Modifying
	@Query(value = ""
			+ "DELETE FROM regions r "
			+ "WHERE r.region_id = ?1",
			nativeQuery = true)
	void borrarPorIdSql(Long id);
	
	@Transactional
	@Modifying
	@Query(value = ""
			+ "UPDATE RegionEntity r "
			+ "SET r.name = :region_name "
			+ "WHERE r.id = :region_id ",
			nativeQuery = false)
	void actualizarPorId(@Param("region_id") Long id, @Param("region_name") String name);
	
	@Transactional
	@Modifying
	@Query(value = ""
			+ "UPDATE regions r "
			+ "SET r.region_name = :region_name "
			+ "WHERE r.region_id = :region_id ",
			nativeQuery = true)
	void actualizarPorIdSql(@Param("region_id") Long id, @Param("region_name") String name);

}
