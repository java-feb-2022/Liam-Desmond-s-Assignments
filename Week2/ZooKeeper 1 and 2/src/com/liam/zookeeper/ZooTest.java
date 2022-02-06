package com.liam.zookeeper;

public class ZooTest {

	public static void main(String[] args) {

		Gorrilla zoe = new Gorrilla();
		
		zoe.throwThings();
		zoe.throwThings();
		zoe.throwThings();
		
		zoe.eatBananas();
		zoe.eatBananas();
		
		zoe.climb();
		
		int a = zoe.displayEnergy();
		System.out.println(a);
		
		Bat crazy = new Bat();
		
		crazy.attackTown();
		crazy.attackTown();
		crazy.attackTown();
		
		crazy.eatHumans();
		crazy.eatHumans();
		
		crazy.fly();
		crazy.fly();
		
		int b = crazy.getEnergy();
		System.out.println(b);
	}

}
