package csci.CSCI_1301.labs;

public class Circle extends Figure
{
  public Circle()
  {
	  super();
	  super.setType("Circle");
  }
  
  
  public double perimeter()
  {
	  return ( 2 * Math.PI * super.getP1() );
  }

  public double area()
  {
	  return ( Math.PI * Math.pow(this.getP1(), 2));
  }
}
