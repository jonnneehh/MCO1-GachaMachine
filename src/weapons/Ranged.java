package weapons;

public class Ranged extends Weapon{
	private int power;
	private int rarity;
	private int criticalDamage;
	
	public Ranged(String name, int level, int power, int rarity, int criticalDamage, characters.Character characterOwner) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
		this.criticalDamage = criticalDamage;
		this.characterOwner = characterOwner;
	}
	
	@Override
	protected int computeFinalWeaponPower() {
		return this.power * this.rarity * this.criticalDamage;
	}

	@Override
	protected int computeFinalWeaponRarity() {
		return this.rarity;
	}

	public int getCriticalDamage() {
		return criticalDamage;
	}

	public void setCriticalDamage(int criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
}
