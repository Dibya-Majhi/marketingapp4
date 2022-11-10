package com.marketing.service;

import java.util.List;

import com.marketing.entities.Lead;

public interface LeadService {
	public void saveOneLead(Lead l) ;
	public List<Lead> listAllLeads();
	public void deleteOneLead(Long id);
	public Lead getById(Long id);
		
	}


