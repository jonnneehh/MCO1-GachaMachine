import java.util.Scanner;

public class UserInterface {
	private Scanner scanner = new Scanner(System.in);
	
	private int userChoice;
	
	public UserInterface() {
		this.setUserChoice(0);
	}
	
	public int getUserChoice() {
		return this.userChoice;
	}
	
	public void setUserChoice(int userChoice) {
		this.userChoice = userChoice;
	}
	
	public void startProgram() {
		System.out.println("Starting Program...");
	}
	
	public int showMainMenu() {
		System.out.println("Main Menu: ");
		System.out.println("1: Show Characters");
		System.out.println("2: Show Weapons");
		System.out.println("3: Show Maps");
		System.out.println("4: Show Gacha Machine");
		System.out.println("5: Exit Program");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showAllCharacters(/*Character characterList[]*/) {
		System.out.println("Character Menu: ");
		System.out.println("1: Level Up Characters");
		System.out.println("2: Merge Two Character");
		System.out.println("3: Equip Weapon to Character");
		System.out.println("4: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showAllWeapons(/*Weapon weaponList[]*/) {
		System.out.println("Weapon Menu: ");
		System.out.println("1: Level Up Weapons");
		System.out.println("2: Merge Two Weapons");
		System.out.println("3: Equip Weapon to Character");
		System.out.println("4: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showMaps(/*Map mapList[]*/) {
		System.out.println("Map Menu: ");
		System.out.println("1: Start Adventure");
		System.out.println("2: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showGachaMachine(){
		System.out.println("Gacha Machine: ");
		System.out.println("1: Pull One Character (300)");
		System.out.println("2: Pull Ten Characters (2700)");
		System.out.println("3: Pull One Weapon (300)");
		System.out.println("4: Pull Ten Weapons (2700)");
		System.out.println("5: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public void exitProgram() {
		System.out.println("Exiting Program...");
		/* Some code to put here when the time comes.
		 * */
	}
}
