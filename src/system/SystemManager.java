package system;
import java.util.ArrayList;

import weapons.*;
import characters.Character;
import characters.Element;
import gachamachine.GachaMachine;
import adventure.Map;
import adventure.Enemy;
 
public class SystemManager {
	private Resources Anima = new Resources("Anima", 10000);
	private Resources Refina = new Resources("Refina", 10000);
	public ArrayList<Character> characterList = new ArrayList<Character>();
	public ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	public ArrayList<Map> defaultMapList = new ArrayList<Map>(); 
	
	public void startProgram() {
		Element Joker = new Element("Joker");
		String bladed = "Bladed";
		
		this.addNewCharacter(new Character("Jekyll", 1, Joker, 20, bladed)); 
		this.addNewCharacter(new Character("Jekyll", 1, Joker, 20, bladed));
		this.addNewCharacter(new Character("Jekyll", 1, Joker, 20, bladed)); 
		
		this.addNewWeapon(new Magical("Merlin’s Staff", 1, 170, 1));
		this.addNewWeapon(new Bladed("Knife", 1, 130, 1, false));
		this.addNewWeapon(new Ranged("Bashosen", 1, 190, 2, 1.0));
		this.addNewWeapon(new Bladed("Golden Cudgel", 1, 200, 2, true));
		
		this.inputDefaultMapList();
	}
	
	public void levelUp(Weapon w) {
		if(w.getLevel() < 50) {
			w.setLevel(w.getLevel() + 1);
			this.Refina.setAmount(this.Refina.getAmount() - 1);
		}
		else System.out.println("Maximum level reached!");
	}
	
	public void levelUp(Character c) {
		if(c.getLevel() < 100) {
			c.setLevel(c.getLevel() + 1);
			this.Refina.setAmount(this.Refina.getAmount() - 1);
		}
		else System.out.println("Maximum level reached!");
	}
	
	public void merge(Weapon mainW, Weapon w2, Weapon w3) {
		if(mainW.getRarity() < 5) {
			if(mainW.getName() == w2.getName() && mainW.getName() == w3.getName() &&
			   mainW.getRarity() == w2.getRarity() && mainW.getRarity() == w3.getRarity()) {
				mainW.setRarity(mainW.getRarity() + 1);
					
				this.weaponList.remove(w2);
				this.weaponList.remove(w3);
			}
		}
	}
	
	public void merge(Character mainC, Character c2, Character c3) {
		if(mainC.getRarity() < 5) {
			if(mainC.getName() == c2.getName() && mainC.getName() == c3.getName() &&
			   mainC.getRarity() == c2.getRarity() && mainC.getRarity() == c3.getRarity()) {
					    
				mainC.setRarity(mainC.getRarity() + 1);
						
				this.characterList.remove(c2);
				this.characterList.remove(c3);
			}
		}
	}
	
	public boolean isEquippableWeapon(Character c, Weapon w) {
		String weaponType;
		
		if(w instanceof Bladed) weaponType = "Bladed";
		else if(w instanceof Magical) weaponType = "Magical";
		else weaponType = "Ranged";
		
		if(weaponType == c.getEquippableWeaponType()) {
			return true;
		}
		else {
			System.out.println("This character can only equip " + c.getEquippableWeaponType() + " type weapons");
			return false;
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
		this.characterList.add(c);
	}
	
	public void removeCharacter(Character c) {
		this.characterList.get(this.characterList.indexOf(c)).setWeapon(null);
		this.weaponList.get(this.weaponList.indexOf(c.getWeapon())).setCharacterOwner(null);

		this.characterList.remove(c);
	}
	
	public void addNewWeapon(Weapon w) {
		this.weaponList.add(w);
	}
	
	public void removeWeapon(Weapon w) {
		this.characterList.get(this.characterList.indexOf(w.getCharacterOwner())).setWeapon(null);; 
		this.weaponList.get(this.weaponList.indexOf(w)).setCharacterOwner(null);
		
		this.weaponList.remove(w);
	}
	
	public void startAdventure(Character c, Map m) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		//System.out.println(String.valueOf(characterSuperiority));
		//System.out.println(String.valueOf(enemySuperiority));

		if(success == 1) {
			//excellently completed
			if(c.getLevel() < 99) c.setLevel(c.getLevel() + 2);
			else if(c.getLevel() == 99) c.setLevel(c.getLevel() + 1);
			
			System.out.println("Excellently Completed!");
		}
		else if(success == 0) {
			//successfully completed
			if(c.getLevel() < 100) c.setLevel(c.getLevel() + 1);
			System.out.println("Successfully Completed!");
		}
		else {
			System.out.println("Map Completed");
		}
		
		this.Refina.setAmount(this.Refina.getAmount() + Math.round(this.Refina.totalResourcesGained(m, c)));
		this.Anima.setAmount( Math.toIntExact( this.Anima.getAmount() + Math.round( this.Anima.totalResourcesGained(m, c) * 0.7)) );
	}

