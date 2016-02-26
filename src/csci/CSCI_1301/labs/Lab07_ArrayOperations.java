package csci.CSCI_1301.labs;

/**
 * Created by jposton on 2/26/16.
 */
public class Lab07_ArrayOperations {

    public static void main(String[ ] args)
    {
        int [] arLab07 = {4,3,7,400,6,9,7,4,39,13,5,6,7,3,4,1,3,11,27,4,55,9,6,13,787,2,99,5,4,5,6,66,66,456,765,45,32};

        // print each element in array
        for ( int i = 0; i < arLab07.length; i++ )
            System.out.println("Element at index " + i + " = " + arLab07[i] );

        int max, min;
        max = getMax(arLab07);
        min = getMin(arLab07);

        // enter here your code to print the max in the array
        System.out.println("The max in the array = " +  max);

        // enter here your code to print the min in the array
        System.out.println("The min in the array = "  + min);

        // enter here your code to print the unique number(s) in the array
        printUnique(arLab07);
    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int i: arr)
            if(i > max)  // If the current array element is larger than the current max,
                max = i; // set max to current element

        return max;
    }

    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;

        for(int i: arr)
            if(i < min)  // If the current array element is smaller than the current min,
                min = i; // set min to current element

        return min;
    }

    public static void printUnique(int[] arr){

        for(int i = 0; i < arr.length; i++){
            boolean isUnique = true;
            for(int j = 0; j < arr.length; j++){ // Search all elements for duplicates
                if(i != j && arr[i] == arr[j]){ // If the value matches, but not the same index, a duplicate is found
                    isUnique = false;   // If a duplicate is found, this element is not unique
                    break;
                }
            }
            if(isUnique)
                System.out.print(arr[i]+" ");
        }
    }
}
