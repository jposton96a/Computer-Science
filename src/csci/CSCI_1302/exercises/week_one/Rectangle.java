package csci.CSCI_1302.exercises.week_one;

/**
 * Created by jposton on 8/17/16.
 */
public class Rectangle {
    int length;
    int width;

    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }

    public int getArea(){
        return length*width;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }
}
