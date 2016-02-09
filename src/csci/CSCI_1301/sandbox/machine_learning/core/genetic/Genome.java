package csci.CSCI_1301.sandbox.machine_learning.core.genetic;

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

    public Genome(float[] genes, float max, float min){
        this.genes = genes;
        this.max = max;
        this.min = min;
    }

    public void mutate(float mutationRate){
        for(int i = 0; i < genes.length; i++){
            if(Math.random() < mutationRate){
                genes[i] = min + (float)(Math.random() * (max-min));
            }
        }
    }

    public Genome getOffspring(Genome g1){
        if(this.isCompatible(g1)) {
            float[] newGeneSeq = new float[g1.getSize()];
            float[] g1Seq = g1.getSequence();
            float[] g2Seq = this.getSequence();

            for(int i = 0; i < newGeneSeq.length; i++)
            {
                float guassianRandom = (float)getGaussianRandom(1, 0.15f);
                newGeneSeq[i] = guassianRandom*((g1Seq[i] + g2Seq[i])/2);
            }
            Genome offspring = new Genome(newGeneSeq, g1.max, g1.min);
            offspring.mutate((float) getGaussianRandom(0.08f, 0.02f));
            return offspring;
        }
        return null;
    }

    private static double getGaussianRandom(float mean, float stdDeviation){
        Random r = new Random();
        return r.nextGaussian() * stdDeviation + mean;
    }

    public boolean isCompatible(Genome g1){
        return  (g1.getSize() == this.getSize()) &&
                (g1.max == this.max) &&
                (g1.min == this.min);
    }

    public float[] getSequence(){
        return this.genes;
    }

    public int getSize(){
        return genes.length;
    }
}
