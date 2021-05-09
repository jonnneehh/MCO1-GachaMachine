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
		 int finalWeaponPower = 1;
		 
		 if(c.getWeapon() != null)
			 finalWeaponPower = c.getWeapon().computeFinalWeaponPower();
		 
		 return finalWeaponPower * (c.computeTotalCharInfluence() / 10);
	 }
	 
	 public int computeCharacterSuperiority(Character c1, Character c2) {
		 int finalWeaponPower1 = 1;
		 int finalWeaponPower2 = 1;
		 
		 if(c1.getWeapon() != null)
			 finalWeaponPower1 = c1.getWeapon().computeFinalWeaponPower();
		 if(c2.getWeapon() != null)
			 finalWeaponPower2 = c2.getWeapon().computeFinalWeaponPower();
		 
		 return (finalWeaponPower1 * (c1.computeTotalCharInfluence() / 10)) + (finalWeaponPower2 * (c2.computeTotalCharInfluence() / 10));

	 }
	 
	 public int computeEnemySuperiority() {
         int sum = 0;

         for(int i = 0; i < this.enemyList.size(); i++)
             sum += this.enemyList.get(i).getPower();        

         return sum;
     }
	 
	 public int computeSuccess(int characterSuperiority, int enemySuperiority) {
		 if(characterSuperiority >= enemySuperiority * 1.5) {
			 //excellently completed
			 return 1;
		 }
		 else if(characterSuperiority > enemySuperiority) {
			 //successfully completed 
			 return 0;
		 }
		 else {
			 return -1;
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
