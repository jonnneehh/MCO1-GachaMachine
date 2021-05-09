
public class Resources {
	//Variables
	private String resourceType;
	private int amount;
	
	public Resources(String resourceType, int amount) {
		this.setResourceType(resourceType);
		this.setAmount(amount);
	}
	
	//Methods
	public float totalResourcesGained(Map m, Character c) {
		int finalWeaponPower = 1;
		 
		if(c.getWeapon() != null)
			finalWeaponPower = c.getWeapon().computeFinalWeaponPower();
		 
		return m.getMapBaseAmount() + (finalWeaponPower / 24) * 
			   (c.computeTotalCharInfluence() / 36);
	}
	
	public float totalResourcesGained(Map m, Character c1, Character c2) {
		int finalWeaponPower1 = 1;
		int finalWeaponPower2 = 1;
		 
		if(c1.getWeapon() != null)
			finalWeaponPower1 = c1.getWeapon().computeFinalWeaponPower();
		if(c2.getWeapon() != null)
			finalWeaponPower2 = c2.getWeapon().computeFinalWeaponPower();
		
		return m.getMapBaseAmount() + (finalWeaponPower1 + finalWeaponPower2 / 24) * 
			   (c1.computeTotalCharInfluence() + c2.computeTotalCharInfluence() / 36) * c1.computeElementCombinationMultiplier(c2);
	}
	
	//Getters and Setters
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
