package com.library_automation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Publisher;
import com.library_automation.dao.PublishersDAO;


@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private PublishersDAO publishersDAO;

	@Override
	public List<Publisher> getAllPublishers() {
		// TODO Auto-generated method stub
		return publishersDAO.getAllPublishers();
	}

	@Override
	public void deletePublisherById(int id) {
		// TODO Auto-generated method stub
		
		publishersDAO.deletePublisher(id);

	}

	@Override
	public void addNewPublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		
		publishersDAO.addNewPublisher(publisher);

	}

}
