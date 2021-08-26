package com.bl.birdsanctuary;

public class Penguin extends Bird implements Swimmable {
	Penguin(){
		color =Color.BLACK_WHITE;
		name = "Penguin";
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
