/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrymanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author SƠNPC
 */
public class ManageEastAsiaCountries {


    private List<EastAsiaCountries> listCountry;

    private void addmockCountrytoList() {
        listCountry.add(new EastAsiaCountries("BRN", "Brunei", 122131, "Mostly mountain"));
        listCountry.add(new EastAsiaCountries("LS", "Laos", 121321312, "Poor"));
        listCountry.add(new EastAsiaCountries("CAM", "Cambodia", 145463, "very poor"));
        listCountry.add(new EastAsiaCountries("IND", "Indonesia", 215352, "Island country"));
        listCountry.add(new EastAsiaCountries("MAS", "Malaysia", 1241131, "Upin Ipin"));
        listCountry.add(new EastAsiaCountries("SPR", "Singapore", 1232421, "Rich"));
        listCountry.add(new EastAsiaCountries("MYA", "Myanmar", 124432, "great"));
        listCountry.add(new EastAsiaCountries("TML", "TimorLeste", 1232421, "TML"));
    }

    public ManageEastAsiaCountries() {
        listCountry = new ArrayList<>();
        addmockCountrytoList();
    }

    void addCountryInformation() {
        int numberOfCountryInput = 8;
        //Loop until the number of countries reaches 11
        while (numberOfCountryInput < 11) {
            String code = "";
            while (true) {
                //Input country code that must be uppercase characters only
                code = GetInput.getString("Enter code of country:",
                        "Country code must be uppercase characters!", "^[A-Z]+$");
                //Check if the code has existed
                if (checkDuplicateCode(code)) {
                    System.out.println("Code existed, Please enter another Code");
                } else {
                    break;
                }
            }
            //Input country name that must be characters only 
            //(both uppercase and lowercase)
            String name = GetInput.getString("Enter name of country:",
                    "Country name must be characters!", "^[a-zA-Z ]+$");

            //Input total area of country that must be a float
            float totalArea = GetInput.getFloat("Enter total Area: ",
                    "Total area must be a float!", 0f, Float.MAX_VALUE);

            //Input terrain of country that must be characters only 
            //(both uppercase and lowercase)
            String terrain = GetInput.getString("Enter terrain of country:",
                    "Terrain must be characters!", "^[a-zA-Z ]+$");
            
            EastAsiaCountries country = new EastAsiaCountries(code, name,
                    totalArea, terrain);

            listCountry.add(country);

            numberOfCountryInput++;
        }
        System.out.println("The number of countries input has reached 11!");
    }

    private boolean checkDuplicateCode(String code) {
        //Traverse all elements of the list 
        for (EastAsiaCountries country : listCountry) {
            //Check if there is a code similar to the previous input code
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    void getRecentlyEnteredInformation() {
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries country : listCountry) {
            country.display();
        }
    }

    public void searchInformationByName() {
        if (listCountry.isEmpty() == false) {
            //Input the name of the country user want to search for
            //country name must be characters(both uppercase and lowercase)
            String CountryName = GetInput.getString(
                    "Enter the name of the country you want to search: ",
                    "Country name must be characters!", "^[a-zA-Z ]+$");

            boolean found = false;

            //Traverse all elements of the list
            for (EastAsiaCountries country : listCountry) {

                //Check if the country name the user input 
                //matches any country name in list
                if (country.getCountryName().contains(CountryName)) {

                    System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name",
                            "Total Area", "Terrain");
                    country.display();
                    found = true;
                }
            }
            if (found == false) {
                System.out.println(
                "There is no matching country! Please search for another available country.");
            }
        } else {
            //If list is empty, send a message to notify user
            System.out.println("List is empty. Cannot perform a search!");
        }

    }

    void sortInformationByAscendingOrder() {
        Collections.sort(listCountry, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
                return c1.getCountryName().compareToIgnoreCase(c2.getCountryName());
            }
        });
        getRecentlyEnteredInformation();
    }
}
