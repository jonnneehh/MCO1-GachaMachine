package weapons;
import characters.Character;

public abstract class Weapon {
	protected String name;
	protected int level;
	protected Character characterOwner;
	
	abstract public int computeFinalWeaponPower();
	abstract public int computeFinalWeaponRarity();
	abstract public int getRarity();
	abstract public void setRarity(int rarity);
	abstract public int getPower();
	abstract public void setPower(int power);
	
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
