package csci.CSCI_1301.sandbox.neural_network.tictactoe;

import csci.CSCI_1301.sandbox.neural_network.tictactoe.players.Human;

/**
 * Created by jposton on 1/28/16.
 */
public class Game {
    boolean gameover = false;
    Player p1;
    Player p2;
    Board board;

    public Game(Player playerOne, Player playerTwo)
    {
        this.p1 = playerOne;
        this.p2 = playerTwo;
        this.board = new Board();
    }

    public void run(){
        while (!gameover){
            System.out.println(board.toString());
            board.play(p1.getMove(board), 'O');
            if(checkGameover()) break;

            System.out.println(board.toString());
            board.play(p2.getMove(board), 'X');
            if(checkGameover()) break;
        }
    }

    public boolean checkGameover(){
        if(board.getMovesMatching(' ').length == 0)
            gameover = true;
        if(board.getWinner() != ' ')
            gameover = true;

        return this.gameover;
    }

    public static void main(String[] args){
        Player player1 = new Human();
        Player player2 = new Human();
        Game g = new Game(player1, player2);
        g.run();
    }
}
