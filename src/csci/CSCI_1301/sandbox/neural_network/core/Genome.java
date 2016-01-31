package csci.CSCI_1301.sandbox.neural_network.core;

import java.util.Random;

/**
 * Created by jposton on 1/29/16.
 */
public class Genome {

    float[] genes;
    float min, max;

    public Genome(float min, float max){
        this(min, max, 10);
    }

    public Genome(float min, float max, int size){
        genes = new float[size];

        for(int i = 0; i < size; i++){
            genes[i] = min + (float)(Math.random() * (max-min));
        }
    }

    public void mutate(float mutationRate){
        for(int i = 0; i < genes.length; i++){
            if(Math.random() < mutationRate){
                genes[i] = min + (float)(Math.random() * (max-min));
            }
        }
    }

    public Genome getOffspring(Genome g1){
        if(this.getSize() == g1.getSize()) {
            float[] newGeneSeq = new float[g1.getSize()];
        }
        return null;
    }

    private double getGaussianRandom(float mean, float stdDeviation){
        Random r = new Random();
        return r.nextGaussian() * stdDeviation + mean;;

    }

    public float[] getSequence(){
        return this.genes;
    }

    public int getSize(){
        return genes.length;
    }
}
