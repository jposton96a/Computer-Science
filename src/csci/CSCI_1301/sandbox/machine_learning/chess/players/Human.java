package csci.CSCI_1301.sandbox.machine_learning.chess.players;


import csci.CSCI_1301.sandbox.machine_learning.chess.Pieces;
import csci.CSCI_1301.sandbox.machine_learning.chess.Player;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by jposton on 2/10/16.
 */
public class Human implements Player {
    Pattern standardMove = Pattern.compile("^[a-h][0-7][a-h][0-7]");
    Scanner input = new Scanner(System.in);

    @Override
    public String getMove(char[][] board) {
        boolean validPlay = false;
        do {
            System.out.println("Please enter your move: ");
            String inputMove = input.nextLine();
            Matcher m = standardMove.matcher(inputMove);

            if (inputMove.equals("0-0") || m.find()) {
                validPlay = true;
                return inputMove;
            } else
                System.out.println("Invalid Move");
        } while (!validPlay);

        return null;
    }
}
