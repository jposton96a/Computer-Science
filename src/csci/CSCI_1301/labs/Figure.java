package csci.CSCI_1301.labs;

public class Figure
{
	private String mStrType;
	private int mIntP1;
	private int mIntP2;
	private int mIntP3;
	
	public Figure()
	{
		mStrType = "unknown";
		mIntP1 = 0;
		mIntP2 = 0;
		mIntP3 = 0;
	}
	
	public Figure( String argType )
	{
		this();
		mStrType = argType;
	}

	public Figure( String argType, int p1 )
	{
		this();
		mStrType = argType;
		mIntP1 = p1;
	}

	public Figure( String argType, int p1, int p2 )
	{
		this();
		mStrType = argType;
		mIntP1 = p1;
		mIntP2 = p2;
	}

	public Figure( String argType, int p1, int p2, int p3 )
	{
		this();
		mStrType = argType;
		mIntP1 = p1;
		mIntP2 = p2;
		mIntP3 = p3;
	}

	// these are the Figure mutator methods
	public void setType ( String a) { mStrType = a; }
	public void setP1( int a) { mIntP1 = a; }
	public void setP2( int a) { mIntP2 = a; }
	public void setP3( int a) { mIntP3 = a; }

	// these are the Figure accessor  methods
	public String getType ( ) { return (String) mStrType ; 	}
	public int    getP1 ( )   { return (int) mIntP1 ; }
	public int    getP2 ( )   { return (int) mIntP2 ; }
	public int    getP3 ( )   { return (int) mIntP3 ; }

	/*
	// dispatches the perimeter calculation to the correct figure class
	public double perimeter() 
	{
		return this.perimeter();
	}
	
	// dispatches the area calculation to the correct figure class
	public double area() 
	{
		return this.area();
	}

	public String toString() {
		return String.format("Type=%-10s\t perimeter = %.2f\t area = %.2f\t p1=%d\t p2=%d\t p3=%d\t",
				this.getType(),
				this.perimeter(),
				this.area(),
				this.getP1(),
				this.getP2(),
				this.getP3());
	}
	*/
	public String toString() {
		return String.format("Type=%-10s\t p1=%d\t p2=%d\t p3=%d\t",
				this.getType(),
				this.getP1(),
				this.getP2(),
				this.getP3());
	}
}
