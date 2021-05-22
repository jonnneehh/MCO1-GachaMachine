package weapons;

public class Magical extends Weapon{
	private int power;
	private int rarity;
	
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
