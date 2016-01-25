package csci.CSCI_1301.labs;

import java.util.Scanner;

/**
 * FootToMeter:
 * Simple class to convert from feet to meters
 * Created by Jacob on 1/22/2016.
 */
public class FootToMeter {
    private static final double CONVERSION_FACTOR = 0.305;

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        double foot = 3.1416;
        double meter = 0; // will store the converted value in meters

        System.out.print("Enter the length in feet: ");
        foot = userInput.nextDouble();
        meter = foot * FootToMeter.CONVERSION_FACTOR;

        System.out.printf("Imperial: %.5f ft\n", foot);
        System.out.printf("Metric:   %.5f m\n", meter);
    }
}
