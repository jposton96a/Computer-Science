package csci.CSCI_1302.exercises.week_one;

/**
 * Created by jposton on 8/17/16.
 */
public class TestRectangle {

    public static void main(String[] args){
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(0, 0);
        r1.setLength(5);
        r1.setWidth(2);

        r2.setLength(3);
        r2.setWidth(4);

        System.out.println("Rectangle 1 Area: " + r1.getArea());
        System.out.println("Rectangle 2 Area: " + r2.getArea());
    }
}
