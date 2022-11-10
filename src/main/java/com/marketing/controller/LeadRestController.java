package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.Lead;
import com.marketing.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepository leadRepo;
	@GetMapping
	public List<Lead>getAllLead(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	@PutMapping
	public void updateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	//http://localhost:8080/api/leads/delete/4 
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable("id")long id) {
		
		leadRepo.deleteById(id);
	}
	@RequestMapping("/lead/{id}")
	public Lead getOneLead(@PathVariable("id")long id) {
		
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
	

}
