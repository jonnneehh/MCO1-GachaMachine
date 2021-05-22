package gachamachine;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import characters.Element;
import characters.Character;
import weapons.*;

public class GachaMachine {
	private ArrayList<Character> defaultCharacterList = new ArrayList<Character>();
	private ArrayList<Weapon> defaultWeaponList = new ArrayList<Weapon>();
	
	private void inputDefaultCharacters() {
		Element Joker = new Element("Joker");
		Element Trigger = new Element("Trigger");
		Element Metal = new Element("Metal");
		Element Cyclone = new Element("Cyclone");
		Element Heat = new Element("Heat");
		Element Luna = new Element("Luna");
		
		int defaultLevel = 20;
		
		//Rarity 1 Characters
		defaultCharacterList.add(new Character("Jekyll", 1, Joker, defaultLevel, null));
		defaultCharacterList.add(new Character("Earl Robert", 1, Trigger, defaultLevel, null));
		defaultCharacterList.add(new Character("Count d'Artagnan", 1, Metal, defaultLevel, null));
		defaultCharacterList.add(new Character("Stede", 1, Cyclone, defaultLevel, null));
		defaultCharacterList.add(new Character("Kaguya", 1, Luna, defaultLevel, null));
		defaultCharacterList.add(new Character("Van Helmont", 1, Heat, defaultLevel, null));
		
		//Rarity 2 Characters
		defaultCharacterList.add(new Character("Gray", 2, Joker, defaultLevel, null));
		defaultCharacterList.add(new Character("Bonney", 2, Trigger, defaultLevel, null));
		defaultCharacterList.add(new Character("Sir William Marshal", 2, Metal, defaultLevel, null));
		defaultCharacterList.add(new Character("Teach", 2, Cyclone, defaultLevel, null));
		defaultCharacterList.add(new Character("Jeanne", 2, Luna, defaultLevel, null));
		defaultCharacterList.add(new Character("Paracelsus", 2, Heat, defaultLevel, null));
		
		//Rarity 3 Characters
		defaultCharacterList.add(new Character("Faust", 3, Joker, defaultLevel, null));
		defaultCharacterList.add(new Character("Clyde", 3, Trigger, defaultLevel, null));
		defaultCharacterList.add(new Character("Masamune", 3, Metal, defaultLevel, null));
		defaultCharacterList.add(new Character("Avery", 3, Cyclone, defaultLevel, null));
		defaultCharacterList.add(new Character("Arthur", 3, Luna, defaultLevel, null));
		defaultCharacterList.add(new Character("Hermes", 3, Heat, defaultLevel, null));
	}
	
	private void inputDefaultWeapons() {
		//Rarity 1 Weapons
		defaultWeaponList.add(new Weapon("Knife", 130, 1, 1, null));
		defaultWeaponList.add(new Weapon("Rapier", 140, 1, 1, null));
		defaultWeaponList.add(new Weapon("Revolver", 150, 1, 1, null));
		defaultWeaponList.add(new Weapon("Mermaid Tears", 160, 1, 1, null));
		defaultWeaponList.add(new Weapon("Clarent", 170, 1, 1, null));
		defaultWeaponList.add(new Weapon("English Longbow", 180, 1, 1, null));
		
		//Rarity 2 Weapons
		defaultWeaponList.add(new Weapon("Circe Staff", 150, 2, 1, null));
		defaultWeaponList.add(new Weapon("Vorpal sword", 160, 2, 1, null));
		defaultWeaponList.add(new Weapon("Merlin�s Staff", 170, 2, 1, null));
		defaultWeaponList.add(new Weapon("Five-cross Sword", 180, 2, 1, null));
		defaultWeaponList.add(new Weapon("Bashosen", 190, 2, 1, null));
		defaultWeaponList.add(new Weapon("Golden Cudgel", 200, 2, 1, null));
		
		//Rarity 3 Weapons
		defaultWeaponList.add(new Weapon("Philosopher�s stone", 180, 3, 1, null));
		defaultWeaponList.add(new Weapon("Magic Bullets", 190, 3, 1, null));
		defaultWeaponList.add(new Weapon("Fragarach", 200, 3, 1, null));
		defaultWeaponList.add(new Weapon("Honjo Masamune", 210, 3, 1, null));
		defaultWeaponList.add(new Weapon("Excalibur", 220, 3, 1, null));
		defaultWeaponList.add(new Weapon("Scythe of Father Time", 230, 3, 1, null));
	}
	
	public Character pullChar(){
		int rarity = 0;
		int index = 0;
		
		this.inputDefaultCharacters();
		
		//totalResources = totalResources - 300;
		rarity = rarityRandomizer();
		
		if(rarity == 1) {
			//randomizes index
			index = ThreadLocalRandom.current().nextInt(0, 5 + 1); //min, max + 1
		}
		else if(rarity == 2) {
			index = ThreadLocalRandom.current().nextInt(6, 11 + 1);
			
		}
		else {
			index = ThreadLocalRandom.current().nextInt(12, 17 + 1);
		}
		
		return defaultCharacterList.get(index);
	}

	public Weapon pullWeapon() {
		int rarity = 0;
		int index = 0;
		
		this.inputDefaultWeapons();
		
		//totalResources = totalResources - 300;
		rarity = rarityRandomizer();
		
		if(rarity == 1) {
			//randomizes index
			index = ThreadLocalRandom.current().nextInt(0, 5 + 1); //min, max + 1	
		}
		
		else if(rarity == 2) {
			index = ThreadLocalRandom.current().nextInt(6, 11 + 1);
		}
		
		else {
			index = ThreadLocalRandom.current().nextInt(12, 17 + 1);
		}
		
		return defaultWeaponList.get(index);
	}
	
	private int rarityRandomizer() {
		Random r = new Random();
		int rarity = r.nextInt(100);
		
		if(rarity < 50) { //50%
			return 1;
		}
		
		else if(rarity < 85) { //35%
			return 2;
		}
		
		else { //15%
			return 3;
		}
	}
	
	
	

}