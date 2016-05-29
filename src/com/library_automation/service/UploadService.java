package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Upload;

public interface UploadService {
	
	public Upload getMyUploads(int id);
	
	public void saveUpload(Upload upload);
	
	public List<Upload> search(String title);

}
