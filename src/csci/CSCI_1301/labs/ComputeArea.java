package csci.CSCI_1301.labs;

/**
 * Created by Jacob on 1/15/2016.
 */
public class ComputeArea {
    public static void main(String[] args){
        double radius = 10;
        double area = Math.PI * radius*radius;

        System.out.printf("The area of a circle with the radius of %f is %f\n", radius, area);
    }
}
