package com.cts.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Associates;
import com.cts.entity.SoftBlockAssociateDetails;
import com.cts.exception.AssociateNotFoundException;
import com.cts.exception.ServiceOrderNotFoundException;
import com.cts.respository.SoftBlockAssociateDetailsRepository;
import com.cts.service.SoftBlockAssociateDetailsService;

@Service
public class SoftBlockAssociateDetailsServiceImpl implements SoftBlockAssociateDetailsService {

	@Autowired
	private SoftBlockAssociateDetailsRepository repository;

	// This method gets all the soft Block Associates data

	@Override
	public List<SoftBlockAssociateDetails> getSoftBlockAssociateDetails() {
		List<SoftBlockAssociateDetails> allAssociates = repository.findAll();
		if (allAssociates.isEmpty()) {
			throw new AssociateNotFoundException("Associates Not Found");
		}

		return allAssociates;
	}

	// This method creates the soft Block Associate and it will update the data as
	// required

	@Override
	public SoftBlockAssociateDetails createSoftBlockAssociateDetails(SoftBlockAssociateDetails details) {
		List<SoftBlockAssociateDetails> allAssociates = repository.findAll();
		if (allAssociates.isEmpty()) {
			repository.save(details);
		}
		for (SoftBlockAssociateDetails abs : allAssociates) {
			if (details.getAssociateId().equals(abs.getAssociateId())) {
				abs.setAssociateName(details.getAssociateName());
				abs.setStatus(details.getStatus());
				abs.setFeedback(details.getFeedback());
				repository.save(abs);
			}

		}
		return repository.save(details);
	}

	// This method checks whether the soId is present in the First table or not and
	// it will check the status of the requirement also

	@Override
	public boolean getSoIdAndStatus(Long id) {
		Optional<Associates> associate = repository.findAssociateById(id);
		if (!associate.isPresent()) { // associate.getSoId().equals(null)
			throw new ServiceOrderNotFoundException("The Entered SoId doesn't exist");
		}

		boolean message = false;
		Associates ass = associate.get();
		if (ass.getSoId().equals(id) && ass.getSoStatus().equals("open")) {
			message = true;
		} else {
			message = false;
		}

		return message;
	}

	@Override
	public List<SoftBlockAssociateDetails> getAssociateBySoId(Long id) {
		List<SoftBlockAssociateDetails> findBySoId = repository.findBySoId(id);
		if (findBySoId.isEmpty()) {
			throw new AssociateNotFoundException("Associate Not Found");
		}
		return findBySoId;
	}

}
