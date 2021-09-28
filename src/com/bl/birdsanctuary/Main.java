package com.bl.birdsanctuary;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Main Mainapp = new Main();
		Mainapp.showUserMenu();

		/*	Duck duck = new Duck();
		duck.id = "D001";
		Ostrich ostrich	= new Ostrich();
		ostrich.id = "O002";
		Parrot parrot = new Parrot();
		parrot.id = "P003";
		Penguin penguin = new Penguin();
		penguin.id = "PN001";
		Penguin penguin2 = new Penguin();
		penguin2.id = "PN001";

		BirdSanctuaryRepository birdsanctuaryrepository = new BirdSanctuaryRepository();

		birdsanctuaryrepository.add(duck);
		birdsanctuaryrepository.add(ostrich);
		birdsanctuaryrepository.add(parrot);
		birdsanctuaryrepository.add(penguin);
		birdsanctuaryrepository.add(penguin);
		birdsanctuaryrepository.add(penguin2);
		birdsanctuaryrepository.print();

		birdsanctuaryrepository.remove(duck);
		birdsanctuaryrepository.remove(ostrich);

		System.out.println("After deletion: ");

		 */
		System.out.println("Goodbye!");
	}

	void showUserMenu() {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		final int exit_value = 8;

		while(option != exit_value) {
			System.out.println("Enter your options");
			System.out.println("\n1. Add a bird\n2. Remove a bird\n3. Print the bird\n4. Print Swimmable\n5. Print flyable\n"
					+ "6. Print Eatable\n7. Edit Bird\n"
					+exit_value+". Exit");
			option = scanner.nextInt();

			ViewLayer viewLayer = new ViewLayer();

			switch(option) {
			case 1:
				addTemporaryBirds();
				Bird bird = new Bird();
				System.out.println("Enter the id");
				scanner = new Scanner(System.in);
				String id = scanner.nextLine();
				bird.id = id;
				System.out.println("Enter the name");
				scanner = new Scanner(System.in);
				String name = scanner.nextLine();
				bird.name = name;
				System.out.println("Enter the color");
				int count = 1;
				for(Bird.Color color1: EnumSet.allOf(Bird.Color.class)) {
					System.out.println(""+count+"."+color1);
					count++;
				}

				int colorChoice = scanner.nextInt();
				int count1 = 1;
				for(Bird.Color color1: EnumSet.allOf(Bird.Color.class)) {
					if(colorChoice == count1) {
						bird.color = color1;
						break;
					}
					count1++;
				}
				System.out.println("Can the bird fly?");
				Boolean canFly = scanner.nextBoolean();
				bird.canFly = canFly;
				System.out.println("Can the bird swim?");
				Boolean canSwim = scanner.nextBoolean();
				bird.canSwim = canSwim;
				BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
				birdsanctuaryrepository.add(bird);

				//					Duck duck = new Duck();
				//					duck.id = "D001";
				//					Ostrich ostrich	= new Ostrich();
				//					ostrich.id = "O002";
				//					Parrot parrot = new Parrot();
				//					parrot.id = "P003";
				//					Penguin penguin = new Penguin();
				//					penguin.id = "PN001";
				//					Penguin penguin2 = new Penguin();
				//					penguin2.id = "PN001";
				//					
				//					BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
				//					birdsanctuaryrepository.add(duck);
				//					birdsanctuaryrepository.add(ostrich);
				//					birdsanctuaryrepository.add(parrot);
				//					birdsanctuaryrepository.add(penguin);
				//					birdsanctuaryrepository.add(penguin);
				//					birdsanctuaryrepository.add(penguin2);
				break;
			case 2: 
				System.out.println("Enter the bird name to remove\n");
				String birdname = scanner.nextLine();
				birdname = scanner.next();
				birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
				Bird removeBird = birdsanctuaryrepository.getBird(birdname);
				
				try{
					if(removeBird == null)
						throw new BirdNotFoundException("Bird not found");
					birdsanctuaryrepository.remove(removeBird);
					System.out.println(birdname + " removed");
				}
				catch(BirdNotFoundException e){
					System.out.println("Exception occured");
				}
				break;
			case 3: 
				viewLayer.print();
				break;
			case 4:
				viewLayer.printSwimmable();
				break;
			case 5 : 
				viewLayer.printFlyable();
				break;
			case 6: 
				viewLayer.printEatable();
				break;
			case 7:
				editBird();
				break;

			}
		}
	}
	//Delete this method in production
	private void addTemporaryBirds() {
		Bird duck = new Bird();
		duck.id = "d001";
		duck.name = "Duck";
		duck.color = Bird.Color.BROWN;
		duck.canFly = false;
		duck.canSwim = true;
		BirdSanctuaryRepository birdsanctuaryrepository = BirdSanctuaryRepository.getInstance();
		birdsanctuaryrepository.add(duck);
		Bird penguin = new Bird();
		penguin.id = "PN001";
		penguin.name = "Penguin";
		penguin.color = Bird.Color.BLACK;
		penguin.canFly = false;
		penguin.canSwim = true;
		birdsanctuaryrepository.add(penguin);
		Bird parrot = new Bird();
		parrot.id = "P001";
		parrot.name = "Parrot";
		parrot.color = Bird.Color.GREEN;
		parrot.canFly = true;
		parrot.canSwim = true;
		birdsanctuaryrepository.add(parrot);
		Bird ostrich = new Bird();
		ostrich.id = "O001";
		ostrich.name = "Ostrich";
		ostrich.color = Bird.Color.GREY;
		ostrich.canFly = false;
		ostrich.canSwim = false;
		birdsanctuaryrepository.add(ostrich);

	}

	private void editBird() {
		System.out.println("Enter the bird name to edit\n");
		Scanner scanner = new Scanner(System.in);
		String birdname = scanner .nextLine();

		Bird editBird = BirdSanctuaryRepository.getInstance().getBird(birdname);

		int choice = 0;
		while(choice!=4) {
			System.out.println("1. Edit Bird name\n2. Edit id\n3. Edit color\n4. Exit");
			choice = scanner.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter the new name: ");
				String bname = scanner.next();
				editBird.name = bname;
				break;
			case 2:
				System.out.println("Enter the new id: ");
				String id = scanner.next();
				editBird.id = id;
				break;
			case 3:
				System.out.println("Enter the new color: ");
				scanner.nextLine();
				System.out.println("Choose the new color");

				int count = 1;
				for(Bird.Color color1: EnumSet.allOf(Bird.Color.class)) {
					System.out.println(""+count+"."+color1);
					count++;
				}

				int colorChoice = scanner.nextInt();
				int count1 = 1;
				for(Bird.Color color1: EnumSet.allOf(Bird.Color.class)) {
					if(colorChoice == count1) {
						editBird.color = color1;
						break;
					}
					count1++;
				}
				break;
			case 4: 
				return;
			}
		}
	}
}
