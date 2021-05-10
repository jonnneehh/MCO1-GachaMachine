
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
			System.out.println("Total Resources: " + sm.getR().getAmount());
			userChoice = ui.showMainMenu();
						
			if(userChoice == 1) {
				do{
					userChoice = 1;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getR().getAmount());
					
					ui.displayAllCharacters(sm.characterList);
					
					userChoice = ui.showCharacterMenu();
					
					//System Managers for showAllCharacters
					if(userChoice == 1) { //Level Up Characters
						int characterSelected;
						
						do {
							characterSelected = ui.selectCharacter();
						}while(characterSelected >= sm.characterList.size() || characterSelected < 0);
						
						sm.levelUp(sm.characterList.get(characterSelected));
					}
					else if(userChoice == 2) { //Merge Characters
						sm.merge(sm.characterList.get(ui.selectCharacter()), sm.characterList.get(ui.selectCharacter()), 
								 sm.characterList.get(ui.selectCharacter()));
					}
					else if(userChoice == 3) { //Equip Weapon to Character
						int CharacterSelected = ui.selectCharacter();
						
						ui.displayAllWeapons(sm.weaponList);
						
						sm.equipWeapon(sm.characterList.get(CharacterSelected), sm.weaponList.get(ui.selectWeapon()));
					}
				}while(userChoice != 4);
			}
				
			else if(userChoice == 2) {
				do{
					userChoice = 2;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getR().getAmount());
					
					ui.displayAllWeapons(sm.weaponList);
					
					userChoice = ui.showWeaponMenu();
					//System Managers for showAllWeapons
					if(userChoice == 1) { //Level up Weapon
						sm.levelUp(sm.weaponList.get(ui.selectWeapon()));
					}
					else if(userChoice == 2) { //Merge Weapons
						sm.merge(sm.weaponList.get(ui.selectWeapon()), sm.weaponList.get(ui.selectWeapon()), 
								 sm.weaponList.get(ui.selectWeapon()));
					}
					else if (userChoice == 3){ //Equip Weapon to Character
						int WeaponSelected = ui.selectWeapon();
						
						ui.displayAllCharacters(sm.characterList);
						
						sm.equipWeapon(sm.characterList.get(ui.selectCharacter()), sm.weaponList.get(WeaponSelected));
					}
				}while(userChoice != 4);
			}
			
			else if(userChoice == 3) {
				do{
					userChoice = 3;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getR().getAmount());
					userChoice = ui.showMaps();
					//System Managers for showMaps
					if(userChoice == 1) { //Start Adventure
						
						ui.displayAllMaps(sm.defaultMapList);
						int mapIndex = ui.selectMap();
						userChoice = ui.howManyCharacter();
								
						if(userChoice == 1) { //One Character Adventure
							ui.displayAllCharacters(sm.characterList);
									
							sm.startAdventure(sm.characterList.get(ui.selectCharacter()), 
											  sm.defaultMapList.get(mapIndex));
						}
						else if(userChoice == 2) { //Two Characters Adventure
							ui.displayAllCharacters(sm.characterList);
							
							int characterSelected1 = ui.selectCharacter();
							int characterSelected2;
							
							do{
								characterSelected2 = ui.selectCharacter();
							}while(characterSelected2 == characterSelected1);
							
							sm.startAdventure(sm.characterList.get(characterSelected1), 
											  sm.characterList.get(characterSelected2), 
											  sm.defaultMapList.get(mapIndex));
						}
						userChoice = 0;
					}
				}while(userChoice != 2);
			}
			
			else if(userChoice == 4) {
				do {
					userChoice = 4;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getR().getAmount());
					userChoice = ui.showGachaMachine();
					//System Managers for showGachaMachine
					if(userChoice == 1) { //Pull One Character
						if(sm.getR().getAmount() >= 300) {
							sm.addNewCharacter(gc.pullChar());
							sm.getR().setAmount(sm.getR().getAmount() - 300);
						}
						else System.out.println("Not enough resouces");
					}
					else if(userChoice == 2) { //Pull Ten Characters
						if(sm.getR().getAmount() >= 2700) {
							for(int i = 0; i < 10; i++)
								sm.addNewCharacter(gc.pullChar());
							sm.getR().setAmount(sm.getR().getAmount() - 2700);
						}
						else System.out.println("Not enough resources");
					}
					else if(userChoice == 3) { //Pull One Weapon
						if(sm.getR().getAmount() >= 300) {
							sm.addNewWeapon(gc.pullWeapon());
							sm.getR().setAmount(sm.getR().getAmount() - 300);
						}
						else System.out.println("Not enough resources");
					}
					else if(userChoice == 4) { //Pull Ten Weapons
						if(sm.getR().getAmount() >= 2700) {
							for(int i = 0; i < 10; i++)
								sm.addNewWeapon(gc.pullWeapon());
							sm.getR().setAmount(sm.getR().getAmount() - 2700);
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