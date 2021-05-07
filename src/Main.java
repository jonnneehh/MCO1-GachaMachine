
public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		SystemManager sm = new SystemManager();
		GachaMachine gc = new GachaMachine();
		
		int userChoice = 0;
		
		ui.startProgram();
		sm.startProgram();
		
		while(userChoice != 5) {
			userChoice = ui.showMainMenu();
			
			if(userChoice == 1) {
				do{
					userChoice = ui.showAllCharacters();
					//System Managers for showAllCharacters
				}while(userChoice != 4);
				userChoice = 0;
			}
				
			else if(userChoice == 2) {
				do{
					userChoice = ui.showAllWeapons();
					//System Managers for showAllWeapons
				}while(userChoice != 4);
				userChoice = 0;
			}
			
			else if(userChoice == 3) {
				do{
					userChoice = ui.showMaps();
					//System Managers for showMaps
				}while(userChoice != 2);
				userChoice = 0;
			}
			
			else if(userChoice == 4) {
				do {
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