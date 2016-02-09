package csci.CSCI_1301.sandbox.machine_learning.tictactoe.players;

import csci.CSCI_1301.sandbox.machine_learning.core.genetic.Genome;
import csci.CSCI_1301.sandbox.machine_learning.tictactoe.Board;
import csci.CSCI_1301.sandbox.machine_learning.tictactoe.Player;

/**
 * Created by jposton on 1/28/16.
 */
public class GeneticAI implements Player {

    private Genome genome;
    private int[] moves;

    public int turnsTaken = Integer.MAX_VALUE;

    int currentMove = 0;

    public GeneticAI(){
        this(new Genome(0, 9, 100));
    }

    public GeneticAI(Genome genome){
        this.genome = genome;
        float[] genes = genome.getSequence();

        moves = new int[genes.length];
        for(int i = 0; i < genes.length; i++)
            moves[i] = (int)genes[i];
    }

    public GeneticAI getOffspring(GeneticAI g1){
        Genome newGenome = genome.getOffspring(g1.getGenome());
        return new GeneticAI(newGenome);
    }

    public Genome getGenome(){
        return genome;
    }

    public int getMove(Board b){
        while (!b.isAvailable(moves[currentMove])){
            currentMove++;
            if(currentMove == moves.length)
                currentMove = 0;
        }
        return moves[currentMove];
    }
}
