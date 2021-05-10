
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
					if(userChoice == 1 && sm.characterList.size() != 0) { //Level Up Characters
						int characterSelected = -1;
						
						characterSelected = sm.testChoiceCharacter(characterSelected);
						
						sm.levelUp(sm.characterList.get(characterSelected));
					}
					else if(userChoice == 2 && sm.characterList.size() >= 3) { //Merge Characters
						int characterSelected1 = -1;
						int characterSelected2 = -1;
						int characterSelected3 = -1;
						
						characterSelected1 = sm.testChoiceCharacter(characterSelected1);
						characterSelected2 = sm.testChoiceCharacter(characterSelected2);
						characterSelected3 = sm.testChoiceCharacter(characterSelected3);
						
						sm.merge(sm.characterList.get(characterSelected1), sm.characterList.get(characterSelected2), 
								 sm.characterList.get(characterSelected3));
					}
					else if(userChoice == 3 && sm.characterList.size() != 0 && sm.weaponList.size() != 0) { //Equip Weapon to Character
						int characterSelected = -1;
						int weaponSelected = -1;
						
						characterSelected = sm.testChoiceCharacter(characterSelected);
						
						ui.displayAllWeapons(sm.weaponList);
						
						weaponSelected = sm.testChoiceWeapon(weaponSelected);
						
						sm.equipWeapon(sm.characterList.get(characterSelected), sm.weaponList.get(weaponSelected));
						
						//ui.displayCharacterInfo(sm.characterList.get(characterSelected), characterSelected, true);
						//ui.displayCharacterInfo(sm.weaponList.get(sm.weaponList.indexOf(sm.characterList.get(characterSelected).getWeapon())).getCharacterOwner(), characterSelected, true);
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
					if(userChoice == 1 && sm.weaponList.size() != 0) { //Level up Weapon
						int weaponSelected = -1;
						
						weaponSelected = sm.testChoiceWeapon(weaponSelected);
						
						sm.levelUp(sm.weaponList.get(weaponSelected));
					}
					else if(userChoice == 2 && sm.weaponList.size() >= 3) { //Merge Weapons
						int weaponSelected1 = -1;
						int weaponSelected2 = -1;
						int weaponSelected3 = -1;
						
						weaponSelected1 = sm.testChoiceWeapon(weaponSelected1);
						weaponSelected2 = sm.testChoiceWeapon(weaponSelected2);
						weaponSelected3 = sm.testChoiceWeapon(weaponSelected3);
						
						/*
						System.out.println(weaponSelected2 + " and " + weaponSelected3);
						
						sm.unequipWeapon(sm.characterList.get(sm.characterList.indexOf(sm.weaponList.get(weaponSelected2).getCharacterOwner())), 
										 sm.weaponList.get(weaponSelected2));
						
						sm.unequipWeapon(sm.characterList.get(sm.characterList.indexOf(sm.weaponList.get(weaponSelected3).getCharacterOwner())), 
										 sm.weaponList.get(weaponSelected3));
						*/
						sm.merge(sm.weaponList.get(weaponSelected1), sm.weaponList.get(weaponSelected2), 
								 sm.weaponList.get(weaponSelected3));
						
					}
					else if (userChoice == 3 && sm.characterList.size() != 0 && sm.weaponList.size() != 0){ //Equip Weapon to Character
						int weaponSelected = -1;
						int characterSelected = -1;
						
						weaponSelected = sm.testChoiceWeapon(weaponSelected);
						
						ui.displayAllCharacters(sm.characterList);
						
						characterSelected = sm.testChoiceCharacter(characterSelected);
						
						sm.equipWeapon(sm.characterList.get(characterSelected), sm.weaponList.get(weaponSelected));
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
						int mapIndex;
						
						do {
							mapIndex  = ui.selectMap();
						}while(mapIndex >= sm.defaultMapList.size() || mapIndex < 0);
						
						userChoice = ui.howManyCharacter();
								
						if(userChoice == 1 && sm.characterList.size() >= 1) { //One Character Adventure
							int characterSelected = -1;
							ui.displayAllCharacters(sm.characterList);
							
							characterSelected = sm.testChoiceCharacter(characterSelected);
							
							sm.startAdventure(sm.characterList.get(characterSelected), 
											  sm.defaultMapList.get(mapIndex));
						}
						else if(userChoice == 2 && sm.characterList.size() >= 2) { //Two Characters Adventure
							ui.displayAllCharacters(sm.characterList);
							
							int characterSelected1 = -1;
							int characterSelected2 = -1;
							
							characterSelected1 = sm.testChoiceCharacter(characterSelected1);
							
							do{
								characterSelected2 = sm.testChoiceCharacter(characterSelected2);
							}while(characterSelected2 == characterSelected1);
							
							sm.startAdventure(sm.characterList.get(characterSelected1), 
											  sm.characterList.get(characterSelected2), 
											  sm.defaultMapList.get(mapIndex));
						}
						else System.out.println("\nAdventure failed. Not enough characters");
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