package csci.CSCI_1301.sandbox.machine_learning.chess;

import csci.CSCI_1301.sandbox.machine_learning.chess.players.Human;

/**
 * Created by jposton on 2/10/16.
 */
public class Game {
    static char[][] gameboard = new char[8][8];

    // Character arrays for storing a players captured pieces
    char[] p1Out = new char[16];
    char[] p2Out = new char[16];
    int p1OutIndex = 0;
    int p2OutIndex = 0;

    public static void main(String[] args){
        Game g = new Game();
        Human h = new Human();
        h.getMove(gameboard);
        System.out.println(g.toString());
    }

    public Game(){
        initBoard();
    }

    public void initBoard(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                gameboard[i][j] = '-';

        gameboard[0][0] = 'R';
        gameboard[0][1] = 'N';
        gameboard[0][2] = 'B';
        gameboard[0][3] = 'Q';
        gameboard[0][4] = 'K';
        gameboard[0][5] = 'B';
        gameboard[0][6] = 'N';
        gameboard[0][7] = 'R';

        for(int i = 0; i < 8; i++)
            gameboard[1][i] = 'P';

        gameboard[7][0] = 'r';
        gameboard[7][1] = 'n';
        gameboard[7][2] = 'b';
        gameboard[7][3] = 'q';
        gameboard[7][4] = 'k';
        gameboard[7][5] = 'b';
        gameboard[7][6] = 'n';
        gameboard[7][7] = 'r';

        for(int i = 0; i < 8; i++)
            gameboard[6][i] = 'p';
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();

        boardString.append("  abcdefgh  \n");
        for (int i = 0; i < 8; i++){
            boardString.append(i + " ");
            for (int j = 0; j < 8; j++){
                boardString.append(gameboard[i][j]);
            }
            boardString.append(" " + i + "\n");
        }
        boardString.append("  abcdefgh  \n");
        return boardString.toString();
    }
}