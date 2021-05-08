
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
						ui.displayCharacterInfo(sm.characterList.get(i));
					
					userChoice = ui.showCharacterMenu();
					
					//System Managers for showAllCharacters
					if(userChoice == 1) { //Level Up Characters
						
					}
					else if(userChoice == 2) { //Merge Characters
						
					}
					else if(userChoice == 3) { //Equip Weapon to Character
						
					}
				}while(userChoice != 4);
			}
				
			else if(userChoice == 2) {
				do{
					userChoice = 2;
					ui.showMenuTitle(userChoice);
					System.out.println("Total Resources: " + sm.getTotalResources());
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