package com.cts.service;

import java.util.List;

import com.cts.entity.SoftBlockAssociateDetails;

public interface SoftBlockAssociateDetailsService {

	public List<SoftBlockAssociateDetails> getSoftBlockAssociateDetails();

	public SoftBlockAssociateDetails createSoftBlockAssociateDetails(SoftBlockAssociateDetails details);

	public boolean getSoIdAndStatus(Long id);

	public List<SoftBlockAssociateDetails> getAssociateBySoId(Long id);

}
