package com.liam.abstractart;

import java.util.ArrayList;

import com.liam.abstractart.models.Painting;
import com.liam.abstractart.models.Sculpture;

public class AbstractTester {
	
	ArrayList<Painting> paintings = new ArrayList<Painting> ();
	ArrayList<Sculpture> sculptures = new ArrayList<Sculpture> ();

	public static void main(String[] args) {
		
		
		Painting painting1 = new Painting("Title One", "Some Dude", "Description One", "Type One");
		Painting painting2 = new Painting("Title Two", "Some Guy", "Description Two", "Type Two");
		Painting painting3 = new Painting("Title Three", "Some Other Guy", "Description Three", "Type Three");
		
		Sculpture sculpture1 = new Sculpture("Title Four", "Random Person", "Description Four", "Material One");
		Sculpture sculpture2 = new Sculpture("Title Five", "Random Dude", "Description Five", "Material Two");
		
		painting1.viewArt();
		painting2.viewArt();
		painting3.viewArt();
		
		sculpture1.viewArt();
		sculpture2.viewArt();


	}

}
