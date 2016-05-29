package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.classes.Publisher;
import com.library_automation.service.PublisherService;

@Controller
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	
	@RequestMapping("/admin/publishers/")
	public String showPublishers(ModelMap model){
		model.addAttribute("publishers", publisherService.getAllPublishers());
		
		return "manp";
	}
	
	
	@RequestMapping(value="/admin/deletepublisher/",method=RequestMethod.POST)
	public String deletePublisher(ModelMap model, HttpServletRequest req){
		
		publisherService.deletePublisherById(Integer.parseInt(req.getParameter("id")));
		model.addAttribute("publishers", publisherService.getAllPublishers());
		return "manp";
	}
	
	
	@RequestMapping(value="/addnewpublisher/",method=RequestMethod.POST)
	public String addNewPublisher(ModelMap model, Publisher publisher){
		
		publisherService.addNewPublisher(publisher);
		model.addAttribute("publishers", publisherService.getAllPublishers());
		return "manp";
	}

}
