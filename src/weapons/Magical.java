package weapons;

public class Magical extends Weapon{
	private int power;
	private int rarity;
	
	public Magical(String name, int level, int power, int rarity) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
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
		
		finalWeaponPower = (int) Math.round(this.getPower() * rarityMultiplier);
		
		return finalWeaponPower;
	}
	
	@Override
	public int computeFinalWeaponRarity() {
		return this.rarity + 1;
	}
	
	@Override
	public int getPower() {
		return this.power;
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
}
