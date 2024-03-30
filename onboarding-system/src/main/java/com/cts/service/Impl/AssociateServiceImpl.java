package com.cts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Associates;
import com.cts.exception.AssociateNotFoundException;
import com.cts.respository.AssociateRepository;
import com.cts.service.AssociateService;

import org.springframework.data.domain.Sort;

@Service
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	private AssociateRepository assRepo;

	@Override
	// This method creates the Associates
	public Associates CreateNewAssociate(Associates associate) {
		return assRepo.save(associate);

	}

	@Override
	// This method gets all Associates data by using soId
	public List<Associates> findAssociatesById(Long id) {
		List<Associates> associateById = assRepo.findBySoId(id);
		if (associateById.isEmpty()) {
			throw new AssociateNotFoundException("Associate Not Found");
		}
		return associateById;
	}

	@Override
	// This method gets all Associates data by using skill
	public List<Associates> findAssociateByPrimarySkill(String skill) {
		List<Associates> associatesByPrimarySkills = assRepo.findByPrimarySkills(skill);
		if (associatesByPrimarySkills.isEmpty()) {
			throw new AssociateNotFoundException("Associates Not Found");
		}
		return associatesByPrimarySkills;
	}

	@Override

	// This method gets all Associates data by using Status
	public List<Associates> findAssociateByStatus(Associates status) {

		List<Associates> findByStatus = assRepo.findByStatus(status);
		if (findByStatus.isEmpty()) {
			throw new AssociateNotFoundException("Associate is Not present");
		}
		return findByStatus;
	}

	@Override
	// This method gets all Associates data by using sorted soId
	public List<Associates> listAll() {

		return assRepo.findAll(Sort.by("soId").ascending());
	}

}
