package csci.CSCI_1301.quizes;

/**
 * Created by jposton on 2/15/16.
 */
public class Quiz4 {
    public static void main(String[] args){
        System.out.print("Q4Q1: ");
        Q4Q1.run();
        System.out.println();

        System.out.print("Q4Q2: ");
        Q4Q2.run();
        System.out.println();

        System.out.print("Q5Q1: ");
        Q5Q1.run();
        System.out.println();

        System.out.print("Q5Q2: ");
        Q5Q2.run();
    }
}

class Q4Q1{
    public static void run(){
        int i = 0;
        int j = 0;

        while (i < 1000)
        {
            if((i % 100) == 0)
                System.out.print(j++);
            i++;
        }
    }
}

class Q4Q2 {
    public static void run()
    {
        int i = 0;
        int j = 0;
        while ( i < 1000 )
        {
            if ((i % 100) == 0)
                System.out.print( ++j ) ;
            i++;
        }
    }
}

class Q5Q1 {
    public static void run()
    {
        int i = 0;
        while(i < 10){
            System.out.print( i++ );
        }
    }
}

class Q5Q2 {
    public static void run()
    {
        int i = 0;
        do{
            System.out.print( i++ );
        } while(i < 10);
    }
}
