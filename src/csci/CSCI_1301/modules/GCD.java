package csci.CSCI_1301.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.regex.Matcher;

/**
 * Created by jposton on 2/22/16.
 */
public class GCD {

    public static void main(String[] args){
        int[] primeNums = EratosthenesSieve(1000);
        System.out.println(Arrays.toString(primeNums));
        for(int i = 1; i < primeNums.length; i++)
        {
            System.out.print(primeNums[i] - primeNums[i-1] + " ");
        }
        System.out.println(gcd(30, 50));
    }

    // Code from online module.
    // Instructions: copy it here and get it to run
    public static boolean isPrime (int nArg)
    {
        for (int divisor = 2; divisor <= nArg / 2; divisor++)
        {
            if ( nArg % divisor == 0)
                return false;
        }
        return true;
    }

    // Code from online module.
    // Instructions: copy it here and get it to run
    public static int gcd (int m1, int m2)
    {
        int gcd = 1;
        int k = 2;
        while ( k <= m1 && k <= m2)
        {
            if ( m1 % k == 0 && m2 % k == 0 )
                gcd = k; // update gcd
            k++; // update k
        }
        return gcd;
    }

    // My code. Heard about this algorithm and decided to implement for fun
    // Sieve of Eratosthenes :
    // Finds all prime numbers under a given limit
    public static int[] EratosthenesSieve(int limit){
        boolean[] notPrime = new boolean[limit];
        int primeCount = 0;
        int primeIndex = 0;

        for(int i = 2; i < limit/2; i++){
            for(int j = i*2; j < limit; j+=i){
                notPrime[j] = true;
            }
        }

        for(boolean b : notPrime)
            primeCount += b ? 0 : 1;


        int[] primes = new int[primeCount];
        for(int i = 0; i < limit; i++) {
            if (!notPrime[i])
                primes[primeIndex++] = i;
        }

        return primes;
    }
}
