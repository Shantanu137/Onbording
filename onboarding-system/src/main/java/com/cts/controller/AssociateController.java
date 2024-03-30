package com.cts.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Associates;
import com.cts.excleexporter.AssociateExcelExporter;
import com.cts.service.Impl.AssociateServiceImpl;

@RestController
@RequestMapping("/api/associates")
//@CrossOrigin(origins ="http://localhost:3000")
public class AssociateController {

	@Autowired
	private AssociateServiceImpl ascService;
	Logger logeer = LoggerFactory.getLogger(AssociateController.class);

	@PostMapping
	// This method creates the Associates
	public ResponseEntity<Associates> CreateAssociateDetails(@RequestBody @Valid Associates associate) {
		Associates asc = ascService.CreateNewAssociate(associate);
		logeer.info("Entering Associates Details.");
		return new ResponseEntity<>(asc, HttpStatus.CREATED);
	}

	@PostMapping("/id")
	// This method gets all Associates data by using soId
	public List<Associates> getAssociatesBySoId(@RequestBody Associates associate) {
		logeer.info("Geting all Associates Details by using Soid.");
		return ascService.findAssociatesById(associate.getSoId());
	}

	@PostMapping("/skill")
	// This method gets all Associates data by using skill
	public List<Associates> getAssociatesByPrimarySkill(@RequestBody Associates associate) {
		System.out.println(associate.getPrimarySkills());
		logeer.info("Geting all Associates Details by using Skill.");
		return ascService.findAssociateByPrimarySkill(associate.getPrimarySkills());
	}

	@PostMapping("/status")
	// This method gets all Associates data by using status
	public List<Associates> getAssociatesByStatus(@RequestBody Associates status) {
		logeer.info("Geting all Associates Details by using status");

		return ascService.findAssociateByStatus(status);
	}

	@GetMapping("/export/excel")
	// This method gets Associates data in excel

	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

		String currentDateTime = dateFormatter.format(new java.util.Date(0));

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=associates_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Associates> listAssociates = ascService.listAll();

		logeer.info("Exeporting data in Excel. ");
		AssociateExcelExporter excelExporter = new AssociateExcelExporter(listAssociates);

		excelExporter.export(response);
	}
}
