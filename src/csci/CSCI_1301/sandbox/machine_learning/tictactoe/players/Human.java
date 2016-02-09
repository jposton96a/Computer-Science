package csci.CSCI_1301.sandbox.machine_learning.tictactoe.players;

import csci.CSCI_1301.sandbox.machine_learning.tictactoe.Board;
import csci.CSCI_1301.sandbox.machine_learning.tictactoe.Player;

import java.util.Scanner;

/**
 * Created by jposton on 1/28/16.
 */
public class Human implements Player {
    Scanner input = new Scanner(System.in);

    public int getMove(Board b){
        System.out.println("Enter your move: ");
        return input.nextInt();
    }
}
