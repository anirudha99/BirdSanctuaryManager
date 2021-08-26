package com.bl.birdsanctuary;

public class Parrot extends Bird implements Flyable{
	Parrot(){
		color = Color.GREEN;
		name = "Parrot";
	}

	@Override
	public void fly() {
		System.out.println(name+" can fly");
	}

	@Override
	public void eat() {
		System.out.println(name+" can eat");
	}
}
