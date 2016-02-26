package csci.CSCI_1301.labs;

/**
 * Lab 05 - Simple Iteration
 * Created by jposton on 2/12/16.
 */
public class Lab05_SimpleIteration {
    public static void main(String[] args){
        // Print the table head
        System.out.println("x\tx-squared\tx-cubed");
        System.out.println("--\t---------\t-------");

        // Iterate from 2 to 10, printing each integer, its square, and its cube
        for(int i = 2; i <= 10; i++)
            System.out.printf("%-2d \t %3d \t\t %4d\n", i, i*i, (int)Math.pow(i, 3));
    }
}
