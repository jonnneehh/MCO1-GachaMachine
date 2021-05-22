package weapons;
import characters.Character;

public abstract class Weapon {
	protected String name;
	protected int level;
	protected Character characterOwner;
	
	protected abstract int computeFinalWeaponPower();
	protected abstract int computeFinalWeaponRarity();
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Character getCharacterOwner() {
		return this.characterOwner;
	}
	
	public void setCharacterOwner(Character character) {
		this.characterOwner = character;
	}
}
