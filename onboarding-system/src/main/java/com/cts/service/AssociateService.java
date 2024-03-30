package com.cts.service;

import java.util.List;

import com.cts.entity.Associates;

public interface AssociateService {
	
	public Associates CreateNewAssociate(Associates associate);
	
	public List<Associates> findAssociatesById(Long id);
	
	public List<Associates> findAssociateByPrimarySkill(String skill);
	
	//public List<Associates> findAssociateByStatus(String status);
	
	public List<Associates> listAll();

	List<Associates> findAssociateByStatus(Associates status);

}
