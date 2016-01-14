package csci.toolbox;

/**
 * Created by Jacob on 1/14/2016.
 */
public class RandomUtil {

    public static char randomAsciiChar(){
        String availableChars = "abcdefghijklmnopqrstuvwxyz";
        availableChars += availableChars.toUpperCase() + " 0123456789.,/?><:\";'{}[]!@#$%^&*()_+";
        return availableChars.toCharArray()[(int)(Math.random() * availableChars.length())];
    }
}
