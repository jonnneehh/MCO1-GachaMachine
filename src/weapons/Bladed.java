package weapons;

public class Bladed extends Weapon{
	private int power;
	private int rarity;
	private boolean isGolden;
	
	public Bladed(String name, int level, int power, int rarity, boolean isGolden) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
		this.isGolden = isGolden;
	}
	
	@Override
	protected int computeFinalWeaponPower() { 
		return this.power * this.rarity + (10 * this.rarity);
	}
	
	@Override
	protected int computeFinalWeaponRarity() {
		return this.rarity;
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isGolden() {
		return isGolden;
	}

	public void setGolden(boolean isGolden) {
		this.isGolden = isGolden;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	
}
