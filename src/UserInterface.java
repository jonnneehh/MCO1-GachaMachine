import java.util.ArrayList;
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
	
	public void showMenuTitle(int userChoice){
		System.out.println("");
		if(userChoice == 1) System.out.println("Character Menu: ");
		else if(userChoice == 2) System.out.println("Weapon Menu: ");
		else if(userChoice == 3) System.out.println("Map Menu: ");
		else if(userChoice == 4) System.out.println("Gacha Machine: ");
		else System.out.println("Main Menu: "); 
	}
	
	public int showMainMenu() {
		System.out.println("1: Show Characters");
		System.out.println("2: Show Weapons");
		System.out.println("3: Show Maps");
		System.out.println("4: Show Gacha Machine");
		System.out.println("5: Exit Program");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showCharacterMenu(/*Character characterList[]*/) {
		System.out.println("1: Level Up Characters");
		System.out.println("2: Merge Characters");
		System.out.println("3: Equip Weapon to Character");
		System.out.println("4: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showWeaponMenu(/*Weapon weaponList[]*/) {
		System.out.println("1: Level Up Weapons");
		System.out.println("2: Merge Two Weapons");
		System.out.println("3: Equip Weapon to Character");
		System.out.println("4: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showMaps(/*Map mapList[]*/) {
		System.out.println("1: Start Adventure");
		System.out.println("2: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int showGachaMachine(){
		System.out.println("1: Pull One Character (300)");
		System.out.println("2: Pull Ten Characters (2700)");
		System.out.println("3: Pull One Weapon (300)");
		System.out.println("4: Pull Ten Weapons (2700)");
		System.out.println("5: Back to Main Menu");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	public int howManyCharacter(){
		System.out.println("1: One Character");
		System.out.println("2: Two Characters");
		System.out.print("Enter your choice here: ");
		this.userChoice = scanner.nextInt();
		
		return this.userChoice;
	}
	
	private void headOfCharacterInfo() {
		System.out.println(String.format("%-7s", "Index") + String.format("%-30s", "Name") + String.format("%-7s", "Rarity") + 
						   String.format("%-10s", "Element") + String.format("%-7s", "Level") + 
						   String.format("%-15s", "Weapon Equipped"));
	}
	
	private void displayCharacterInfo(Character c, int characterIndex) {
		String WeaponEquipped;
		
		if (c.getWeapon() == null) WeaponEquipped = "None";
		else WeaponEquipped = c.getWeapon().getName();
		
		System.out.println(String.format("%-7s", characterIndex) + String.format("%-30s",c.getName()) + String.format("%-7s", String.valueOf(c.getRarity())) + 
						   String.format("%-10s", c.getElement().getName()) + String.format("%-7s", String.valueOf(c.getLevel())) + 
						   String.format("%-15s", WeaponEquipped));
	}
	
	//THIS IS A TEMORARY METHOD FOR TESTING
	private void displayCharacterInfo(Character c, int characterIndex, boolean showUniqueID) { 
		String WeaponEquipped;
		
		if (c.getWeapon() == null) WeaponEquipped = "None";
		else WeaponEquipped = c.getWeapon().getName();
		
		System.out.println(String.format("%-7s", characterIndex) + String.format("%-30s",c.getName()) + String.format("%-7s", String.valueOf(c.getRarity())) + 
						   String.format("%-10s", c.getElement().getName()) + String.format("%-7s", String.valueOf(c.getLevel())) + 
						   String.format("%-15s", WeaponEquipped) + String.format("%-20s", c.getUniqueID()));
	}
	
	private void headOfWeaponInfo() {
		System.out.println(String.format("%-7s", "Index") + String.format("%-30s", "Name") + String.format("%-7s", "Rarity") + 
						   String.format("%-10s", "Power") + String.format("%-7s", "Level") + String.format("%-15s", "Character Owner"));
	}
	
	private void displayWeaponInfo(Weapon w, int weaponIndex) {
		String CharacterOwner;
		
		if (w.getCharacterOwner() == null) CharacterOwner = "None";
		else CharacterOwner = w.getCharacterOwner().getName();
		
		System.out.println(String.format("%-7s", weaponIndex) + String.format("%-30s",w.getName()) + String.format("%-7s", String.valueOf(w.getRarity())) + 
				   		   String.format("%-10s", String.valueOf(w.getPower())) + String.format("%-7s", String.valueOf(w.getLevel())) +
				   		   String.format("%-15s", CharacterOwner));
	}
	
	private void headOfMapInfo() {
		System.out.println(String.format("%-7s", "Index") + String.format("%-40s", "Name"));
	}
	
	private void displayMapInfo(Map m, int mapIndex) {
		System.out.println(String.format("%-7s", mapIndex) + String.format("%-40s", m.getName()));
	}
	
	public void displayAllWeapons(ArrayList<Weapon> weaponList) {
		this.headOfWeaponInfo();
		for(int i = 0; i < weaponList.size() ; i++)
			this.displayWeaponInfo(weaponList.get(i), i);
	}
	
	public void displayAllCharacters(ArrayList<Character> characterList) {
		this.headOfCharacterInfo();
		for(int i = 0; i < characterList.size() ; i++)
			this.displayCharacterInfo(characterList.get(i), i, true);
	}
	
	public void displayAllMaps(ArrayList<Map> mapList) {
		this.headOfMapInfo();
		for(int i = 0; i < mapList.size() ; i++)
			this.displayMapInfo(mapList.get(i), i);
	}
	
	public int selectMap() {
		int indexChosen;
		
		System.out.print("Please select a map: ");
		indexChosen = scanner.nextInt();
		
		System.out.println("");
		return indexChosen;
	}
	
	public int selectWeapon() {
		int indexChosen;
		
		System.out.print("Please select a weapon: ");
		indexChosen = scanner.nextInt();
		
		System.out.println("");
		return indexChosen;
	}
	
	public int selectCharacter() {
		int indexChosen;
		
		System.out.print("Please select a character: ");
		indexChosen = scanner.nextInt();
		
		System.out.println("");
		return indexChosen;
	}
	
	public void exitProgram() {
		System.out.println("Exiting Program...");
		/* Some code to put here maybe when the time comes.
		 * */
	}
}
