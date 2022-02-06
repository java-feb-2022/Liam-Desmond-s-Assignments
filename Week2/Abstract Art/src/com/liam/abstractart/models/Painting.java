package com.liam.abstractart.models;

public class Painting extends Art {
	


	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
		// TODO Auto-generated constructor stub
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
	public void viewArt() {
		System.out.println("Title: " + title + " - Author: " + author + " - Description: " +  description + " - Paint Type: " + paintType);
		
	}

}
