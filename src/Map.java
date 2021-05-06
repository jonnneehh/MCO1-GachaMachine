import java.util.ArrayList;


public class Map {
	//Variables
	private String name;
	private int mapBaseAmount;
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

	//Constructors
	public Map(String name, int mapBaseAmount, ArrayList<Enemy> enemyList) {
		this.setName(name);
		this.setMapBaseAmount(mapBaseAmount);
		this.setEnemyList(enemyList);
	}
	
	//Methods
	 public int computeCharacterSuperiority(Character c) {
		 return c.getWeapon().computeFinalWeaponPower() * (c.computeTotalCharInfluence() / 10);
	 }
	 
	 public int computeCharacterSuperiority(Character c1, Character c2) {
		 return (c1.getWeapon().computeFinalWeaponPower() * (c1.computeTotalCharInfluence() / 10)) + (c2.getWeapon().computeFinalWeaponPower() * (c2.computeTotalCharInfluence() / 10));

	 }
	 
	 public int computeEnemySuperiority() {
		 int sum = 0;
		 Enemy enemy = new Enemy();
		 
		 for(int i = 0; i < this.enemyList.size(); i++) {
			 enemy = this.enemyList.get(i);
			 sum += enemy.getPower();
		 }
		 
		 return sum;
	 }
	 
	 public boolean computeSuccess(int characterSuperiority, int enemySuperiority) {
		 if(characterSuperiority * 0.5 > enemySuperiority * 0.5) {
			 //excellently completed
			 return true;
		 }
		 else if(characterSuperiority > enemySuperiority) {
			 //successfully completed 
			 return true;
		 }
		 else {
			 return false;
		 }
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
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}
	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}
	
}
