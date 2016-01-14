package csci.toolbox;

import java.util.ArrayList;

/**
 * Created by Jacob on 1/14/2016.
 */
public class NLP {

    public static int[] getMismatchedIndexes(char[] str1, char[] str2){
        ArrayList<Integer> mismatched = new ArrayList<Integer>();
        for(int i = 0; i < str1.length; i++)
            if(str1[i] != str2[i])
                mismatched.add(i);
        return mismatched.stream().mapToInt(i -> i).toArray();
    }

    public static int hammingDistance(String str1, String str2){
        int misses = Math.max(str1.length(), str2.length());
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) == str2.charAt(i)) misses--;
        return misses;
    }

    public static int levenshteinDistance (CharSequence lhs, CharSequence rhs) {
        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;

        // the array of distances
        int[] cost = new int[len0];
        int[] newcost = new int[len0];

        // initial cost of skipping prefix in String s0
        for (int i = 0; i < len0; i++) cost[i] = i;

        // dynamically computing the array of distances

        // transformation cost for each letter in s1
        for (int j = 1; j < len1; j++) {
            // initial cost of skipping prefix in String s1
            newcost[0] = j;

            // transformation cost for each letter in s0
            for(int i = 1; i < len0; i++) {
                // matching current letters in both strings
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;

                // computing cost for each transformation
                int cost_replace = cost[i - 1] + match;
                int cost_insert  = cost[i] + 1;
                int cost_delete  = newcost[i - 1] + 1;

                // keep minimum cost
                newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
            }

            // swap cost/newcost arrays
            int[] swap = cost; cost = newcost; newcost = swap;
        }

        // the distance is the cost for transforming all letters in both strings
        return cost[len0 - 1];
    }
}
