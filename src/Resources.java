
public class Resources {
	//Variables
	private String resourceType;
	
	
	//Methods
	public int totalResourcesGained(Map m, Character c) {
		return m.getMapBaseAmount() + (c.getWeapon().computeFinalWeaponPower() / 24) * 
				(c.computeTotalCharInfluence() / 36);
	}
	public float totalResourcesGained(Map m, Character c1, Character c2) {
		return m.getMapBaseAmount() + (c1.getWeapon().computeFinalWeaponPower() + c2.getWeapon().computeFinalWeaponPower() / 24) * 
				(c1.computeTotalCharInfluence() + c2.computeTotalCharInfluence() / 36) * c1.computeElementCombinationMultiplier(c2);
	}
	
	
	//Getters and Setters
	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	

}
