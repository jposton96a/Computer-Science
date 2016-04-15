package csci.CSCI_1301.labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jposton on 4/15/16.
 */
public class Lab11_ArraySorting {

    public static void main(String[] args) {
        String lab11_FileName = "res/labs/CSCI_1301_Spring2016_Lab11_Data.txt";

        int[] arrData = readLab11Array(lab11_FileName);

        System.out.println("sumFirstHalf with orig data " + sumFirstHalf(arrData));
        System.out.println("sumSecondHalf with orig data " + sumSecondHalf(arrData));

        int[] sortArray = sortArray(arrData);

        System.out.println("sumFirstHalf with sorted data " + sumFirstHalf(sortArray));
        System.out.println("sumSecondHalf with sorted data " + sumSecondHalf(sortArray));
    }

    public static int[] readLab11Array(String aFileName) {
        int[] arRet = new int[100];

        try{
            // Open the file and create a buffered reader
            FileReader fileReader = new FileReader(aFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the file by line into the array
            for(int i = 0; i < arRet.length; i++)
                arRet[i] = Integer.parseInt(bufferedReader.readLine());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return arRet;
    }

    public static double sumFirstHalf(int[] arData) {
        double sum = 0.0;

        for(int i = 0; i < arData.length/2; i++)
            sum+=arData[i];

        return sum;
    }


    public static double sumSecondHalf(int[] arData) {
        double sum = 0.0;

        for(int i = arData.length/2; i < arData.length; i++)
            sum+=arData[i];

        return sum;
    }


    public static int[] sortArray(int[] arData) {
        int[] sortedArray = new int[arData.length];
        sortedArray = arData;
        int temp;

        for(int i = 0; i < sortedArray.length; i++){
            for(int j = 1; j < sortedArray.length; j++){
                if(sortedArray[i] < sortedArray[j-1]){
                    temp = sortedArray[j-1];
                    sortedArray[j-1] = sortedArray[i];
                    sortedArray[i] = temp;
                }
            }
        }

        return sortedArray;
    }


    // in case you need to verify the content of your arrays...
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
        System.out.println("");
    }
}
