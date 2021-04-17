
public class Main {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		int userChoice = 0;
		
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
				}while(userChoice != 2);
				userChoice = 0;
			}
			
			else if(userChoice == 4) {
				do {
					userChoice = ui.showGachaMachine();
				}while(userChoice != 5);	
				userChoice = 0;
			}
		}
		
		ui.exitProgram();
	}
}