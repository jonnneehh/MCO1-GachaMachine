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
		int finalWeaponPower;
		double rarityMultiplier;
		
		if (this.computeFinalWeaponRarity() == 1) rarityMultiplier = 0.7;
		else if (this.computeFinalWeaponRarity() == 2) rarityMultiplier = 0.8;
		else if (this.computeFinalWeaponRarity() == 3) rarityMultiplier = 0.9;
		else if (this.computeFinalWeaponRarity() == 4) rarityMultiplier = 1.0;
		else if (this.computeFinalWeaponRarity() == 5) rarityMultiplier = 1.2;
		else if (this.computeFinalWeaponRarity() == 6) rarityMultiplier = 1.5;
		else rarityMultiplier = 0;
		
		finalWeaponPower = (int) Math.round(this.getPower() * rarityMultiplier) + (10 * this.computeFinalWeaponRarity());
		
		return finalWeaponPower;
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
