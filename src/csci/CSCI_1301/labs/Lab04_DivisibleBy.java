package csci.CSCI_1301.labs;

import java.util.Scanner;

/**
 * Created by jposton on 2/5/16.
 */
public class Lab04_DivisibleBy {

    private static int divisorOne = 5;
    private static int divisorTwo = 6;

    public static void main(String[] args){
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        /*
        // Prompt the user to enter a radius
        System.out.print("Enter a dividend: ");
        int dividend = input.nextInt();
        */

        for(int i = 0; i < 100; i++)
            checkDivisibility(i);
    }

    public static void checkDivisibility(int dividend){
        // Calculate Remainders
        int remainderOne = dividend % divisorOne;
        int remainderTwo = dividend % divisorTwo;

        // Print statement based on divisibility
        if(remainderOne == 0 && remainderTwo == 0){
            System.out.printf("%d is divisible by both %d and %d.\n",
                    dividend, divisorOne, divisorTwo);
        }
        else if(remainderOne == 0){
            System.out.printf("%d is divisible by %d but not %d.\n",
                    dividend, divisorOne, divisorTwo);
        }
        else if(remainderTwo == 0){
            System.out.printf("%d is divisible by %d but not %d.\n",
                    dividend, divisorTwo, divisorOne);
        }
        else{
            System.out.printf("%d is divisible by neither %d nor %d.\n",
                    dividend, divisorOne, divisorTwo);
        }
    }
}
