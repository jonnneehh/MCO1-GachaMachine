import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SystemManager {
	private int totalResources;
	public ArrayList<Character> characterList = new ArrayList<Character>();
	public ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	
	public void startProgram() {
		//The items in this method will be temporary...
	}
	
	private String uniqueIDGenerator() {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("ddMMyyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HHmmssSSS");
		
		String ID = ld.format(formatterDate) + lt.format(formatterTime);
		
		return ID;
	}
	
	public void levelUp(Weapon w) {
		w.setLevel(w.getLevel() + 1);
		this.setTotalResources(this.getTotalResources() - 1);
	}
	
	public void levelUp(Character c) {
		c.setLevel(c.getLevel() + 1);
		this.setTotalResources(this.getTotalResources() - 1);
	}
	
	public void merge(Weapon mainW, Weapon w2, Weapon w3) {
		if(mainW.getName() == w2.getName() && mainW.getName() == w3.getName() &&
				mainW.getRarity() == w2.getRarity() && mainW.getRarity() == w3.getRarity()) {
			mainW.setRarity(mainW.getRarity() + 1);
			
			weaponList.remove(w2);
			weaponList.remove(w3);
		}
	}
	
	public void merge(Character mainC, Character c2, Character c3) {
		if(mainC.getName() == c2.getName() && mainC.getName() == c3.getName() &&
				mainC.getRarity() == c2.getRarity() && mainC.getRarity() == c3.getRarity()) {
			mainC.setRarity(mainC.getRarity() + 1);
			
			characterList.remove(c2);
			characterList.remove(c3);
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

	public int getTotalResources() {
		return totalResources;
	}

	public void setTotalResources(int totalResources) {
		this.totalResources = totalResources;
	}
	
	public void addNewCharacter(Character c) {
		c.setUniqueID(this.uniqueIDGenerator());
		characterList.add(c);
	}
	
	public void removeCharacter(Character c) {
		characterList.remove(c);
	}
	
	public void addNewWeapon(Weapon w) {
		w.setUniqueID(this.uniqueIDGenerator());
		weaponList.add(w);
	}
	
	public void removeWeapon(Weapon w) {
		weaponList.remove(w);
	}
	
	public int startAdventure(Character c, Map m, Resources r, int numOfResources) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		if(success == 1) {
			//excellently completed
			c.setLevel(c.getLevel() + 2);
		}
		else if(success == 0) {
			//successfully completed
			c.setLevel(c.getLevel() + 1);
		}
		
		return numOfResources += r.totalResourcesGained(m, c);
		
	}
	
	public int startAdventure(Character c1, Character c2, Map m, Resources r, int numOfResources) {
		int enemySuperiority = 0;
		int characterSuperiority = 0;
		int success = 0;
		
		characterSuperiority = m.computeCharacterSuperiority(c1, c2);
		enemySuperiority = m.computeEnemySuperiority();
		success = m.computeSuccess(characterSuperiority, enemySuperiority);
		
		if(success == 1) {
			//excellently completed
			c1.setLevel(c1.getLevel() + 2);
			c2.setLevel(c2.getLevel() + 2);
		}
		else if(success == 0) {
			//successfully completed
			c1.setLevel(c1.getLevel() + 1);
			c2.setLevel(c2.getLevel() + 1);
		}
		
		return numOfResources += r.totalResourcesGained(m, c1, c2);
		
	}
}
