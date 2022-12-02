package countrymanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SONPC
 */
public class GetInput {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                //Check if the input number is in the provided range [min, max]
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("The input number must be in range [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static float getFloat(String msg, String err, float min, float max) {
        while (true) {
            try {
                System.out.println(msg);
                float num;
                num = Float.parseFloat(in.readLine());
                //Check if the input number is in the provided range [min, max]
                if (min < num && num < max) {
                    return num;
                } else {
                    System.out.println("The input number must be in range [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                //Check if the input matches the provided format
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }

}
