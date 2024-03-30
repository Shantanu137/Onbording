package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Screen;
import com.cts.exception.AssociateAlreadyExistException;
import com.cts.exception.ResourceNotFoundException;
import com.cts.respository.ScreenRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/nbl")
public class ScreenController {

	@Autowired
	private ScreenRepository screenRepository;

	@GetMapping("/associate")
	public List<Screen> getAllAssociate() {
		return screenRepository.findAll();
	}

	/*
	 * @PostMapping("/add") public Screen createScreen(@RequestBody Screen screen) {
	 * return screenRepository.save(screen); }
	 */
	// exception

	@PostMapping("/add")
	public Screen addAssociate(@RequestBody Screen screen) {
		Screen existingAssociate = screenRepository.findById(screen.getAssociate_id()).orElse(null);
		if (existingAssociate == null) {
			screenRepository.save(screen);
			return screenRepository.save(screen);
		} else
			throw new AssociateAlreadyExistException("Associate already exists!!");
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Screen> updateScreen(@PathVariable int id, @RequestBody Screen screenDetails) {
		Screen screen = screenRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("screen not exist  : " + id));
		screen.setAssociate_id(screen.getAssociate_id());
		screen.setAssociate_name(screen.getAssociate_name());
		screen.setProject_description(screenDetails.getProject_description());
		screen.setProject_manager_name(screenDetails.getProject_manager_name());
		screen.setGrade(screenDetails.getGrade());
		screen.setDepartment(screenDetails.getDepartment());
		screen.setSkill_category(screenDetails.getSkill_category());
		screen.setPoc(screenDetails.getPoc());
		screen.setLocation(screenDetails.getLocation());
		screen.setComment(screenDetails.getComment());
		screen.setEsa_start_date(screenDetails.getEsa_start_date());
		screen.setBilling_start_date(screenDetails.getBilling_start_date());
		screen.setBillable(screenDetails.getBillable());

		Screen updateScreen = screenRepository.save(screen);
		return ResponseEntity.ok(updateScreen);
	}
}
