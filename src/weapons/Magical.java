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
		return this.power * this.rarity;
	}
	
	@Override
	public int computeFinalWeaponRarity() {
		return this.rarity + 1;
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
}
