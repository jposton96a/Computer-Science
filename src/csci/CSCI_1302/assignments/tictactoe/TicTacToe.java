package csci.CSCI_1302.assignments.tictactoe;

import java.util.Scanner;

/**
 * Created by jposton on 8/15/16.
 */
public class TicTacToe {

    // First turn is player X
    // Second turn is player O

    private int[] board; // Board is a 1d array which is 9 elements long
    private int turnNumber; // Used to evaluate when game end and player turn
    private boolean gameover; // Controls the main while loop

    private Scanner consoleInput;

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

        consoleInput = new Scanner(System.in);
    }

    public void run(){

        while(!gameover) {
            int intChoice = -1;

            System.out.println("--------------------------------------------------------------");
            System.out.println("Current Board:");
            this.printBoard();

            do {
                System.out.printf("\nPlayer %d's turn.\n", turnNumber % 2 + 1);
                System.out.print("Please enter the index of the square you would like to play: ");

                // Get the players choice and try to convert it to an integer
                String playerChoice = consoleInput.nextLine();
                try {
                    intChoice = Integer.parseInt(playerChoice);
                } catch (NumberFormatException e) {
                    System.err.printf("Your choice \"%s\" could not be converted to an integer." +
                            "Please enter a single digit from 0 to 8", playerChoice);
                }
            } while(!this.play(intChoice));
        }
        this.printBoard();
    }

    /**
     * Attempts to place the player's marker at the position number indicated
     * by the intChoice parameter. If the operation is successful, the method
     * returns true. If the operation was unsuccessful, the method returns
     * false and does not place the marker or increment the turn count.
     *
     * @param  intChoice  an integer representing the cell a user would like to place his marker
     * @return      a boolean indicating whether or not the play was successful
     */
    public boolean play(int intChoice){

        if(isValidChoice(intChoice)){

            // Set the chosen position to the current player's ID and check for a win
            this.board[intChoice] = turnNumber % 2;
            int winningPlayer = getWinningPlayer(intChoice);

            // Determine how the game should continue based on the result of getWinningPlayer()
            switch(winningPlayer){

                // -1 indicates that a win was not detected
                case -1:
                    turnNumber++;
                    break;

                // 3 indicates the that board is full, but a win was not detected (tie game)
                case 3:
                    gameover = true;
                    System.out.println("Game Tie! Nobody Wins.");
                    break;

                // Any other result indicates that the game was won by either player 1 or 2
                default:
                    gameover = true;
                    System.out.printf("Congratulations! Player %d wins!\n", winningPlayer+1);
            }

            // Return that the operation was successful
            return true;
        }

        // If the method gets to this point, the chosen position was not valid
        System.err.printf("Your choice \"%s\" is not valid. Please enter a number from 0 to 8 and " +
                    "make sure the spot is EMPTY", intChoice);
        return false;
    }

    /**
     * Checks the possible directions a player could win based on their last play.
     * First determines if the move could be included in a diagonal win, and checks
     * the diagonals if needed. Then, it checks the row and column of the last play for
     * horizontal and vertical wins.
     *
     * @param  lastPlayPos  an integer representing the cell where the last move was placed
     * @return      an integer indicating the outcomes of the game.
     *                  0 or 1 represents the player ID of the winner
     *                  3 for a tie game
     *                  -1 if the game is not over
     */
    public int getWinningPlayer(int lastPlayPos){

        // If the move is included in either diagonal, check for each diagonal win
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
            for(int i = 2; i <= 6; i += 2){
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
        int firstOfRow = (int)(lastPlayPos/3)*3; // Takes advantage of truncation to round to lowest multiple of 3
        for(int i = 0; i < 3; i++){
            if(board[firstOfRow + i] != winningPlayer){
                winningPlayer = -1;
                break;
            }
        }
        if(winningPlayer != -1)
            return winningPlayer;

        // If the turnNumber is at or over 8, all the cells on the board are full
        if(turnNumber >= 8)
            return 3;

        return -1;
    }

    /**
     * Returns whether or not a desired cell is a valid move. The method verifies that the
     * integer provided is within the constraints of the board size and checks to make sure
     * the position is not already taken.
     *
     * @param  intChoice  An integer representing the desired cell position to verify
     * @return            A boolean describing if the position is valid or not
     */
    public boolean isValidChoice(int intChoice){

        if(intChoice != -1){ // Check that the user input was stored in the intChoice variable (-1 = unset)

            return intChoice < board.length // check that the choice is less than max
                    && intChoice >= 0 // check that choice is greater than min
                    && this.board[intChoice] == -1; // check that place is not taken
        }
        return false;
    }

    /**
     * Prints the board to the terminal in a user-friendly format
     */
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
