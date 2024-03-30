package com.cts.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.entity.ListingReport;

public interface ListingReportRepository extends JpaRepository<ListingReport, Long> {

	public Page<ListingReport> findByDepartmentName(Pageable pageable, @Param("departmentName") String departmentName);

	public Page<ListingReport> findAll(Pageable pageable);

}
