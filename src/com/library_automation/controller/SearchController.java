package com.library_automation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.library_automation.service.SearchService;
import com.library_automation.service.UploadService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private UploadService uploadService;
	
	
	@RequestMapping(value="/search/",method=RequestMethod.POST)
	public String showSearchResults(ModelMap model, HttpServletRequest req){
		
		if(!req.getParameter("title").toString().equals("")){
			
			model.addAttribute("books", searchService.getSearchResult(req.getParameter("title")));
			
			/*search result for thesis*/
			model.addAttribute("thesis", uploadService.search(req.getParameter("title")));
		}
		
		
		
		
		
		return "searchresult";
	}
	
	@RequestMapping(value="/search/",method=RequestMethod.GET)
	public String search(){
		
		return "redirect:/";
	}

}
