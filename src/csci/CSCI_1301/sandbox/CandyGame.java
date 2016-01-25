package csci.CSCI_1301.sandbox;

import java.util.Scanner;

/**
 * Created by Jacob on 1/13/2016.
 */
public class CandyGame {
    private int basketCount = 21;
    private int minTake = 1;
    private int maxTake = 3;
    private boolean gameOver = false;

    public int calcAiTake(){
        int[] outcomes = new int[maxTake-minTake+1];

        for (int i = maxTake-minTake; i >= 0; i--){
            int take = minTake + i;
            int basketAfterTake = basketCount - take;
            if(basketAfterTake == 0)
                outcomes[i] = 2;
            else if(basketAfterTake >= minTake && basketAfterTake <= maxTake)
                outcomes[i] = 0;
            else
                outcomes[i] = 1;
        }

        int bestOutcome = getMax(outcomes);
        int bestMove = minTake + bestOutcome;

        return bestMove;
    }

    public void play(int playerTake){
        if(playerTake >= minTake && playerTake <= maxTake) {
            if(playerTake <= basketCount) {
                if (!gameOver)
                    takeFromBasket(playerTake, true);
                if (!gameOver)
                    takeFromBasket(calcAiTake(), false);
            }
            else{
                System.out.println("There are not that many candies in the basket!");
            }
        }
        else
            System.out.printf("Invalid number. Please choose a number between %d and %d", minTake, maxTake) ;
    }

    private void takeFromBasket(int take, boolean playerTurn){
        basketCount -= take;
        System.out.println(playerTurn ? "You took " + take + " from the basket" :
                                        "The candyman took " + take + " from the basket");
        System.out.println("Remaining total: " + basketCount);

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

    public int getMax(int[] list){
        int max = list[0];
        int minIndex = 0;

        for(int i = 0; i < list.length; i++)
            if(list[i] >= max) {
                max = list[i];
                minIndex = i;
            }

        return minIndex;
    }

    public boolean getGameOver(){
        return gameOver;
    }
    public int getMinTake(){
        return minTake;
    }
    public int getMaxTake(){
        return maxTake;
    }
    public int getBasketCount(){
        return basketCount;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        CandyGame cg = new CandyGame();

        System.out.printf("The basket starts with %d candies\n", cg.getBasketCount());
        while(!cg.getGameOver()){
            System.out.printf("How many candies do you want to take? [%d-%d]\n", cg.getMinTake(), cg.getMaxTake());
            cg.play(input.nextInt());
        }

        input.close();
    }
}
