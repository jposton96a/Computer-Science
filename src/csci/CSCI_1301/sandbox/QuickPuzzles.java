package csci.CSCI_1301.sandbox;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jposton on 3/23/16.
 */
public class QuickPuzzles {

    public static void main(String[] args){
        int []a = {2,45,7,3,5,1,8,9};
        System.out.println(sumPairs(a, 10));
    }

    public static String sumPairs(int[] nums, int sum){
        StringBuilder str = new StringBuilder();
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i : nums){
            if(sumMap.containsKey(i))
                str.append(String.format("[%d + %d = %d]\n", i, sumMap.get(i), sum));
            else
                sumMap.put(sum-i, i);
        }

        return str.toString();
    }
}
