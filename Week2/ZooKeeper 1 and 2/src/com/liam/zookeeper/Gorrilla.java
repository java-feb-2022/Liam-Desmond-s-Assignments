package com.liam.zookeeper;

public class Gorrilla extends Mammal {
	

	public void throwThings() {
		System.out.println("Gorrila has thrown something");
		this.energy -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorrila is full");
		this.energy += 10;
	}
	
	public void climb() {
		System.out.println("Gorrila has climbed a tree");
		this.energy -= 10;
	}
}
