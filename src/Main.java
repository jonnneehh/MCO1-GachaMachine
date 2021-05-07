
public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		SystemManager sm = new SystemManager();
		
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
					//System Manages for showGachaMachine
				}while(userChoice != 5);	
				userChoice = 0;
			}
		}
		
		ui.exitProgram();
	}
}