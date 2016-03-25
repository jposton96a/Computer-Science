package csci.CSCI_1301.sandbox.compression;

/**
 * Created by jposton on 2/29/16.
 */
public class CompressTest {
    public static void main(String[] args){
        long halfLong = (long)(0.5 * Long.MAX_VALUE);

        int total = 0;
        int correct = 0;

        for(int i = 0; i < 1000; i++){
            long randomLong = (long)(Math.random() * Long.MAX_VALUE);
            double ratio = (double)((double)randomLong / (double)halfLong);
            long reconstructed = (long)(halfLong * ratio);
            System.out.printf("%d %d %b\n", randomLong, reconstructed, randomLong == reconstructed);
            if(randomLong == reconstructed)
                correct++;
            total++;
        }
        System.out.printf("%d / %d\n", correct, total);
    }
}