	public void startAdventure(Character c1, Character c2, Map m) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c1, c2);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		//System.out.println(String.valueOf(characterSuperiority));
		//System.out.println(String.valueOf(enemySuperiority));
		
		if(success == 1) {
			//excellently completed
			if(c1.getLevel() < 99) c1.setLevel(c1.getLevel() + 2);
			else if(c1.getLevel() == 99) c1.setLevel(c1.getLevel() + 1);
			
			if(c2.getLevel() < 99) c2.setLevel(c2.getLevel() + 2);
			else if(c2.getLevel() == 99) c2.setLevel(c2.getLevel() + 1);
			
			System.out.println("Excellently Completed!");
		}
		else if(success == 0) {
			//successfully completed
			if(c1.getLevel() < 100) c1.setLevel(c1.getLevel() + 1);
			if(c2.getLevel() < 100) c2.setLevel(c2.getLevel() + 1);
			System.out.println("Successfully Completed!");
		}
		else {
			System.out.println("Map Completed");
		}
		
		this.Refina.setAmount(this.Refina.getAmount() + Math.round(this.Refina.totalResourcesGained(m, c1, c2)));
		this.Anima.setAmount( Math.toIntExact( this.Anima.getAmount() + Math.round( this.Anima.totalResourcesGained(m, c1, c2) * 0.7)) );
	}
	
	private void inputDefaultMapList() {
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
	
	public int testLevelChoice(Character c, int choice) {
		UserInterface ui = new UserInterface();
		int maxInt = 100 - c.getLevel();
		
		if(c.getLevel() != 100) {
			do {
				choice = ui.selectNumberOfLevels();
			}while(choice > maxInt || choice < 0);
			
			return choice;
		}
		else {
			System.out.println("Your character is fully maxed");
			return 0;
		}
	}
	
	public Resources getRefina() {
		return Refina;
	}

	public void setRefina(Resources Refina) {
		this.Refina = Refina;
	}
	
	public Resources getAnima() {
		return Anima;
	}

	public void setAnima(Resources Anima) {
		this.Anima = Anima;
	}
	
	public void hone(Weapon weapon) {
		if(weapon instanceof Ranged)
			if (((Ranged) weapon).getCriticalDamage() <= 1.9) {//Something about Java glitches if CritDamage < 2.0. Still works though.
				((Ranged) weapon).setCriticalDamage( ((Ranged) weapon).getCriticalDamage() + 0.2); 
				this.Refina.setAmount(this.Refina.getAmount() - 10);
			}
			else 
				System.out.println("Maximum Crit Damage Reached");
		else
			System.out.println("Cannot hone. Not a Ranged Weapon");
	}
	
	public void rerollGoldenWeapon(Weapon w) {
		Weapon newWeapon;
		GachaMachine gc = new GachaMachine();
		
		if(w instanceof Bladed)
			if (((Bladed) w).isGolden() == true) {
				newWeapon = gc.pullWeapon();
				weaponList.remove(w);
				weaponList.add(newWeapon);
				this.Refina.setAmount(this.Refina.getAmount() - 150);
			}
			else 
				System.out.println("Not a Golden Weapon");
		else 
			System.out.println("Not a Golden Weapon");
	}		
}
