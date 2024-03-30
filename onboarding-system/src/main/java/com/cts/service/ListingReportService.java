package com.cts.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cts.entity.ListingReport;

public interface ListingReportService {

	public Page<ListingReport> findByDepartmentName(Pageable pageable, String departmentName);

	Page<ListingReport> listAll(Pageable pageable);

	public List<ListingReport> findAll();

}
