package csci.CSCI_1301.sandbox.machine_learning.tictactoe;

import java.util.Map;

/**
 * Created by jposton on 1/28/16.
 */
public class Board {
    private char[] table;
    private int lastMove;

    public Board(){
        table = new char[9];
        for(int i = 0; i < table.length; i++){
            table[i] = ' ';
        }
    }

    public void play(int move, char symbol){
        table[move] = symbol;
        lastMove = move;
    }

    public char getWinner(){

        int row = (int)(lastMove / 3);
        int col = lastMove % 3;

        boolean onDiagonal = (row == col) || (Math.abs(row - col) == 2);
        boolean HorizontalWin = true, VerticalWin = true;
        boolean DiagonalWinOne = true, DiagonalWinTwo = true;

        char winningPlayer = table[lastMove];
        for(int i = 0; i < 3; i++) {
            if(table[row * 3 + i] != winningPlayer)
                HorizontalWin = false;
            if(table[i * 3 + col] != winningPlayer)
                VerticalWin = false;
        }

        if(onDiagonal){
            // Check the diagonals
            for(int i = 0; i < 3; i++){
                if(table[i * 3 + i] != winningPlayer)
                    DiagonalWinOne = false;
                if(table[i * 3 + (2-i)] != winningPlayer)
                    DiagonalWinTwo = false;
            }
        }
        else{
            DiagonalWinOne = false;
            DiagonalWinTwo = false;
        }

        if(HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo)
            return winningPlayer;

        return ' ';
    }

    public int[] getMovesMatching(char play){
        int moveCount = 0;
        for(int cell : table)
            if(cell == play)
                moveCount++;

        int moveIndex = 0;
        int[] availableMoves = new int[moveCount];

        for(int i = 0; i < table.length; i++){
            if(table[i] == play) {
                availableMoves[moveIndex] = i;
                moveIndex++;
            }
        }
        return availableMoves;
    }

    public boolean isAvailable(int moveNum){
        return table[moveNum] == ' ';
    }

    public String toString(){
        StringBuilder stringTable = new StringBuilder();
        //stringTable.append("+---+---+---+\n");
        for(int i = 0; i < table.length; i+=3){
            stringTable.append(String.format(" %s | %s | %s \n", table[i], table[i+1], table[i+2]));
            if(i != 6)
                stringTable.append("-----------\n");
        }
        //stringTable.append("+---+---+---+\n");
        return stringTable.toString();
    }
}
