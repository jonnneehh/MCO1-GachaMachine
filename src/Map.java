
public class Map {
	//Variables
	private String name;
	private int mapBaseAmount;
	public Enemy[] enemyList;
	
	
	//Constructors
	public Map(String name, int mapBaseAmount, Enemy[] enemyList) {
		this.setName(name);
		this.setMapBaseAmount(mapBaseAmount);
		this.setEnemyList(enemyList);
	}
	
	
	
	//Methods
	/*
	 * public ..... computeCharacterSuperiority(one character)
	 * public ..... computeCharacterSuperiority(two characters)
	 * public int computeEnemySuperiority()
	 * */
	
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
	public Enemy[] getEnemyList() {
		return this.enemyList;
	}
	public void setEnemyList(Enemy[] enemyList) {
		this.enemyList = enemyList;
	}
	
}
