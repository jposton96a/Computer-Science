package csci.CSCI_1302.assignments.tictactoe;

import java.util.Scanner;

/**
 * Created by jposton on 8/15/16.
 */
public class TicTacToe {

    // First turn is player X
    // Seconds turn is player O
    int[] board;
    int turnNumber;
    boolean gameover;

    Scanner consoleInput = new Scanner(System.in);

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        t.run();
    }

    public TicTacToe(){
        board = new int[9];
        turnNumber = 0;
        gameover = false;

        for (int i = 0; i < board.length; i++)
            board[i] = -1;
    }

    public void run(){
        int winningPlayer = -1;

        while(!gameover) {
            int intChoice = -1;

            System.out.println("--------------------------------------------------------------");
            System.out.println("Current Board:");
            this.printBoard();

            while(!isValidChoice(intChoice)) {
                System.out.printf("\nPlayer %d's turn.\n", turnNumber % 2 + 1);
                System.out.print("Please enter the index of the square you would like to play: ");

                String playerChoice = consoleInput.nextLine();
                try {
                    intChoice = Integer.parseInt(playerChoice);
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                }

                if(!isValidChoice(intChoice))
                    System.err.printf("Your choice \"%s\" is not valid. Please enter a number from 0 to 8 and " +
                            "make sure the spot is EMPTY", playerChoice);
            }
            board[intChoice] = turnNumber % 2;

            winningPlayer = getWinningPlayer(intChoice);

            if (winningPlayer == -1) {
                turnNumber++;

                if (turnNumber > 10)
                    gameover = true;
            }
            else
                gameover = true;
        }
        System.out.printf("Congratulations! Player %d wins!\n", winningPlayer + 1);
        this.printBoard();
    }

    public int getWinningPlayer(int lastPlayPos){

        if(lastPlayPos % 2 == 0){
            // Check L->R Diagonal
            int winningPlayer = board[lastPlayPos];
            for(int i = 0; i < 9; i += 4){
                if(board[i] != winningPlayer){
                    winningPlayer = -1;
                    break;
                }
            }

            if(winningPlayer != -1)
                return winningPlayer;

            // Check R->L Diagonal
            winningPlayer = board[lastPlayPos];
            for(int i = 2; i < 9; i += 2){
                if(board[i] != winningPlayer){
                    winningPlayer = -1;
                    break;
                }
            }

            if(winningPlayer != -1)
                return winningPlayer;
        }

        // Check Vertical Wins
        int winningPlayer = board[lastPlayPos];
        for(int i = lastPlayPos%3; i < 9; i+=3){
            if(board[i] != winningPlayer){
                winningPlayer = -1;
                break;
            }
        }
        if(winningPlayer != -1)
            return winningPlayer;

        // Check Horizontal Wins
        winningPlayer = board[lastPlayPos];
        int firstOfRow = (int)(lastPlayPos/3)*3;
        for(int i = 0; i < 3; i++){
            if(board[firstOfRow + i] != winningPlayer){
                winningPlayer = -1;
                break;
            }
        }
        if(winningPlayer != -1)
            return winningPlayer;

        return -1;
    }

    public boolean isValidChoice(int intChoice){

        if(intChoice != -1){ // Check that the user input was stored in the intChoice variable (-1 = unset)

            return intChoice < board.length // check that the choice is less than max
                    && intChoice >= 0 // check that choice is greater than min
                    && this.board[intChoice] == -1; // check that place is not taken
        }
        return false;
    }

    public void printBoard(){
        for(int i = 0; i < 9; i+=3){
            if(i != 0)
                System.out.println("---+---+---");

            for(int j = 0; j < 3; j++) {
                char c;
                switch (board[i + j]){
                    case 0:
                        c = 'X';
                        break;
                    case 1:
                        c = 'O';
                        break;
                    default:
                        c = ' ';
                        break;
                }

                if(j != 0)
                    System.out.print("|");

                System.out.printf(" %c ", c);
            }

            System.out.println();
        }
    }
}
