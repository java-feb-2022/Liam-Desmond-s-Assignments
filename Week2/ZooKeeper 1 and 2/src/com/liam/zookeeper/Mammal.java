package com.liam.zookeeper;

public class Mammal {

	int energy = 100;
	
	
	
	public Mammal() {

	}



	public Mammal(int energy) {
		this.energy = energy;
	}



	public int displayEnergy() {
		System.out.println("Gorrila has " + this.energy + " energy");
		return this.energy;
	}



	public int getEnergy() {
		return energy;
	}



	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
}
