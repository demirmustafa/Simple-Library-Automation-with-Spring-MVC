package com.library_automation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DenemeController {
	
	@RequestMapping("/deneme/")
	public String deneme(){
		
		return "denemesayfasi";
	}

}
