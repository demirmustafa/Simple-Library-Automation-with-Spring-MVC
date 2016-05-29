package com.library_automation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploader
 */
@WebServlet("/fileuploader/")
public class FileUploader extends HttpServlet {
	
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 10000*1024;
	private int maxMemSize = 1000*1024;
	private  File file;
	
	
	public void init(){
		filePath = getServletContext().getInitParameter("file-upload-path");
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println(String.valueOf(session.getAttribute("username")));
		
		
		OutputStream out = response.getOutputStream();
		
		//out.write(new File("/home/mustafa/Java/file/spring.pdf"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		isMultipart = ServletFileUpload.isMultipartContent(request);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File(filePath));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		
		try{
			List fileItems = upload.parseRequest(request);
			Iterator i = fileItems.iterator();
			
			System.out.println("servlet upload");
			
			while(i.hasNext()){
				FileItem fi = (FileItem)i.next();
				
				if(!fi.isFormField()){
					
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					
					//write file
					
					if(fileName.lastIndexOf("\\")>=0){
						file = new File(filePath+fileName.substring(fileName.lastIndexOf("\\")));
						
					}
					else{
						file = new File(filePath+fileName.substring(fileName.lastIndexOf("\\")+1));
					}
					fi.write(file);
					System.out.println("uploaded filename: "+fileName);
					session.setAttribute("fileName", fileName);
					session.setAttribute("tags", request.getParameter("tags"));
					System.out.println(request.getParameter("tags"));
				
				}
				
				
				}
		} 
		catch(Exception e){
			System.out.println(e);
		}
		
		request.getRequestDispatcher("/fileUploaded/").forward(request, response);
		
	}

}
