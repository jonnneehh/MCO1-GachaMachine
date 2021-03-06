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
		String bladed = "Bladed";
		String ranged = "Ranged";
		String magical = "Magical";
		
		//Rarity 1 Characters
		defaultCharacterList.add(new Character("Jekyll", 1, Joker, defaultLevel, bladed));
		defaultCharacterList.add(new Character("Earl Robert", 1, Trigger, defaultLevel, ranged));
		defaultCharacterList.add(new Character("Count d'Artagnan", 1, Metal, defaultLevel, magical));
		defaultCharacterList.add(new Character("Stede", 1, Cyclone, defaultLevel, bladed));
		defaultCharacterList.add(new Character("Kaguya", 1, Luna, defaultLevel, ranged));
		defaultCharacterList.add(new Character("Van Helmont", 1, Heat, defaultLevel, magical));
		
		//Rarity 2 Characters
		defaultCharacterList.add(new Character("Gray", 2, Joker, defaultLevel, magical));
		defaultCharacterList.add(new Character("Bonney", 2, Trigger, defaultLevel, bladed));
		defaultCharacterList.add(new Character("Sir William Marshal", 2, Metal, defaultLevel, ranged));
		defaultCharacterList.add(new Character("Teach", 2, Cyclone, defaultLevel, magical));
		defaultCharacterList.add(new Character("Jeanne", 2, Luna, defaultLevel, bladed));
		defaultCharacterList.add(new Character("Paracelsus", 2, Heat, defaultLevel, ranged));
		
		//Rarity 3 Characters
		defaultCharacterList.add(new Character("Faust", 3, Joker, defaultLevel, ranged));
		defaultCharacterList.add(new Character("Clyde", 3, Trigger, defaultLevel, magical));
		defaultCharacterList.add(new Character("Masamune", 3, Metal, defaultLevel, bladed));
		defaultCharacterList.add(new Character("Avery", 3, Cyclone, defaultLevel, ranged));
		defaultCharacterList.add(new Character("Arthur", 3, Luna, defaultLevel, magical));
		defaultCharacterList.add(new Character("Hermes", 3, Heat, defaultLevel, bladed));
	}
	
	private void inputDefaultWeapons() {
		//Rarity 1 Weapons
		defaultWeaponList.add(new Bladed("Knife", 1, 130, 1, false));
		defaultWeaponList.add(new Bladed("Rapier", 1, 140, 1, false));
		defaultWeaponList.add(new Ranged("Revolver", 1, 150, 1, 1));
		defaultWeaponList.add(new Magical("Mermaid Tears", 1, 160, 1));
		defaultWeaponList.add(new Bladed("Clarent", 1, 170, 1, false));
		defaultWeaponList.add(new Ranged("English Longbow", 1, 180, 1, 1));
		
		//Rarity 2 Weapons
		defaultWeaponList.add(new Magical("Circe Staff", 1, 150, 2));
		defaultWeaponList.add(new Magical("Vorpal sword", 1, 160, 2));
		defaultWeaponList.add(new Magical("Merlin?s Staff", 1, 170, 2));
		defaultWeaponList.add(new Bladed("Five-cross Sword", 1, 180, 2, false));
		defaultWeaponList.add(new Ranged("Bashosen", 1, 190, 2, 1));
		defaultWeaponList.add(new Bladed("Golden Cudgel", 1, 200, 2, true));
		
		//Rarity 3 Weapons
		defaultWeaponList.add(new Magical("Philosopher?s stone", 1, 180, 3));
		defaultWeaponList.add(new Ranged("Magic Bullets", 1, 190, 3, 1));
		defaultWeaponList.add(new Bladed("Fragarach", 1, 200, 3, false));
		defaultWeaponList.add(new Bladed("Honjo Masamune", 1, 210, 3, false));
		defaultWeaponList.add(new Bladed("Excalibur", 1, 220, 3, false));
		defaultWeaponList.add(new Bladed("Scythe of Father Time", 1, 230, 2, true));
	}
	
	public Character pullChar(){
		int rarity = 0;
		int index = 0;
		Character pulledCharacter;
		
		this.inputDefaultCharacters();
		 
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
		
		pulledCharacter = defaultCharacterList.get(index);
		this.defaultCharacterList.removeAll(defaultCharacterList);
		return pulledCharacter;
	}

	public Weapon pullWeapon() {
		int rarity = 0;
		int index = 0;
		Weapon pulledWeapon;
		
		this.inputDefaultWeapons();
		
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
		
		pulledWeapon = defaultWeaponList.get(index);
		this.defaultWeaponList.removeAll(defaultWeaponList);
		
		return pulledWeapon;
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
