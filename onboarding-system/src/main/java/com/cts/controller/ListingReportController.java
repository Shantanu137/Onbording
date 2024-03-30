package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.ListingReport;
import com.cts.service.Impl.ListingReportServiceImpl;

@RestController
@RequestMapping("/api/all")
@CrossOrigin(origins = "*")
public class ListingReportController {

	@Autowired
	private ListingReportServiceImpl service;

	@PostMapping("/list")
	public Page<ListingReport> getAll(Pageable pageable) {
		return service.listAll(pageable);

	}

	@PostMapping("/departmentName/{departmentName}")

	public Page<ListingReport> getReportByDepartment(Pageable pageable, @PathVariable String departmentName) {
		return service.findByDepartmentName(pageable, departmentName);
	}

}
