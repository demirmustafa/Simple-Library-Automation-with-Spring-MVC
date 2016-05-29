package com.library_automation.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.library_automation.classes.*;
import org.apache.tomcat.util.net.SecureNio2Channel.ApplicationBufferHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library_automation.classes.Upload;
import com.library_automation.dao.UsersDAO;
import com.library_automation.service.UploadService;

@Controller
public class UploadController {
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("/upload/")
	public String showFileUploadPage(){
		
		
		return "upload";
	}
	
	@RequestMapping("/showpdf/")
	public String showPDF(HttpServletRequest request, ModelMap model){
		
		String pdfName = String.valueOf(request.getParameter("thesisName"));
		model.addAttribute("pdfName", pdfName);
		
		return "showpdf";
	}
	
	@RequestMapping("/fileUploaded/")
	public String fileUploaded(HttpServletRequest req){
		
		HttpSession session  = req.getSession();
		String fileName = String.valueOf(session.getAttribute("fileName"));
		String authUsersUserName = String.valueOf(session.getAttribute("username"));
		System.out.println(session.getAttribute("username"));
		
		//int userId = usersDAO.getAuthenticatedUser(authUsersUserName).getId();
		String tags = req.getParameter("tags");
		
		Upload upload = new Upload();
		upload.setUser(usersDAO.getAuthenticatedUser(authUsersUserName));
		upload.setName(fileName);
		upload.setTags(tags);
		
		uploadService.saveUpload(upload);
		System.out.println("file uploaded");
		System.out.println(tags);
		
		
		return "redirect:/";
	}

}
