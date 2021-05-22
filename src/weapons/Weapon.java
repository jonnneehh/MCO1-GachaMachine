package weapons;
import characters.Character;

public class Weapon {
	private String name;
	private int power;
	private int rarity;
	private int level;
	private Character characterOwner;
	private String uniqueID;
	
	public Weapon(String name, int power, int rarity, int level, String uniqueID) {
		this.setName(name);
		this.setPower(power);
		this.setRarity(rarity);
		this.setLevel(level);
		this.setUniqueID(uniqueID);
	}
	
	public int computeFinalWeaponPower() {
		return this.power * this.rarity + this.level;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getRarity() {
		return this.rarity;
	}
	
	public void setRarity(int rarity) {
		this.rarity = rarity;
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

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
}
