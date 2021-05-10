import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class SystemManager {
	private Resources r = new Resources("Default", 5000);
	public ArrayList<Character> characterList = new ArrayList<Character>();
	public ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	public ArrayList<Map> defaultMapList = new ArrayList<Map>(); 
	
	public void startProgram() {
		this.inputDefaultMapList();
		
		//The items in this method will be temporary...
		Element Joker = new Element("Joker");
		Character c1 = new Character("Jekyll", 5, Joker, 20, null);
		Character c2 = new Character("Jekyll", 5, Joker, 20, null);
		Character c3 = new Character("Jekyll", 5, Joker, 20, null);
		
		Weapon w1 = new Weapon("Knife", 130, 1, 1, null);
		Weapon w2 = new Weapon("Knife", 130, 1, 1, null);
		Weapon w3 = new Weapon("Knife", 130, 1, 1, null);
		
		this.addNewCharacter(c1);
		this.addNewCharacter(c2);
		this.addNewCharacter(c3);
		
		this.addNewWeapon(w1);
		this.addNewWeapon(w2);
		this.addNewWeapon(w3);
	}
	
	private String uniqueIDGenerator() {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("ddMMyyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("sSSSnnnnn");
		
		String ID = ld.format(formatterDate) + lt.format(formatterTime) + (new Random().nextInt(900) + 100);
		
		return ID;
	}
	
	public void levelUp(Weapon w) {
		w.setLevel(w.getLevel() + 1);
		this.r.setAmount(this.r.getAmount() - 1);
	}
	
	public void levelUp(Character c) {
		c.setLevel(c.getLevel() + 1);
		this.r.setAmount(this.r.getAmount() - 1);
	}
	
	public void merge(Weapon mainW, Weapon w2, Weapon w3) {
		if(mainW.getName() == w2.getName() && mainW.getName() == w3.getName() &&
				mainW.getRarity() == w2.getRarity() && mainW.getRarity() == w3.getRarity()) {
			mainW.setRarity(mainW.getRarity() + 1);
			
			this.weaponList.remove(w2);
			this.weaponList.remove(w3);
		}
	}
	
	public void merge(Character mainC, Character c2, Character c3) {
		if(mainC.getName() == c2.getName() && mainC.getName() == c3.getName() &&
		   mainC.getRarity() == c2.getRarity() && mainC.getRarity() == c3.getRarity()) {
		    
			mainC.setRarity(mainC.getRarity() + 1);
			
			this.characterList.remove(c2);
			this.characterList.remove(c3);
		}
	}
	
	public void equipWeapon(Character c, Weapon w) {
		c.setWeapon(w);
		w.setCharacterOwner(c);
	}
	
	public void unequipWeapon(Character c, Weapon w) {
		c.setWeapon(null);
		w.setCharacterOwner(null);
	}
	
	public void addNewCharacter(Character c) {
		c.setUniqueID(this.uniqueIDGenerator());
		this.characterList.add(c);
	}
	
	public void removeCharacter(Character c) {
		this.unequipWeapon(this.characterList.get(this.characterList.indexOf(c)), 
						   this.weaponList.get(this.weaponList.indexOf(c.getWeapon())));
		this.characterList.remove(c);
	}
	
	public void addNewWeapon(Weapon w) {
		w.setUniqueID(this.uniqueIDGenerator());
		this.weaponList.add(w);
	}
	
	public void removeWeapon(Weapon w) {
		this.unequipWeapon(this.characterList.get(this.characterList.indexOf(w.getCharacterOwner())), 
						   this.weaponList.get(this.weaponList.indexOf(w)));
		this.weaponList.remove(w);
	}
	
	public void startAdventure(Character c, Map m) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		System.out.println(String.valueOf(characterSuperiority));
		System.out.println(String.valueOf(enemySuperiority));
		
		if(success == 1) {
			//excellently completed
			c.setLevel(c.getLevel() + 2);
			System.out.println("Excellently Completed!");
		}
		else if(success == 0) {
			//successfully completed
			c.setLevel(c.getLevel() + 1);
			System.out.println("Successfully Completed!");
		}
		else {
			System.out.println("Map Completed");
		}
		
		this.r.setAmount(this.r.getAmount() + Math.round(this.r.totalResourcesGained(m, c)));
	}
	
	public void startAdventure(Character c1, Character c2, Map m) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c1, c2);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		System.out.println(String.valueOf(characterSuperiority));
		System.out.println(String.valueOf(enemySuperiority));
		
		if(success == 1) {
			//excellently completed
			c1.setLevel(c1.getLevel() + 2);
			c2.setLevel(c2.getLevel() + 2);
			System.out.println("Excellently Completed!");
		}
		else if(success == 0) {
			//successfully completed
			c1.setLevel(c1.getLevel() + 1);
			c2.setLevel(c2.getLevel() + 1);
			System.out.println("Successfully Completed!");
		}
		else {
			System.out.println("Map Completed");
		}
		
		this.r.setAmount(this.r.getAmount() + Math.round(this.r.totalResourcesGained(m, c1, c2)));
	}
	
	public void inputDefaultMapList() {
		Enemy Slime = new Enemy("Slime", 73);
		Enemy Orc = new Enemy("Orc", 84);
		Enemy Familiar = new Enemy("Familiar", 144);
		Enemy Faerie = new Enemy("Faerie", 175);
		Enemy Elf = new Enemy("Elf", 224);
		Enemy Sorcerer = new Enemy("Sorcerer", 313);
		Enemy Hydra = new Enemy("Hydra", 360);
		Enemy Basilisk = new Enemy("Basilisk", 499);
		Enemy Harpy = new Enemy("Harpy", 639);
		Enemy Loki = new Enemy("Loki", 740);
		
		ArrayList<Enemy> enemyList1 = new ArrayList<Enemy>();
		
		enemyList1.add(Elf);
		for(int i = 0; i < 6; i++) enemyList1.add(Slime);
		
		ArrayList<Enemy> enemyList2 = new ArrayList<Enemy>();
		
		for(int i = 0; i < 5; i++) enemyList2.add(Slime);
		for(int i = 0; i < 5; i++) enemyList2.add(Orc);
		for(int i = 0; i < 3; i++) enemyList2.add(Familiar);
		for(int i = 0; i < 3; i++) enemyList2.add(Faerie);
		for(int i = 0; i < 2; i++) enemyList2.add(Elf);
		enemyList2.add(Sorcerer);
		
		ArrayList<Enemy> enemyList3 = new ArrayList<Enemy>();
		
		for(int i = 0; i < 75; i++) enemyList3.add(Slime);
		for(int i = 0; i < 20; i++) enemyList3.add(Sorcerer);
		for(int i = 0; i < 5; i++) enemyList3.add(Hydra);
		
		ArrayList<Enemy> enemyList4 = new ArrayList<Enemy>();
		
		for(int i = 0; i < 20; i++) enemyList4.add(Basilisk);
		for(int i = 0; i < 7; i++) enemyList4.add(Harpy);
		for(int i = 0; i < 5; i++) enemyList4.add(Loki);
		
		ArrayList<Enemy> enemyList5 = new ArrayList<Enemy>();
		
		for(int i = 0; i < 50; i++) enemyList5.add(Faerie);
		for(int i = 0; i < 20; i++) enemyList5.add(Hydra);
		for(int i = 0; i < 10; i++) enemyList5.add(Loki);
		
		defaultMapList.add(new Map("Underground Caverns", 53, enemyList1));
		defaultMapList.add(new Map("Forest of Enchantments", 77, enemyList2));
		defaultMapList.add(new Map("Sea of Hope", 85, enemyList3));
		defaultMapList.add(new Map("Tower of Ether", 91, enemyList4));
		defaultMapList.add(new Map("Celestial Plane", 100, enemyList5));
		
	}
	
	public int testChoiceWeapon(int choice) {
		UserInterface ui = new UserInterface();
		
		do {
			choice = ui.selectWeapon();
		}while(choice >= weaponList.size() || choice < 0);
		
		return choice;
	}
	
	public int testChoiceCharacter(int choice) {
		UserInterface ui = new UserInterface();
		
		do {
			choice = ui.selectCharacter();
		}while(choice >= characterList.size() || choice < 0);
		
		return choice;
	}
	
	
	public Resources getR() {
		return r;
	}

	public void setR(Resources r) {
		this.r = r;
	}
	
}
