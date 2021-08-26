package com.bl.birdsanctuary;

public class Duck extends Bird implements Flyable,Swimmable{
	Duck(){
		
		color = Color.BROWN;
		name = "Duck";
	}

	@Override
	public void fly() {
		System.out.println(name+" can fly");
	}

	@Override
	public void swim() {
		System.out.println(name+" can swim");
	}

	@Override
	public void eat() {
		System.out.println(name+" can eat");
	}
}
