package csci.toolbox;

import java.util.Random;

/**
 * Created by Jacob on 1/14/2016.
 */
public class RandomUtil {

    public static char randomAsciiChar(){
        String availableChars = "abcdefghijklmnopqrstuvwxyz";
        availableChars += availableChars.toUpperCase() + " 0123456789.,/?><:\";'{}[]!@#$%^&*()_+";
        return availableChars.toCharArray()[(int)(Math.random() * availableChars.length())];
    }

    public static double getGaussianRandom(float mean, float stdDeviation){
        Random r = new Random();
        return r.nextGaussian() * stdDeviation + mean;
    }
}
