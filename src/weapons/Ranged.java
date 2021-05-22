package weapons;

public class Ranged extends Weapon{
	private int power;
	private int rarity;
	private int criticalDamage;
	
	public Ranged(String name, int level, int power, int rarity, int criticalDamage) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
		this.criticalDamage = criticalDamage;
	}
	
	@Override
	public int computeFinalWeaponPower() {
		return this.power * this.rarity * this.criticalDamage;
	}

	@Override
	public int computeFinalWeaponRarity() {
		return this.rarity;
	}
	
	@Override
	public int getPower() {
		return power;
	}

	@Override
	public void setPower(int power) {
		this.power = power;
		
	}
	
	@Override
	public int getRarity() {
		return rarity;
	}
	
	@Override
	public void setRarity(int rarity) {
		this.rarity = rarity;
		
	}
	
	public int getCriticalDamage() {
		return criticalDamage;
	}

	public void setCriticalDamage(int criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
}
