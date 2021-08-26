package com.bl.birdsanctuary;

public class ViewLayer {


	public void print() {
		BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
		for( Bird birdItems: birdsanctuaryrepository.getAllBirds())
		{
			System.out.println(birdItems); 
		}
	}
	
	public void printFlyable() {
		BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
		for( Bird birdItems: birdsanctuaryrepository.getAllBirds())
		{
			if(birdItems.canFly) {
				birdItems.fly();
			}
			 
		}
	}
	
	public void printSwimmable() {
		BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
		for( Bird birdItems: birdsanctuaryrepository.getAllBirds())
		{
			
			if(birdItems.canSwim) {
				birdItems.swim();
			}
		}
	}
	
	public void printEatable() {
		BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
		for( Bird birdItems: birdsanctuaryrepository.getAllBirds())
		{
			birdItems.eat(); 
		}
	}

}
