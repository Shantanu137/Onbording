package com.cts.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.entity.Associates;
import com.cts.entity.SoftBlockAssociateDetails;

public interface SoftBlockAssociateDetailsRepository extends JpaRepository<SoftBlockAssociateDetails, Long> {

	@Query("select soId from Associates")
	public List<Long> findSoId(@Param("id") Long id);

	@Query("from Associates where soId=:id")
	public Optional<Associates> findAssociateById(@Param("id") Long id);

	@Query("from SoftBlockAssociateDetails where soId=:id")
	public List<SoftBlockAssociateDetails> findBySoId(@Param("id") Long id);

	public SoftBlockAssociateDetails findByAssociateId(Long id);

}
