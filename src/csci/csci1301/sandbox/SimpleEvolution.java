package csci.csci1301.sandbox;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 1/13/2016.
 */
public class SimpleEvolution {
    private static String target;
    private static float rate;
    private static int populationSize;

    private static int targetLength;

    public int generation = 0;

    public SimpleEvolution(String target, float mutationRate, int populationSize){
        this.target = target;
        this.rate = mutationRate;
        this.populationSize = populationSize;
        this.targetLength = target.length();
    }

    private String[] getMutatedList(String base){
        String[] generation = new String[this.populationSize];

        for(int i = 0; i < generation.length; i++){
            char[] newString = base.toCharArray();

            int[] incorrectChars = csci.toolbox.NLP.getMismatchedIndexes(target.toCharArray(), newString);
            for(int j = 0; j < incorrectChars.length; j++){
                double rand = Math.abs(Math.random());
                if(rand < this.rate)
                    newString[incorrectChars[j]] = csci.toolbox.RandomUtil.randomAsciiChar();
            }

            generation[i] = String.valueOf(newString);
        }

        return generation;
    }

    private int[] getFitness(String[] generation){
        int[] popFitness = new int[generation.length];
        for(int i = 0; i < popFitness.length; i++) {
            int hammingDistance = csci.toolbox.NLP.hammingDistance(generation[i], this.target);
            popFitness[i] = hammingDistance;
        }
        return popFitness;
    }

    private int getMin(int[] array){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0; i < array.length; i++)
            if(array[i] < min) {
                min = array[i];
                minIndex = i;
            }

        return minIndex;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetLength; i++)
            sb.append(csci.toolbox.RandomUtil.randomAsciiChar());
        String currentFittest = sb.toString();

        while (!currentFittest.equals(this.target)){
            String[] newGeneration = getMutatedList(currentFittest);
            int[] popFitness = getFitness(newGeneration);
            int fittestIndex = getMin(popFitness);
            currentFittest = newGeneration[fittestIndex];
            System.out.println("Generation: " + generation + " | " + currentFittest);
            generation++;
        }
    }

    public static void main(String[] args){
        int runs = 1000;
        long[] times = new long[runs];
        int[] generations = new int[runs];

        for(int i = 0; i < runs; i++) {
            long startTime = System.currentTimeMillis();

            SimpleEvolution e1 = new SimpleEvolution("Hello, World!", 0.1f, 200);
            e1.run();
            long endTime = System.currentTimeMillis();

            System.out.printf("Task completed %d generations in %dms\n", e1.generation, endTime - startTime);
            times[i] = endTime - startTime;
            generations[i] = e1.generation;
        }

        long timeSum = 0;
        long genSum = 0;
        for(long t : times)
            timeSum += t;
        for(int g : generations)
            genSum += g;

        System.out.printf(
                "Completed %d total runs.\n" +
                "Average Generation Count: %f" +
                "Average Time: %f\n", runs, (double)(genSum/runs), (double)(timeSum/runs));
    }


}