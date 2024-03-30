package com.cts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cts.entity.ListingReport;
import com.cts.respository.ListingReportRepository;
import com.cts.service.ListingReportService;

@Service
public class ListingReportServiceImpl implements ListingReportService {
	@Autowired
	private ListingReportRepository repo;

	@Override
	public Page<ListingReport> listAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.findAll(pageable);
	}

	@Override
	public Page<ListingReport> findByDepartmentName(Pageable pageable, String departmentName) {
		Page<ListingReport> listbydepartment = repo.findByDepartmentName(pageable, departmentName);

		return listbydepartment;
	}

	@Override
	public List<ListingReport> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
