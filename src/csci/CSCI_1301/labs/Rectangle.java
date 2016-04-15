package csci.CSCI_1301.labs;

public class Rectangle extends Figure {

    public Rectangle() {
        super();
        super.setType("Rectangle");
    }

    public double perimeter() {
        return ((2 * super.getP1()) + ((2 * super.getP2())));
    }

    public double area() {
        return this.getP1() * this.getP2();
    }
}
