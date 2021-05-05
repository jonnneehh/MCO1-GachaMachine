
public class SystemManager {
	private int totalResources;
	public Character characterList[];
	public Weapon weaponList[];
	
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
			//ADD CODE: Access Weapon List and remove w2 and w3 from it.
		}
	}
	
	public void merge(Character mainC, Character c2, Character c3) {
		if(mainC.getName() == c2.getName() && mainC.getName() == c3.getName() &&
				mainC.getRarity() == c2.getRarity() && mainC.getRarity() == c3.getRarity()) {
			mainC.setRarity(mainC.getRarity() + 1);
			//ADD CODE: Access Weapon List and remove c2 and c3 from it.
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
}
