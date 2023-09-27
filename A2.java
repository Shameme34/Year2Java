//Full Name:Shameem Ahamed
//Student no: 10233420
//Full Time
//Tutorial Group T05
//Declaration: This is my own work and I have not passed my program to my friends
//and will be willing to accept any penalty given

import java.util.ArrayList;
import java.util.Random;

//Enum declaration
enum ShapeColor
{
	Blue,
	Yellow,
	Red,
	Green,
	White
}

//interface for both 2d and 3d class
interface Shape
{
	public double area();
}

//Interface for TwoD class
interface ForTwoD
{
	public final double MyPI = 3.14;
	
	public double perimeter();
	public void recolor (ShapeColor sc);
}

//interface for 3D class
interface ForThreeD
{
	public final double MyPI = 3.14;
	public double volume();
	public void resize(double percentage);
}

//Abstract class for 3D
abstract class ThreeD implements ForThreeD, Shape
{
	protected ShapeColor sc;
	protected double a;
	
	//Default constructor
	public ThreeD()
	{
		
	}
	
	//Other constructor
	public ThreeD (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	//Copy constructor
	public ThreeD(ThreeD td)
	{
		this (td.sc, td.a);
	}
	
	//Accessor method
	public double getA()
	{
		return a;
	}
	
	//Mutator method
	public void set(ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	//Resize method for 3D
	public void resize (double percentage)
	{
		double resizing;
		resizing = Math.random()*50 + 1;
		this.a = (a) *((100-resizing)/100);
		System.out.printf("Size reduced by %.1f%%: ", resizing);
	}
	
	public String toString()
	{
		return String.format("%s", sc);
	}
}

//Cube class
class Cube extends ThreeD
{
	//Default constructor
	public Cube()
	{
		
	}
	
	//Other constructor
	public Cube (ShapeColor sc, double a)
	{
		super(sc,a);
	}
	
	//Copy constructor
	public Cube (Cube c)
	{
		super(c.sc,c.a);
	}
	
	//Overriding the area method
	@Override
	public double area()
	{
		return 6.0*a*a;
	}
	
	//Overriding the volume method
	@Override
	public double volume()
	{
		return Math.pow(a,3.0);
	}
	
	//Accessor method
	public double getA()
	{
		return a;
	}
	
	//Mutator method
	public void set(ShapeColor sc, int a)
	{
		super.set(sc, a);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Cube (3D (%s, %.3f))", sc,a);
	}
}

//Tetrahedron class
class Tetrahedron extends ThreeD
{
	//Default constructor
	public Tetrahedron()
	{
		
	}
	
	//Other constructor
	public Tetrahedron(ShapeColor sc, double a)
	{
		super(sc,a);
	}
	
	//Copy constructor
	public Tetrahedron(Tetrahedron t)
	{
		super(t.sc,t.a);
	}
	
	//Overrding the area method
	@Override
	public double area()
	{
		return (Math.sqrt(3.0) * Math.pow(a, 2.0));
	}
	
	//Overriding the volume method
	@Override
	public double volume()
	{
		return ((Math.pow(a, 3.0)*Math.sqrt(2.0))/12.0);
	}
	
	//Accessor method
	public double getA()
	{
		return a;
	}
	
	//Mutator method
	public void set(ShapeColor sc, double a)
	{
		super.set(sc, a);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Tetrahedron (3D (%s, %.3f))", sc,a);
	}
}

//Sphere class
class Sphere extends ThreeD
{
	//Default constructor
	public Sphere()
	{
		
	}
	
	//Other constructor
	public Sphere(ShapeColor sc, double a)
	{
		super(sc,a);
	}
	
	//Copy constructor
	public Sphere (Sphere s)
	{
		super(s.sc,s.a);
	}
	
	//Overriding the area method
	@Override
	public double area()
	{
		return (4.0 * MyPI * a * a );
	}
	
	//Overriding the volume method
	@Override
	public double volume()
	{
		return (4.0/3.0)*(MyPI * Math.pow(a, 3.0));
	}
	
	//Accessor method
	public double getA()
	{
		return a;
	}
	
	//Mutator method
	public void set (ShapeColor sc, double a)
	{
		super.set(sc, a);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Sphere (3D (%s, %.3f))", sc,a);
	}
}

//Abstract TwoD class
abstract class TwoD implements ForTwoD, Shape
{
	protected ShapeColor sc;
	protected int a;
	protected int b;
	protected int c;
	protected int d;
	
	//Default constructor
	public TwoD()
	{
		
	}
	
	//Other constructor
	public TwoD(ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	public TwoD(ShapeColor sc, int a, int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public TwoD(ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//Copy constructor
	public TwoD (TwoD td)
	{
		this (td.sc,td.a, td.b, td.c, td.d);
	}
	
	//Accessor method
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public ShapeColor getShapeColor()
	{
		return sc;
	}
	
	//Mutator methods
	public void set(ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}
	
	public void set(ShapeColor sc, int a, int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
	}
	
	public void set(ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void set(ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	//Recolor method
	public void recolor (ShapeColor sc)
	{
		Random rand = new Random();
		ShapeColor[] values = ShapeColor.values();
		int length = values.length;
		int randIndex = rand.nextInt(length);
		while (true)
		{
			if(sc == values[randIndex])
				randIndex = rand.nextInt(length);
			else if (sc != values[randIndex])
			{
				this.sc = values[randIndex];
				break;
			}		
		}
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format ("%s", sc);
	}
}

//Circle class
class Circle extends TwoD
{	
	//Default constructor
	public Circle()
	{
		
	}
	
	//Other constructor
	public Circle (ShapeColor sc, int radius)
	{
		super (sc, radius);
	}
	
	//Copy constructor
	public Circle (Circle c)
	{
		this (c.sc,c.a);
	}
	
	//Area method
	public double area()
	{
		return MyPI * a * a;
	}
	
	//Perimeter method
	public double perimeter()
	{
		return 2.0 * MyPI * a;
	}
	
	//Accessor method
	public int getRadius()
	{
		return  a;
	}
	
	//Mutator method
	public void set(ShapeColor sc, int radius)
	{
		super.set(sc, radius);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Circle (2D (%s, %d))%n", super.toString(), a);
	}
}

//Rectangle class
class Rectangle extends TwoD
{
	//Default constructor
	public Rectangle()
	{
		
	}
	
	//Other constructor
	public Rectangle (ShapeColor sc, int length, int width)
	{
		super(sc, length, width);
	}
	
	//Copy constructor
	public Rectangle (Rectangle r)
	{
		this(r.sc, r.a, r.b);
	}
	
	//Area method
	@Override
	public double area()
	{
		return 1.0* a * b;
	}
	
	//Perimeter method
	@Override
	public double perimeter()
	{
		return 2.0 * (a + b);
	}
	
	//Accessor method
	public int getLength()
	{
		return a;
	}
	
	public int getWidth()
	{
		return b;
	}
	
	//Mutator method
	public void set(ShapeColor sc, int length, int width)
	{
		super.set(sc, length, width);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Rectangle (2D (%s, %d, %d))%n", super.toString(), a, b);
	}
}

//Triangle class
class Triangle extends TwoD
{
	//Default constructor
	public Triangle()
	{
		
	}
	
	//Other constructor
	public Triangle(ShapeColor sc, int a, int b, int c)
	{
		super(sc, a, b, c);
	}
	
	//Copy constructor
	public Triangle (Triangle t)
	{
		super (t.sc, t.a, t.b, t.c);
	}
	
	//Area method
	@Override
	public double area()
	{
		double s = (a + b + c)/2.0;
		return Math.sqrt(s * (s-a) * (s-b) * (s-c));
	}
	
	//Perimeter method
	@Override
	public double perimeter()
	{
		return a + b + c;
	}
	
	//Accessor method
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	//Mutator method
	public void set(ShapeColor sc, int a, int b, int c)
	{
		super.set(sc, a, b, c);
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Triangle (2D (%s, %d, %d, %d))%n", super.toString(), a, b, c);
	}
}

//Trapezoid class
class Trapezoid extends TwoD
{
	//Declaring a variable just for this class
	private int h;
	
	//Default constructor
	public Trapezoid()
	{
		
	}
	
	//Other constructor
	public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h)
	{
		super (sc,a,b,c,d);
		this.h = h;
	}
	
	//Copy constructor
	public Trapezoid (Trapezoid t)
	{
		super (t.sc,t.a,t.b,t.c,t.d);
		this.h = t.h;
	}
	
	//Area method
	@Override
	public double area()
	{
		return ((a+b)/2.0)*(h);
	}
	
	//Perimeter method
	@Override
	public double perimeter()
	{
		return 1.0*(a+b+c+d);
	}
	
	//Accessor method
	public int getA()
	{
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public int getC()
	{
		return c;
	}
	
	public int getD()
	{
		return d;
	}
	
	public int getHeight()
	{
		return h;
	}
	
	//Mutator method
	public void set (ShapeColor sc, int a, int b, int c, int d, int h)
	{
		super.set(sc,a,b,c,d);
		this.h = h;
	}
	
	//ToString method
	@Override
	public String toString()
	{
		return String.format("Trapezoid (2D (%s, %d, %d, %d, %d), %d)%n", super.toString(), a, b, c, d, h);
	}
}

class Shameem_A2
{
	//Generating a random integer between 1 - 10
	private static int getInt()
	{
		int randNo;
		return randNo = (int)(Math.random()*10 + 1);
	}
	
	//Generating a random double value between 1-10
	private static double getDouble()
	{
		double randNo;
		return randNo = Math.random()*10 + 1;
	}
	
	//Getting a random color from the enum class
	private static ShapeColor getColor()
	{
		ShapeColor[] values1 = ShapeColor.values();
		int length = values1.length;
		int randIndex = new Random().nextInt(length);
		return values1[randIndex];
	}

	//Checking Whether the 3 sides can form a triangle
	private static boolean isTriangle(int a, int b, int c)
	{
		if (((a+b)> c) && ((c+b)> a) && ((c+a)> b))
			return true;
		else
			return false;
	}
	
	//Randoming getting one of the 4 2D shapes
	private static TwoD getTwoD()
	{
		int rando;
		rando = (int)(Math.random()*4 + 1);
		if (rando == 1)
		{
			Circle c0 = new Circle(getColor(), getInt());
			return c0;
		}
		else if (rando == 2)
		{ 
			Rectangle r0 = new Rectangle(getColor(),getInt(),getInt());
			return r0;
		}
		else if (rando == 3)
		{
			//Will keep looping until a valid triangle is generated
			while (true)
			{
				int a = getInt();
				int b = getInt();
				int c = getInt();
				if (isTriangle(a,b,c) == true)
				{
					Triangle t0 = new Triangle(getColor(),a,b,c);
					return t0;
				}
			}
		}
		else if (rando == 4)
		{
			Trapezoid tp0 = new Trapezoid(getColor(),getInt(),getInt(),getInt(),getInt(),getInt());
			return tp0;
		}
		return null;
	}
	
	//Getting one of the random 3D shapes
	private static ThreeD getThreeD()
	{
		int rando;
		rando = (int)((Math.random()*3) + 1);
		if (rando == 1)
		{
			Cube c0 = new Cube(getColor(), getDouble());
			return c0;
		}
		else if (rando == 2)
		{ 
			Tetrahedron t0 = new Tetrahedron(getColor(), getDouble());
			return t0;
		}
		else if (rando == 3)
		{
			Sphere s0 = new Sphere(getColor(), getDouble());
			return s0;
		}
		return null;
	}
	
	//Placing the randomly gotten 2d/3d shapes in an array
	private static void displayAList(ArrayList<Shape>alist)
	{
		int count = 0;
		for (Shape ss : alist)
		{
			if (ss instanceof TwoD)
			{
				count++;
				System.out.printf("Shape %d: ", count);
				System.out.print(ss);
				TwoD ftd2 = (TwoD) (ss);
				ftd2.recolor((ftd2).getShapeColor());
				System.out.printf("Updated Color: %s%n",ftd2.getShapeColor());
				System.out.printf("Area = %.3f%n", ss.area());
				System.out.printf("I am a %s shape with color changed to %s%n", ss.getClass().getName(), ftd2.getShapeColor());
				System.out.println("-------------------------------------------------------------");
				//Both the above method and below method produces the same results.
				/*if (ss instanceof Circle)
				{
					Circle c = (Circle) (ss);
					c.recolor(c.getShapeColor());
					System.out.printf("Updated Color: %s%n",c.getShapeColor());
					System.out.printf("Area = %.3f%n", c.area());
					System.out.printf("I am a %s shape with color changed to %s%n", ss.getClass().getName(), c.getShapeColor());
				}
				else if (ss instanceof Rectangle)
				{
					Rectangle r = (Rectangle) (ss);
					r.recolor(r.getShapeColor());
					System.out.printf("Updated Color: %s%n",r.getShapeColor());
					System.out.printf("Area = %.3f%n", r.area());
					System.out.printf("I am a %s shape with color changed to %s%n", ss.getClass().getName(), r.getShapeColor());
				}
				else if (ss instanceof Triangle)
				{
					Triangle t = (Triangle)(ss);
					t.recolor(t.getShapeColor());
					System.out.printf("Updated Color: %s%n",t.getShapeColor());
					System.out.printf("Area = %.3f%n", t.area());
					System.out.printf("I am a %s shape with color changed to %s%n", ss.getClass().getName(), t.getShapeColor());
				}
				else if (ss instanceof Trapezoid)
				{
					Trapezoid tp = (Trapezoid)(ss);
					tp.recolor(tp.getShapeColor());
					System.out.printf("Updated Color: %s%n",tp.getShapeColor());
					System.out.printf("Area = %.3f%n", tp.area());
					System.out.printf("I am a %s shape with color changed to %s%n", ss.getClass().getName(), tp.getShapeColor());
				}*/
				
			}
			else if (ss instanceof ThreeD)
			{
				count++;
				System.out.printf("Shape %d: ", count);
				System.out.print(ss);
				System.out.printf("%nSurface area = %.3f%n", ss.area());
				ThreeD ftd = (ThreeD) (ss);
				System.out.printf("Volume = %.3f%n", ftd.volume());
				ftd.resize((ftd).getA());
				//both the above method and below methods produce the same results
				/*if (ss instanceof Cube)
				{
					Cube c = (Cube) (ss);
					System.out.printf("Volume = %.3f%n", c.volume());
					c.resize(c.getA());
				}
				else if (ss instanceof Tetrahedron)
				{
					Tetrahedron t = (Tetrahedron)(ss);
					System.out.printf("Volume = %.3f%n", t.volume());
					t.resize(t.getA());
				}
				else if (ss instanceof Sphere)
				{
					Sphere s = (Sphere)(ss);
					System.out.printf("Volume = %.3f%n", s.volume());
					s.resize(s.getA());
				}*/
				System.out.print(ss);
				System.out.printf("%nUpdated Surface area = %.3f%n", ss.area());
				System.out.printf("Updated Volume = %.3f%n", ftd.volume());
				System.out.printf("I am a %s shape%n", ss.getClass().getName());
				System.out.println("-------------------------------------------------------------");
			}
			
		}
	}
	
	public static void main(String[] args)
	{

		ArrayList <Shape> alist = new ArrayList<Shape>();
		int k;
		Random rand = new Random();
		//Will keep looping until zero
		while (true)
		{
			k = rand.nextInt(3);
			if (k == 0)
				break;
			else if (k == 1)
				alist.add(getTwoD());
			else if (k == 2)
				alist.add(getThreeD());
		}
		
		displayAList(alist);
	}	
}
