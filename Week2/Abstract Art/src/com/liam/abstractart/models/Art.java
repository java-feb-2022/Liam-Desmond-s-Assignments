package com.liam.abstractart.models;



public abstract class Art {
	
//	ArrayList<AbstractTester> museum = new ArrayList<AbstractTester> ();
	
	protected String title;
	
	protected String author;
	
	protected String description;
	
	
	
	public Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}



	public void viewArt() {
		
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
