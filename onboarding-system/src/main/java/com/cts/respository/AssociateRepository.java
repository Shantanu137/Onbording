package com.cts.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.entity.Associates;

public interface AssociateRepository extends JpaRepository<Associates, Long> {

	public List<Associates> findBySoId(Long id);

	public List<Associates> findByPrimarySkills(String skills);

	@Query("select a from Associates a inner join SoftBlockAssociateDetails s on a.soId = s.soId where status=:status")
	public List<Associates> findByStatus(@Param("status") Associates status);

}
