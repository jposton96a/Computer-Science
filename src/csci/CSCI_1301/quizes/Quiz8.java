package csci.CSCI_1301.quizes;

/**
 * Created by jposton on 2/29/16.
 */
public class Quiz8 {
    public static void main(String[] args)
    {

        int m1 = q8m1(4);
        int m2 = q8m2(5);
        System.out.println(m1 + " " + m2);
    }

    public static int q8m1( int n)
    {
        int r = 1;
        for (int i = 1; i <= n; i++)
            r = i * r;
        return r;
    }

    public static int q8m2( int n)
    {
        int r = 1;
        for (int i = n; i >= 1;  i--)
            r = i * r;
        return r;
    }
}