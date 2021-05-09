
public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		SystemManager sm = new SystemManager();
		GachaMachine gc = new GachaMachine();
		
		int userChoice = 0;
		
		ui.startProgram();
		sm.startProgram();
		
		while(userChoice != 5) {
			userChoice = 0;
			ui.showMenuTitle(userChoice);
			System.out.println("Total Resources: " + sm.getTotalResources());
			userChoice = ui.showMainMenu();
						
			if(userChoice == 1) {
				do{
					userChoice = 1;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getTotalResources());
					
					ui.headOfCharacterInfo();
					for(int i = 0; i < sm.characterList.size(); i++)
						ui.displayCharacterInfo(sm.characterList.get(i), i);
					
					userChoice = ui.showCharacterMenu();
					
					//System Managers for showAllCharacters
					if(userChoice == 1) { //Level Up Characters
						sm.levelUp(sm.characterList.get(ui.selectCharacter()));
					}
					else if(userChoice == 2) { //Merge Characters
						sm.merge(sm.characterList.get(ui.selectCharacter()), sm.characterList.get(ui.selectCharacter()), 
								 sm.characterList.get(ui.selectCharacter()));
					}
					else if(userChoice == 3) { //Equip Weapon to Character
						ui.headOfWeaponInfo();
						for(int i = 0; i < sm.weaponList.size() ; i++)
							ui.displayWeaponInfo(sm.weaponList.get(i), i);
						
						sm.equipWeapon(sm.characterList.get(ui.selectCharacter()), sm.weaponList.get(ui.selectWeapon()));
					}
				}while(userChoice != 4);
			}
				
			else if(userChoice == 2) {
				do{
					userChoice = 2;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getTotalResources());
					
					ui.headOfWeaponInfo();
					for(int i = 0; i < sm.weaponList.size() ; i++)
						ui.displayWeaponInfo(sm.weaponList.get(i), i);
					
					userChoice = ui.showWeaponMenu();
					//System Managers for showAllWeapons
				}while(userChoice != 4);
			}
			
			else if(userChoice == 3) {
				do{
					userChoice = 3;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getTotalResources());
					userChoice = ui.showMaps();
					//System Managers for showMaps
					if(userChoice == 1) { //Start Adventure
						
						ui.headOfMapInfo();
						for(int i = 0; i < sm.defaultMapList.size(); i++)
							ui.displayMapInfo(sm.defaultMapList.get(i), i);
						int mapIndex = ui.selectMap();
						userChoice = ui.howManyCharacter();
								
						if(userChoice == 1) { //One Character Adventure
							ui.headOfCharacterInfo();
							for(int i = 0; i < sm.characterList.size(); i++)
								ui.displayCharacterInfo(sm.characterList.get(i), i);
									
							sm.startAdventure(sm.characterList.get(ui.selectCharacter()), 
											  sm.defaultMapList.get(mapIndex));
						}
						else if(userChoice == 2) { //Two Characters Adventure
							ui.headOfCharacterInfo();
							for(int i = 0; i < sm.characterList.size(); i++)
								ui.displayCharacterInfo(sm.characterList.get(i), i);
									
							sm.startAdventure(sm.characterList.get(ui.selectCharacter()), 
											  sm.characterList.get(ui.selectCharacter()), 
											  sm.defaultMapList.get(mapIndex));
						}
										
					}
					userChoice = 0;
				}while(userChoice != 2);
			}
			
			else if(userChoice == 4) {
				do {
					userChoice = 4;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getTotalResources());
					userChoice = ui.showGachaMachine();
					//System Managers for showGachaMachine
					if(userChoice == 1) { //Pull One Character
						if(sm.getTotalResources() >= 300) {
							sm.addNewCharacter(gc.pullChar());
							sm.setTotalResources(sm.getTotalResources() - 300);
						}
						else System.out.println("Not enough resouces");
					}
					else if(userChoice == 2) { //Pull Ten Characters
						if(sm.getTotalResources() >= 2700) {
							for(int i = 0; i < 10; i++)
								sm.addNewCharacter(gc.pullChar());
							sm.setTotalResources(sm.getTotalResources() - 2700);
						}
						else System.out.println("Not enough resources");
					}
					else if(userChoice == 3) { //Pull One Weapon
						if(sm.getTotalResources() >= 300) {
							sm.addNewWeapon(gc.pullWeapon());
							sm.setTotalResources(sm.getTotalResources() - 300);
						}
						else System.out.println("Not enough resources");
					}
					else if(userChoice == 4) { //Pull Ten Weapons
						if(sm.getTotalResources() >= 2700) {
							for(int i = 0; i < 10; i++)
								sm.addNewWeapon(gc.pullWeapon());
							sm.setTotalResources(sm.getTotalResources() - 2700);
						}
						else System.out.println("Not enough resources");
					}
				}while(userChoice != 5);	
				userChoice = 0;
			}
		}
		
		ui.exitProgram();
	}
}