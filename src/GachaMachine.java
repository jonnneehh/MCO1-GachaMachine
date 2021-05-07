import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class GachaMachine {
	
	public Character pullChar(int totalResources) {
		int rarity = 0;
		int index = 0;
		
		totalResources = totalResources - 300;
		rarity = rarityRandomizer();
		
		if(rarity == 1) {
			//randomizes index
			index = ThreadLocalRandom.current().nextInt(0, 5 + 1); //min, max + 1
			
			
		}
		else if(rarity == 2) {
			index = ThreadLocalRandom.current().nextInt(6, 11 + 1);
			
		}
		else {
			index = ThreadLocalRandom.current().nextInt(12, 17 + 1);
			
		}
		
	}

	public Weapon pullWeapon(int totalResources) {
		int rarity = 0;
		int index = 0;
		
		totalResources = totalResources - 300;
		rarity = rarityRandomizer();
		
		if(rarity == 1) {
			//randomizes index
			index = ThreadLocalRandom.current().nextInt(0, 5 + 1); //min, max + 1
			
			
		}
		else if(rarity == 2) {
			index = ThreadLocalRandom.current().nextInt(6, 11 + 1);
			
		}
		else {
			index = ThreadLocalRandom.current().nextInt(12, 17 + 1);
			
		}
		
		
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
