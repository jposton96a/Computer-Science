package csci.CSCI_1301.sandbox.neural_network.tictactoe;

/**
 * Created by jposton on 1/28/16.
 */
public class Board {
    private char[] table;

    public Board(){
        table = new char[9];
        for(int i = 0; i < table.length; i++){
            table[i] = ' ';
        }
    }

    public void play(int move, char symbol){
        table[move] = symbol;
    }

    public char getWinner(){
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
