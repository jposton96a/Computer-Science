package csci.CSCI_1301.sandbox.machine_learning.tictactoe;

import java.util.Arrays;

/**
 * Created by jposton on 2/1/16.
 */
public class Tournament {

    public Tournament(Player[] players){
        if(players.length > 2){
            Tournament t1 = new Tournament(Arrays.copyOfRange(players, 0, players.length/2-1));
            Tournament t2 = new Tournament(Arrays.copyOfRange(players, players.length/2, players.length));
        }
    }
}
