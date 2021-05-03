
public class SystemManager {
	public int totalResources;
	public Character characterList[];
	public Weapon weaponList[];
	
	public void equipWeapon(Character c, Weapon w) {
		c.setWeapon(w);
		w.setCharacterOwner(c);
	}
	
	public void unequipWeapon(Character c, Weapon w) {
		c.setWeapon(null);
		w.setCharacterOwner(null);
	}
}
