package csci.CSCI_1301.labs;

/**
 * Lab08_ArrayHistogram:
 * Finds min/max, counts even/odd elements, and
 * generates a text histogram for a given array
 * Created by jposton on 3/25/16.
 */
public class Lab08_ArrayHistogram {

    public static void main(String[] args)
    {
        int nItems = 500000;
        int lowLimit = 1;
        int uprLimit = 50;
        int [] randArr = createRandArray( nItems, lowLimit, uprLimit );

        System.out.println("The array has " + randArr.length + " random numbers ");
        System.out.println("The max number in the array is " + findMax ( randArr));
        System.out.println("The min number in the array is " + findMin ( randArr));
        System.out.println("There are " + oddCount( randArr) + " odd numbers in the array");
        System.out.println("There are " + evenCount( randArr) + " even numbers in the array");
        textHistogram ( randArr, lowLimit, uprLimit );
    }

    public static int[] createRandArray(int nItems, int lowLimit, int upLimit){
        int[] arrRand = new int[nItems];

        for(int i = 0; i < nItems; i++)
            arrRand[i] = (int)(Math.random() * (upLimit-lowLimit + 1)) + lowLimit;

        return arrRand;
    }

    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;

        // If the current element is higher than the current max, update max
        for(int i : arr)
            if(i > max)
                max = i;

        return max;
    }

    public static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;

        // If the current element is lower than the current min, update min
        for(int i : arr)
            if(i < min)
                min = i;

        return min;
    }

    public static int oddCount(int[] arr){
        int oddCount = 0;

        // For each element, if element is odd, increase oddCount
        for (int i : arr)
            if(i % 2 != 0)
                oddCount++;

        return oddCount;
    }

    public static int evenCount(int[] arr){
        int evenCount = 0;

        // For each element, if element is even, increase evenCount
        for (int i : arr)
            if(i % 2 == 0)
                evenCount++;

        return evenCount;
    }

    public static void textHistogram(int[] arr, int lowLimit, int upLimit){

        // Generate an array to hold histogram data
        // Data is stored with the index being the value counted,
        // while the element holds the number of times that value was found
        // when (histogramData[5] == 100) it means the number 5 was found 100 times
        int[] histogramData = new int[upLimit - lowLimit + 1];

        // Count the repetitions of each value.
        // Shift the range so the lowest value is at index: 0
        for(int i : arr)
            histogramData[i - lowLimit]++;

        // Print the histogram data
        for(int i = 0; i < histogramData.length; i++)
            System.out.printf("%d, %d\n", i+lowLimit, histogramData[i]);
    }
}
