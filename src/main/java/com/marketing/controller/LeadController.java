package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.service.LeadService;
import com.marketing.util.EmailService;
import com.marketing.util.EmailServiceImpl;

@Controller
public class LeadController {
	@Autowired
	private EmailService emailService;
	
	 @Autowired
	private LeadService leadService;
	
	@RequestMappingRam("/viewLeadPage")
	
	public String leadCreatePage() {
		return "create_lead";
		
	}
	@RequestMapping(value="/savelead", method=RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead")Lead l ,ModelMap model) {
		leadService.saveOneLead(l);
		
		emailService.sendEmail(l.getEmail(),"Test", "Test Email");
		
		model.addAttribute("msg", "lead is saved!!");
		return "create_lead";
		
	}
//	
//	@RequestMapping(value="savelead", method=RequestMethod.POST)
//	public String savelead(@RequestParam("name") String fname,@RequestParam("lastName") String lName,@RequestParam("email") String email,@RequestParam("mobile") String mobile) {
//		Lead lead=new Lead();
//		lead.setFirstName(fname);
//		lead.setLastName(lName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveOneLead(lead);
//		
//		return "create_lead";
//		
//	
//	}
//	
//		@RequestMapping(value="savelead", method=RequestMethod.POST)
//	public String savelead(LeadData data) {
//			Lead l= new Lead();
//			l.setFirstName(data.getFirstName());
//			l.setLastName(data.getLastName());
//			l.setEmail(data.getEmail());
//			l.setMobile(data.getMobile());
//			
//			leadService.saveOneLead(l);
//	return "create_lead";
//		
//	}
	@RequestMapping("/listall")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
	}
	@RequestMapping("/deleteLead")
	public String deleteLead(@RequestParam("id")long id,ModelMap model) {
		
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		
		return "list_leads";
		
		
	}
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.getById(id);
		model.addAttribute("lead",lead);
		return"update_lead";
		
	}
	@RequestMapping(value="updateOnelead", method=RequestMethod.POST)
	public String updateOneLead(@ModelAttribute("lead")Lead l ,ModelMap model) {
		leadService.saveOneLead(l);
		List<Lead> leads = leadService.listAllLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		
		return "list_leads";

		
	}

}
