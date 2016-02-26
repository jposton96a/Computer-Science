package csci.CSCI_1301.quizes;

/**
 * Created by jposton on 2/15/16.
 */
public class Quiz4 {
    public static void main(String[] args){
        Q4Q1.run();
        System.out.println();
        Q4Q2.run();
    }
}

class Q4Q1{
    public static void run(){
        int i = 0;
        int j = 0;

        while (i < 1000){
            if((i % 100) == 0)
                System.out.print(j++);
            i++;
        }
    }
}

class Q4Q2{
    public static void run(){
        int i = 0;
        int j = 0;

        while (i < 1000){
            if((i % 100) == 0)
                System.out.print(++j);
            i++;
        }
    }
}
