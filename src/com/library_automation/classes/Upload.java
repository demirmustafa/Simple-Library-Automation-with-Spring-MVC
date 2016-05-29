package com.library_automation.classes;

public class Upload {

	private int id;
	private String name;
	private User user;
	private String tags;

	public Upload() {
		super();
	}

	public Upload(String name, String tags) {
		super();
		this.name = name;
		this.tags = tags;
	}
	
	

	public Upload(int id, String name, String tags) {
		super();
		this.id = id;
		this.name = name;
		this.tags = tags;
	}

	public Upload(String name, User user, String tags) {
		super();
		this.name = name;
		this.user = user;
		this.tags = tags;
	}

	public Upload(int id, String name, User user, String tags) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Upload [id=" + id + ", name=" + name + ", user=" + user + ", tags=" + tags + "]";
	}

}
