package com.library_automation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_automation.classes.Book;
import com.library_automation.dao.SearchDAO;


@Service
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchDAO searchDAO;
	
	private List<Book> searchResult = new ArrayList<>();
	

	@Override
	public List<Book> searchByBookName(String title) {
		// TODO Auto-generated method stub
		return searchDAO.searchByBookName(title);
	}

	@Override
	public List<Book> searchByAuthor(String title) {
		// TODO Auto-generated method stub
		return searchDAO.searchByAuthorName(title);
	}

	@Override
	public List<Book> searchByPublisher(String title) {
		// TODO Auto-generated method stub
		return searchDAO.searchByPublisherName(title);
	}

	@Override
	public List<Book> searchByCategory(String title) {
		// TODO Auto-generated method stub
		return searchDAO.searchByCategoryName(title);
	}

	@Override
	public List<Book> getSearchResult(String title) {
		// TODO Auto-generated method stub
		
		searchResult = searchByBookName(title);
		
		if(!searchByAuthor(title).isEmpty()){
			for(int i = 0; i < this.searchByAuthor(title).size(); i++){
				Book book = searchByAuthor(title).get(i);
				
				
				if(!searchResult.contains(book)){
					searchResult.add(book);
				}
			}
		}
		
		if(!searchByPublisher(title).isEmpty()){
			for(int i = 0; i < this.searchByPublisher(title).size(); i++){
				Book book = searchByPublisher(title).get(i);
				
				
				if(!searchResult.contains(book)){
					searchResult.add(book);
				}
			}
		}
		
		if(!searchByCategory(title).isEmpty()){
			for(int i = 0; i < this.searchByCategory(title).size(); i++){
				Book book = searchByCategory(title).get(i);
				
				
				if(!searchResult.contains(book)){
					searchResult.add(book);
				}
			}
		
		}
		return searchResult;
	}

}
