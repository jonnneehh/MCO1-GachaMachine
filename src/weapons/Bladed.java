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
	public int computeFinalWeaponPower() { 
		return this.getPower() * this.computeFinalWeaponRarity() + (10 * this.computeFinalWeaponRarity());
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
	
	public boolean isGolden() {
		return isGolden;
	}

	public void setGolden(boolean isGolden) {
		this.isGolden = isGolden;
	}
}
