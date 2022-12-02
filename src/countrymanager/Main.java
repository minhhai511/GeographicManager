/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrymanager;

/**
 *
 * @author SƠNPC
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();

        //Loop until user chooose to exit the program
        while (true) {
            //Display a menu and ask user to select an option
            displayMenu();
            int option = GetInput.getInt("Enter your option: ",
                    "The input must be an integer in range [1-5]", 1, 5);
            switch (option) {

                /*Option 1: input the information of 11 countries in East
                Asia (code, name, total area, terrain)*/
                case 1:
                    manager.addCountryInformation();
                    break;

                //Option 2: Display information of countries that have been input
                case 2:
                    manager.getRecentlyEnteredInformation();
                    break;

                //Option 3: Search information of countries by user-entered name
                case 3:
                    manager.searchInformationByName();
                    break;

                //Option 4: Display the information of countries sorted name in 
                //ascending order
                case 4:
                    manager.sortInformationByAscendingOrder();
                    break;

                //Option 5: Exit
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }

}
