package weapons;

public class Magical extends Weapon{
	private int power;
	private int calculatedRarity;
	private int actualRarity;
	
	@Override
	protected int computeFinalWeaponPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getCalculatedRarity() {
		return calculatedRarity;
	}
	public void setCalculatedRarity(int calculatedRarity) {
		this.calculatedRarity = calculatedRarity;
	}
	public int getActualRarity() {
		return actualRarity;
	}
	public void setActualRarity(int actualRarity) {
		this.actualRarity = actualRarity;
	}

}
