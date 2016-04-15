package csci.CSCI_1301.labs;

public class Triangle extends Figure {

    public Triangle() {
        super();
        super.setType("Triangle");
    }

    public double perimeter() {
        return (super.getP1() + super.getP2() + super.getP3());
    }

    public double area() {
        // you will need to use Heron's formula:
        double p = ((double) this.getP1() + (double) this.getP2() + (double) this.getP3())/2; // Semiperimeter of the triangle
        double area = Math.sqrt(Math.abs(p * (p - this.getP1()) * (p - this.getP2()) * (p - this.getP3())));

        //where a => area; a,b,c are the sides of the triangle, and p = (a+b+c)/2
        return area;
    }
}