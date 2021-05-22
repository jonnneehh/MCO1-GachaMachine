package weapons;

public class Magical extends Weapon{
	private int power;
	private int rarity;
	
	public Magical(String name, int level, int power, int rarity, characters.Character characterOwner) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.rarity = rarity;
		this.characterOwner = characterOwner;
	}
	
	@Override
	protected int computeFinalWeaponPower() {
		return this.power * this.rarity;
	}
	
	@Override
	protected int computeFinalWeaponRarity() {
		return this.rarity + 1;
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
