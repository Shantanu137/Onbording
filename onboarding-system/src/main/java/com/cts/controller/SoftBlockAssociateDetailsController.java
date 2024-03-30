package com.cts.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.SoftBlockAssociateDetails;
import com.cts.service.Impl.SoftBlockAssociateDetailsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/softBlockApi")
public class SoftBlockAssociateDetailsController { 
	
	@Autowired
	private SoftBlockAssociateDetailsServiceImpl service;
	
	// This method gets all the soft Block Associates data
	
	@GetMapping("/associateDetails")
	public List<SoftBlockAssociateDetails> getSoftBlockAssociateDetails() {
		return service.getSoftBlockAssociateDetails();	
	}
	
	// This method creates the soft Block Associate and it will update the data as required
	
	@PostMapping("/add")
	public ResponseEntity<SoftBlockAssociateDetails> createSoftBlockAssociateDetails(@RequestBody @Valid SoftBlockAssociateDetails details){
		System.out.println(details);
		SoftBlockAssociateDetails savedAssociate = service.createSoftBlockAssociateDetails(details);
		return new ResponseEntity<>(savedAssociate, HttpStatus.CREATED);
	}
	
	// This method checks whether the soId is present in the First table or not and it will check the status of the requirement also
	
	@PostMapping("/id")
	public boolean findSoIdAndStatus(@RequestBody SoftBlockAssociateDetails data) {
		System.out.println(data);
		boolean soStatus = service.getSoIdAndStatus(data.getSoId());
		return soStatus;
	}
	
//	@PutMapping("/filter/{associateId}")
//	public SoftBlockAssociateDetails filterSoftBlock(@PathVariable Long associateId, @RequestBody SoftBlockAssociateDetails data) {
//		return service.filterSoftBlock(associateId, data);
//	}
	
	// This method gets the soft Block associate based on soId
	
	@PostMapping("/soId")
	public List<SoftBlockAssociateDetails> getAssociatesBySoId(@RequestBody SoftBlockAssociateDetails data){
		return service.getAssociateBySoId(data.getSoId());
	}
	
}
