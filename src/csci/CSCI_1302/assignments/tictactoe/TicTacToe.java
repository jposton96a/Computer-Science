package csci.CSCI_1302.assignments.tictactoe;

import java.util.Scanner;

/**
 * Tic Tac Toe
 * Created by jposton on 8/15/16.
 */
public class TicTacToe {

    // Describes the size of the board
    private static final int ROW_COUNT = 3;

    private static final int UNSET_VALUE = -1;
    private static final int GAME_RESULT_TIE = 3;

    private static final int PLAYER_ONE_ID = 0;
    private static final int PLAYER_TWO_ID = 1;

    // First turn is player X
    // Second turn is player O

    private int[] board; // Board is a 1d array to hold the players markers
    private int turnNumber; // Used to evaluate game end and player's turn
    private boolean gameover; // Controls the main while loop

    private Scanner consoleInput; // Scanner for user input through the console

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        t.run();
    }

    /**
     * Tic Tac Toe Constructor
     * Initializes the board and scanner. Then sets all variables to their starting values.
     */
    public TicTacToe(){
        board = new int[ROW_COUNT*ROW_COUNT];
        consoleInput = new Scanner(System.in);

        turnNumber = 0;
        gameover = false;

        for (int i = 0; i < board.length; i++)
            board[i] = UNSET_VALUE;
    }

    /**
     * Main game loop that gets input from user, and attempts to make the move based
     * on the user's choice.
     */
    public void run(){

        while(!gameover) {
            int intChoice = UNSET_VALUE;

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

                // UNSET_VALUE (-1) indicates that a win was not detected
                case UNSET_VALUE:
                    turnNumber++;
                    break;

                // GAME_RESULT_TIE (3) indicates the that board is full, but a win was not detected (tie game)
                case GAME_RESULT_TIE:
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
                    "make sure the spot is EMPTY\n", intChoice);

        // Return operation was not successful
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
        // All cells included in diagonal are always a multiple of ROW_COUNT+1 or ROW_COUNT-1
        if(lastPlayPos % (ROW_COUNT+1) == 0 || lastPlayPos % (ROW_COUNT-1) == 0){

            // Check L->R Diagonal
            int winningPlayer = board[lastPlayPos];
            for(int i = 0; i < board.length; i += (ROW_COUNT+1)){
                if(board[i] != winningPlayer){
                    winningPlayer = UNSET_VALUE;
                    break;
                }
            }

            if(winningPlayer != UNSET_VALUE)
                return winningPlayer;

            // Check R->L Diagonal
            winningPlayer = board[lastPlayPos];
            for(int i = ROW_COUNT-1; i <= ROW_COUNT*(ROW_COUNT-1); i += (ROW_COUNT-1)){
                if(board[i] != winningPlayer){
                    winningPlayer = UNSET_VALUE;
                    break;
                }
            }

            if(winningPlayer != UNSET_VALUE)
                return winningPlayer;
        }

        // Check Vertical Wins
        int winningPlayer = board[lastPlayPos];
        // Find the start of the column and check consecutive vertical cells for a column
        int firstOfColumn = lastPlayPos % ROW_COUNT; //
        for(int i = firstOfColumn; i < board.length; i+=ROW_COUNT){
            if(board[i] != winningPlayer){
                winningPlayer = UNSET_VALUE;
                break;
            }
        }
        if(winningPlayer != UNSET_VALUE)
            return winningPlayer;

        // Check Horizontal Wins
        winningPlayer = board[lastPlayPos];
        // Find the start of the row and check consecutive cells for a full row
        int firstOfRow = (int)(lastPlayPos/ROW_COUNT)*ROW_COUNT; // Takes advantage of truncation to round to lowest multiple of ROW_COUNT
        for(int i = 0; i < ROW_COUNT; i++){
            if(board[firstOfRow + i] != winningPlayer){
                winningPlayer = UNSET_VALUE;
                break;
            }
        }
        if(winningPlayer != UNSET_VALUE)
            return winningPlayer;

        // If the turnNumber is at or over 8, all the cells on the board are full
        if(turnNumber >= board.length-1)
            return GAME_RESULT_TIE;

        return UNSET_VALUE;
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
        return intChoice != UNSET_VALUE // check that the user input was stored in the intChoice variable (-1 = unset)
                && intChoice < board.length // check that the choice is less than max
                && intChoice >= 0 // check that choice is greater than min
                && this.board[intChoice] == UNSET_VALUE; // check that place is not taken
    }

    /**
     * Prints the board to the terminal in a user-friendly format
     */
    public void printBoard(){
        StringBuilder separatorLine = new StringBuilder();
        for(int x = 0; x < ROW_COUNT; x++) {
            if(x != 0)
                separatorLine.append("+");
            separatorLine.append("---");
        }

        for(int i = 0; i < board.length; i+=ROW_COUNT){

            // Print the separating bar after the first row
            if(i != 0)
                System.out.println(separatorLine.toString());

            for(int j = 0; j < ROW_COUNT; j++) {
                char c;
                switch (board[i + j]){
                    case PLAYER_ONE_ID:
                        c = 'X';
                        break;
                    case PLAYER_TWO_ID:
                        c = 'O';
                        break;
                    default:
                        c = ' ';
                        break;
                }

                // Print the '|' after the first column
                if(j != 0)
                    System.out.print("|");

                System.out.printf(" %c ", c);
            }

            System.out.println();
        }
    }
}
