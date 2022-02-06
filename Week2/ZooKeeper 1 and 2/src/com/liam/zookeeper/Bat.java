package com.liam.zookeeper;

public class Bat {

	private int energy = 300;

	public Bat() {
		super();
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		System.out.println(this.getEnergy());
		this.energy = energy;
	}
	
	
	
	public void fly() {
		System.out.println("Shreeeeek!!");
		this.energy -= 50;
	}
	
	public void eatHumans() {
		System.out.println("The bat just ate a bunch of humans!!");
		this.energy += 25;
	}
	
	public void attackTown() {
		System.out.println("***Town Burning***");
		this.energy -= 100;
	}
	
	
}
