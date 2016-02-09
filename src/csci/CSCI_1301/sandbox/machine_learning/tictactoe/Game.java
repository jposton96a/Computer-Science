package csci.CSCI_1301.sandbox.machine_learning.tictactoe;

import csci.CSCI_1301.sandbox.machine_learning.tictactoe.players.GeneticAI;
import csci.CSCI_1301.sandbox.machine_learning.tictactoe.players.Human;

import java.util.*;

/**
 * Created by jposton on 1/28/16.
 */
public class Game {
    boolean gameover = false;
    Player p1;
    Player p2;
    Board board;
    Player winner;
    char winnerChar;
    int turns = 0;

    public Game(Player playerOne, Player playerTwo)
    {
        this.p1 = playerOne;
        this.p2 = playerTwo;
        this.board = new Board();
    }

    public void run(){
        while (!gameover){
            //System.out.println(board.toString());
            board.play(p1.getMove(board), 'O');
            turns++;
            if(checkGameover()) break;

            //System.out.println(board.toString());
            board.play(p2.getMove(board), 'X');
            turns++;
            if(checkGameover()) break;
        }
        //System.out.println(board.toString());

        winnerChar = board.getWinner();
        switch (board.getWinner()){
            case 'O':
                winner = p1;
            case 'X':
                winner = p2;
            default:
                winner = null;
        }
    }

    public boolean checkGameover(){
        if(board.getMovesMatching(' ').length == 0)
            gameover = true;
        if(board.getWinner() != ' ')
            gameover = true;
        return this.gameover;
    }

    public static GeneticAI tournament(GeneticAI[] players){
        GeneticAI p1;
        GeneticAI p2;
        if(players.length == 2){
            p1 = players[0];
            p2 = players[1];
        }
        else if(players.length == 1){
            p1 = p2 = players[0];
        }
        else {
            p1 = tournament(Arrays.copyOfRange(players, 0, players.length/2));
            p2 = tournament(Arrays.copyOfRange(players, players.length/2, players.length));
        }
        Game g = new Game(p1, p2);
        g.run();
        return g.winnerChar == 'X' ? p2 : p1;
    }

    public static void main(String[] args){
        /*Player player1 = new GeneticAI();
        Player player2 = new GeneticAI();
        Game g = new Game(player1, player2);
        g.run();*/

        List<GeneticAI> population = new ArrayList<GeneticAI>();
        ArrayList<GeneticAI> winners = new ArrayList<>();
        GeneticAI mostFit = null;

        // Initialize the original population
        for(int i = 0; i < 100; i++)
            population.add(new GeneticAI());

        for(int generation = 0; generation < 10; generation++) {
            // Run the tournament 100 times for complete testing
            for (int i = 0; i < 100; i++) {
                GeneticAI winner = tournament(population.toArray(new GeneticAI[population.size()]));
                winners.add(winner);
                Collections.shuffle(population);
            }

            // Sort the winning population by number of turns taken to win
            Collections.sort(winners, new Comparator<GeneticAI>() {
                public int compare(GeneticAI p1, GeneticAI p2) {
                    return p1.turnsTaken - p2.turnsTaken; // The order depends on the direction of sorting.
                }
            });

            // Repopulate population
            population.clear();
            for (int i = 0; i < population.size() / 10; i++) {
                for (int j = 0; j < population.size() / 10; j++) {
                    population.add(winners.get(i).getOffspring(winners.get(j)));
                }
            }

            mostFit = winners.get(0);

            // Clear the winners for the next set
            winners.clear();
        }

        if(mostFit != null)
            System.out.println(Arrays.toString(mostFit.getGenome().getSequence()));


        /*
        for(int i = 0; i < population.length; i++)
            population[i] = new GeneticAI();

        for(int i = 0; i < population.length; i++){
            for(int j = 0; j < population.length; j++){
                Game g = new Game(population[i], population[j]);
                g.run();
                if(g.winnerChar != ' ')
                    winners.add(g.winnerChar == 'O' ?
                            population[i] :
                            population[j]);
            }
        }
        */
    }
}
