package csci.csci1301.sandbox;

import java.util.Scanner;

/**
 * Created by Jacob on 1/13/2016.
 */
public class CandyGame {
    int basketCount = 21;
    boolean gameOver = false;

    public int calcAiTake(){
        return 0;
    }

    public void play(int playerTake){
        int aiTake = calcAiTake();
        if(!gameOver)
            takeFromBasket(playerTake, true);
        if(!gameOver)
            takeFromBasket(aiTake, false);
    }

    private void takeFromBasket(int take, boolean playerTurn){
        basketCount -= take;
        if(basketCount <= 0)
            gameOver(playerTurn);
    }

    private void gameOver(boolean playerWin){
        gameOver = true;
        System.out.println("Game over.");
        if(playerWin)
            System.out.println("You took the last piece! You win!");
        else
            System.out.println("The candyman took the last piece! You lose :(");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

    }
}
