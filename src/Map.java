import java.util.ArrayList;


public class Map {
	//Variables
	private String name;
	private int mapBaseAmount;
	//private Enemy[] enemyList;
	
	
	
	//Constructors
	public Map(String name, int mapBaseAmount, ArrayList<Integer> enemy) {
		this.setName(name);
		this.setMapBaseAmount(mapBaseAmount);
	}
	
	
	//Methods
	 public int computeCharacterSuperiority(Character c) {
		 return c.getWeapon().computeFinalWeaponPower() * (c.computeTotalCharInfluence() / 10);
	 }
	 public int computeCharacterSuperiority(Character c1, Character c2) {
		 return (c1.getWeapon().computeFinalWeaponPower() * (c1.computeTotalCharInfluence() / 10)) + (c2.getWeapon().computeFinalWeaponPower() * (c2.computeTotalCharInfluence() / 10));

	 }
	 public int computeEnemySuperiority(ArrayList<Enemy> enemy) {
		 return 1;
	 }
	 
	
	//Getters and Setters
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMapBaseAmount() {
		return this.mapBaseAmount;
	}
	public void setMapBaseAmount(int mapBaseAmount) {
		this.mapBaseAmount = mapBaseAmount;
	}
	/*
	public Enemy[] getEnemyList() {
		return this.enemyList;
	}
	public void setEnemyList(Enemy[] enemyList) {
		this.enemyList = enemyList;
	}
	*/
}
