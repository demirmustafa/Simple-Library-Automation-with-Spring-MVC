package com.library_automation.classes;

public class Search {

	private String title;

	public Search() {
		super();
	}

	public Search(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Search [title=" + title + "]";
	}

}
