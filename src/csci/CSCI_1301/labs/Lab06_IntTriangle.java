package csci.CSCI_1301.labs;

import java.util.Scanner;

/**
 * Created by jposton on 2/19/16.
 */

public class Lab06_IntTriangle {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a number of lines: ");
        int lineCount = input.nextInt();   // Accept the number of lines to print from the user
        input.close();

        for(int i = lineCount; i >= 0; i--){ // Repeat the code for each line
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
    }
}
