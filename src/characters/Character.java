package characters;
import weapons.Weapon;

public class Character {
	private String name;
	private int rarity;
	private Element element;
	private int level;
	private Weapon weapon;
	
	public Character(String name, int rarity, Element element, int level) {
		this.setName(name);
		this.setRarity(rarity);
		this.setElement(element);
		this.setLevel(level);
	}
	
	public int computeTotalCharInfluence() {
		return this.level * (1 + ((this.rarity - 1) / 5));
	}
	
	public float computeElementCombinationMultiplier(Character c) {
		//Normal Pairing
		if(this.element.getName() == c.element.getName())
			return 1.1f;
		
		//Decent Pairing
		else if((this.element.getName() == "Joker" && c.element.getName() == "Trigger") || 
				(this.element.getName() == "Joker" && c.element.getName() == "Metal") || 
				(this.element.getName() == "Metal" && c.element.getName() == "Cyclone") || 
				(this.element.getName() == "Metal" && c.element.getName() == "Luna"))
			return 1.25f;
		
		//Nice Pairing
		else if((this.element.getName() == "Joker" && c.element.getName() == "Luna") ||
				(this.element.getName() == "Joker" && c.element.getName() == "Heat"))
			return 1.5f;
		
		//Perfect Pairing
		else if((this.element.getName() == "Joker" && c.element.getName() == "Cyclone") || 
				(this.element.getName() == "Trigger" && c.element.getName() == "Luna") ||
				(this.element.getName() == "Metal" && c.element.getName() == "Heat"))
			return 1.75f;
		
		//Bad Pairing
		else if((this.element.getName() == "Cyclone" && c.element.getName() == "Luna") || 
				(this.element.getName() == "Cyclone" && c.element.getName() == "Heat") ||
				(this.element.getName() == "Luna" && c.element.getName() == "Heat"))
			return 0.75f;
		
		//No effect
		else
			return 1.00f;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRarity() {
		return this.rarity;		
	}
	
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public void setElement(Element element) {
		this.element = element;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
