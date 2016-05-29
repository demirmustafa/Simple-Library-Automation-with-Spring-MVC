package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Upload;
import com.library_automation.dao.UploadsDAO;


@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private UploadsDAO uploadsDAO;

	@Override
	public Upload getMyUploads(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUpload(Upload upload) {
		// TODO Auto-generated method stub
		
		uploadsDAO.saveUpload(upload);
		
	}

	@Override
	public List<Upload> search(String title) {
		// TODO Auto-generated method stub
		return uploadsDAO.search(title);
	}

}
