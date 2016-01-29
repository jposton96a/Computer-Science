package csci.CSCI_1301.labs;

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by jposton on 1/29/16.
 */
public class Lab03_SwapVariables
{
    public static void main(String[] args)
    {
        System.out.println("+----------- Part 1 ------------+");
        part1();
        System.out.println("+----------- Part 2 ------------+");
        part2();
        System.out.println("+----------- Part 3 ------------+");
        part3();
    } // end of main

    public static void part1()
    {
        // Get the current year from the system calendar
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Declare variables to store input
        int aNumber;
        String aString;

        // Prompt the user for input and store the parsed value in an integer
        aString = JOptionPane.showInputDialog("Enter a number:");
        aNumber = Integer.parseInt ( aString );

        // Print the statement if the input is greater than or
        // equal to the current year
        if(aNumber >= currentYear)
            System.out.println(" you entered " + aNumber);
    }

    public static void part2(){
        // Prompt the user values for Num1 and Num2
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter number for Num1: "));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number for Num2: "));

        // Print the values before the swap
        System.out.printf("Num1: %d | Num2: %d\n", num1, num2);

        // Swap the two variables
        int temp = num1;
        num1 = num2;
        num2 = temp;

        // Print the swapped values
        System.out.printf("Num1: %d | Num2: %d\n", num1, num2);
    }

    public static void part3(){
        // Prompt the user values for Num1 and Num2
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter number for Num1: "));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter number for Num2: "));

        // Display the variables
        System.out.printf("num1 = %d, num2 = %d\n", num1, num2);

        // If the values are out of order, swap them
        if(num1 > num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Print the sorted values
        System.out.printf("The sorted numbers are %d, %d.", num1, num2);
    }

} // end of class Lab03_SwapVariables