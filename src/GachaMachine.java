import java.util.Random;


public class GachaMachine {
	
	public Character pullChar(int totalResources) {
		totalResources = totalResources - 300;
	}

	public Weapon pullWeapon(int totalResources) {
		totalResources = totalResources - 300;
		
	}
	private int rarityRandomizer() {
		Random r = new Random();
		int rarity = r.nextInt(100);
		
		if(rarity < 50) { //50%
			return 1;
		}
		else if(rarity < 85) { //35%
			return 2;
		}
		else { //15%
			return 3;
		}
	}
	
	
	

}
