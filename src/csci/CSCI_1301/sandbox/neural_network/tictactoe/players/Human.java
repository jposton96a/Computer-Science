package csci.CSCI_1301.sandbox.neural_network.tictactoe.players;

import csci.CSCI_1301.sandbox.neural_network.tictactoe.Board;
import csci.CSCI_1301.sandbox.neural_network.tictactoe.Player;

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
