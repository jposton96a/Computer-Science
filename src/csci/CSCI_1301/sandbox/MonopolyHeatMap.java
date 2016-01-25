package csci.CSCI_1301.sandbox;

import java.util.Arrays;

/**
 * Created by Jacob on 1/17/2016.
 */
public class MonopolyHeatMap {

    public static void main(String[] args){

        int players = 4;
        int totalRuns = 5000000;
        int[] boardPlaces = new int[40];
        int[] playerLocation = new int[players];

        for(int plays = 0; plays < totalRuns; plays++) {
            for (int i = 0; i < players; i++) {
                int roll = diceRoll();
                playerLocation[i] += roll;
                playerLocation[i] = playerLocation[i] % 40;
                boardPlaces[playerLocation[i]] += 1;
            }
        }

        float[] placePercentages = new float[boardPlaces.length];
        for(int i = 0; i < boardPlaces.length; i++)
        {
            placePercentages[i] = (float)boardPlaces[i]/((float)totalRuns/40f);
        }
        System.out.println(Arrays.toString(boardPlaces));
        System.out.println(Arrays.toString(placePercentages));

    }

    public static int diceRoll(){
        int roll1 = 1 + (int)(Math.random()*6);
        int roll2 = 1 + (int)(Math.random()*6);
        return roll1 + roll2;
    }
}
