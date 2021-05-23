package weapons;

public class Ranged extends Weapon{
	private int power;
	private int rarity;
	private double criticalDamage;
	
	public Ranged(String name, int level, int power, int rarity, double criticalDamage) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
		this.criticalDamage = criticalDamage;
	}
	
	@Override
	public int computeFinalWeaponPower() {
		return (int) Math.round(this.getPower() * this.computeFinalWeaponRarity() * this.getCriticalDamage());
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
		return this.rarity;
	}
	
	@Override
	public void setRarity(int rarity) {
		this.rarity = rarity;
		
	}
	
	public double getCriticalDamage() {
		return this.criticalDamage;
	}

	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
}
