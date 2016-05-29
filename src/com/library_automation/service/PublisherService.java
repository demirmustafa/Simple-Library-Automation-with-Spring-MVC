package com.library_automation.service;

import java.util.List;

import com.library_automation.classes.Publisher;

public interface PublisherService {
	
	public List<Publisher> getAllPublishers();
	
	public void deletePublisherById(int id);
	
	public void addNewPublisher(Publisher publisher);
	

}
