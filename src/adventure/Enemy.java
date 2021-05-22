package adventure;

public class Enemy {
	//Variables
	private String name;
	private int power;
	
		
	//Constructors
	public Enemy(String name, int power) {
		this.setName(name);
		this.setPower(power);
	}
		
		
	//Getters and Setters
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return this.power;
	}
	public void setPower(int power) {
		this.power = power;
	}	

}
