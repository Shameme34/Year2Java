//Full Name:Shameem Ahamed
//Student no: 10233420
//Full Time
//Tutorial Group T05
//Declaration: This is my own work and I have not passed my program to my friends
//and will be willing to accept any penalty given

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

//Enum Declaration
enum Zodiac
{
	Rat ("RAT", 1948),
	Ox ("OX", 1949),
	Tiger ("TIGER", 1950),
	Rabbit ("RABBIT", 1951),
	Dragon ("DRAGON", 1952),
	Snake ("SNAKE", 1953),
	Horse ("HORSE", 1954),
	Goat ("GOAT", 1955),
	Monkey ("MONKEY", 1956),
	Rooster ("ROOSTER", 1957),
	Dog ("DOG", 1958),
	Pig ("PIG", 1959);
	
	//private instance field
	private final String title;
	private final int year;
	
	//Enum constructor
	Zodiac (String title, int year)
	{
		this.title = title;
		this.year = year;
	}
	
	//Accessor method
	public String getTitle()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
}

class Set
{
	private ArrayList<Zodiac> s;
	
	//Default constructor
	public Set()
	{
		s = new ArrayList<Zodiac>();
	}
	
	//Deep copy of arraylist
	public Set(Set otherSet)
	{
		this.s = new ArrayList<Zodiac>();
		for (Zodiac m : otherSet.s)
			this.s.add(m);
	}
	
	//Checking whether the arraylist is empty
	public boolean isEmpty()
	{
		if (s == null || s.isEmpty())
			return true;
		else 
			return false;
	}
	
	//Checking size of the arraylist
	public int cardinality()
	{
		return (s.size());
	}
	
	//Checking if the element is in the arraylist
	public boolean belongTo(Zodiac element)
	{
		if (s.contains(element))
			return true;
		else
			return false;
	}
	
	//Adding a new element thats not present in the arraylist
	public void addElement (Zodiac element)
	{
		if (!s.contains(element))
			this.s.add(element);
	}
	
	//Checking whether one set is a subset of another
	public boolean subset(Set otherSet)
	{
		//Creating a new arraylist for set 1
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(this.s);
		for (Zodiac x: this.s)
			alist1.add(x);
		
		//creating a new arraylist for set 2
		ArrayList<Zodiac>alist2 = new ArrayList<Zodiac>(otherSet.s);
		for (Zodiac y: otherSet.s)
			alist2.add(y);
		
		//checking if set 2 is a subset of set 1
		if (alist2.containsAll(alist1))
			return true;
		else 
			return false;
	}
	
	//Union of 2 sets
	public void union (Set otherSet)
	{
		//creating new arraylist to store the set arraylist
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(this.s);
		ArrayList<Zodiac> alist2 = new ArrayList<Zodiac>(otherSet.s);
		
		//removing all values common values present in arraylist 2 from arraylist 1
		alist1.removeAll(alist2);
		
		//adding all values from arraylist 2 to arraylist 1
		alist1.addAll(alist2);
		
		//creating a new copy of arraylist 1 with the union
		ArrayList<Zodiac> alist3 = new ArrayList<Zodiac>(alist1);
		
		//assigning arraylist 1 with the new values and replacing with the old arraylist 1 
		this.s = alist3;
	}
	
	//intersection of 2 sets
	public void intersection (Set otherSet)
	{
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(this.s);
		ArrayList<Zodiac> alist2 = new ArrayList<Zodiac>(otherSet.s);
		
		//creating an empty arraylist
		ArrayList<Zodiac> alist3 = new ArrayList<Zodiac>();
		
		//taking all values from arraylist 1 that is present in arraylist 2
		//and not present in arraylist 3 to be placed in arraylist3
		for(Zodiac z: alist1)
			if(alist2.contains(z) && !alist3.contains(z))
				alist3.add(z);
		
		//assigning the new values to arraylist 1 to replace the old arraylist 1
		ArrayList<Zodiac>alist4 = new ArrayList<Zodiac>(alist3);
		this.s = alist4;
	}
	
	public void difference (Set otherSet)
	{
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(this.s);
		ArrayList<Zodiac> alist2 = new ArrayList<Zodiac>(otherSet.s);
		
		//removing all elements from arraylist 1 that is present in arraylist 2
		alist1.removeAll(alist2);
		ArrayList<Zodiac>alist3 = new ArrayList<Zodiac>(alist1);
		this.s = alist3;
	}
	
	public Set complement()
	{
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(s);
		ArrayList<Zodiac> empty = new ArrayList<Zodiac>();
		
		//adding all of the enums to an empty arraylist
		for (Zodiac m: Zodiac.values())
			empty.add(m);
		
		//removing all the values present in arraylist 1 from the set that contains all the enums
		empty.removeAll(alist1);
	
		//creating a new set to contain all the complement elements
		Set newSet = new Set();
		newSet.s.clear();
		newSet.s.addAll(empty);
		
		return newSet;
	}
	
	public boolean equality(Set otherSet)
	{
		ArrayList<Zodiac> alist1 = new ArrayList<Zodiac>(this.s);
		ArrayList<Zodiac> alist2 = new ArrayList<Zodiac>(otherSet.s);
		
		//Checking if arraylist 1 contains elements in arraylist 2
		if(alist1.containsAll(alist2))
			return true;
		else
			return false;
	}
	
	//Making an enum Format
	public String getEnumFormat()
	{
		String enumStr = "";
		for (Zodiac name: s)
		{
			enumStr += name + ", ";
		}
		
		//Removing the last comma in the String
		int lastCommaIndex = enumStr.lastIndexOf(",");
		String b = enumStr.substring(0,lastCommaIndex );
		return String.format("{%s}",b);
	}
	
	//Making a year Format
	public String getYearFormat()
	{
		String year = "";
		for (Zodiac time: s)
		{
			year += time.getYear() +", ";
		}
		int lastCommaIndex = year.lastIndexOf(",");
		String c = year.substring(0,lastCommaIndex );
		return String.format("{%s}", c);
	}
	
	//Making a default format
	@Override
	public String toString()
	{
		String str = "";
		if (!s.isEmpty())
		{
			for (Zodiac z:s)
			{
				str += z.getTitle() + ", " ;
				
			}	
			int lastCommaIndex = str.lastIndexOf(",");
			String a = str.substring(0,lastCommaIndex );
			return String.format("{%s}",a);
		}
		else
			return String.format("{}");
	}


}

class Shameem_A1
{
	private static Scanner input;
	
	//Displaying the Zodiac info
	private static void displayZodiacInfo()
	{
		System.out.println("Universal set Info");
		System.out.println();
		System.out.printf("%-15s%-15s%-15s%n", "Zodiac Name" ,"Known as","For Example");
		for (Zodiac zod: Zodiac.values())
		{
			System.out.printf("%-15s%-15sYear %-15s%n", zod, zod.getTitle(),zod.getYear());
		}
		
	}
	
	//Getting a random element from the zodiac 
	private static Zodiac getAnElement()
	{
		Zodiac[] values = Zodiac.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];
	}
	
	//Creating a set with random elements with a random number of elements present
	private static Set getASet()
	{
		int rand = (int)(Math.random()*12);
		Set ss = new Set();
		for (int i=0;i <= rand;i++)
		{
			getAnElement();
			ss.addElement(getAnElement());

		}
		return ss;
	}
	
	//Displaying the main menu
	private static void displayMenu()
	{
		System.out.println("\nWelcome to SIM Set Theory lesson");
		System.out.println();
		System.out.println("0. Properties of Set");
		System.out.println("1. Union Example");
		System.out.println("2. Intersection example");
		System.out.println("3. Subset example");
		System.out.println("4. Difference example");
		System.out.println("5. Complement example");
		System.out.println("6. Sets Equality example");
		System.out.println("7. Distributive Law 1");
		System.out.println("8. Distributive Law 2");
		System.out.println("9. Quit");
		System.out.println();
		System.out.print("Your Option:");
	}
	
	//Giving a union Example
	private static void unionExample()
	{
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		System.out.println();
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		a.union(b);
		System.out.printf("%n\tUnion of A and B = %s",a);
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		
	}
	
	//Giving a intersection example
	private static void intersectionExample()
	{
		System.out.println();
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		a.intersection(b);
		System.out.printf("%n\tIntersection of A and B = %s", a);
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		
	}
	
	//Giving a subset example
	private static void subsetExample()
	{
		System.out.println();
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		System.out.println("\nConclusion");
		System.out.printf("\tA subset of B: %b", a.subset(b));
		System.out.printf("%n\tB subset of A: %b", b.subset(a));
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	
	//Giving a difference example
	private static void differenceExample()
	{
		System.out.println();
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		System.out.println();
		a.difference(b);
		System.out.printf("%n\tA - B = %s", a);
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	
	//Giving a complement example
	private static void complementExample()
	{
		System.out.println();
		Set a = new Set(getASet());
		System.out.println("Given Sets");
		System.out.printf("\tA = %s%n", a);
		System.out.printf("%n\tA' = %s", a.complement());
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	
	//Giving an equality Example
	private static void equalityExample()
	{
		System.out.println();
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		System.out.println("\nAnalysis");
		System.out.printf("\tA subset of B: %b", b.equality(a));
		System.out.printf("%n\tB subset of A: %b%n", a.equality(b));
		System.out.println("\nConclusion");
		if (a.equality(b) == true && b.equality(a)==true)
			System.out.printf("\tA equals of B: true");
		else
			System.out.printf("\tA equals of B: false");
		System.out.println();
		System.out.println("----------------------------------------------------------------");
	}
	
	//Showing the distributive law 1
	private static void distributiveLaw1()
	{
		//Creating new Sets to store data
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		Set c = new Set(getASet());
		
		//Creating a new set to store the original data
		Set e = new Set(a);
		Set f = new Set(b);
		Set g = new Set(c);
		Set h = new Set(a);
		
		System.out.println("\nWe wish to prove: A U (B I C) = (A U B) I (A U C)\n");
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		System.out.printf("%n\tC = %s%n", c);
		System.out.println("\nLHS analysis");
		g.intersection(f);
		g.union(e);
		System.out.printf("\tLHS = %s%n", g);
		System.out.println("\nRHS analysis");
		h.union(b);
		c.union(a);
		c.intersection(h);
		System.out.printf("\tRHS = %s%n", c);
		System.out.println("\nConclusion");
		System.out.println("\tLHS = RHS is true");
		System.out.println("----------------------------------------------------------------");
	}
	
	//Showing the distributive law 2
	private static void distributiveLaw2()
	{
		//Creating new Sets to store data
		Set a = new Set(getASet());
		Set b = new Set(getASet());
		Set c = new Set(getASet());
		
		//Creating a new set to store the original data
		Set e = new Set(a);
		Set f = new Set(b);
		Set g = new Set(c);
		Set h = new Set(a);
		
		System.out.println("\nWe wish to prove: A I (B U C) = (A I B) U (A I C)\n");
		System.out.println("Given Sets");
		System.out.printf("\tA = %s", a);
		System.out.printf("%n\tB = %s", b);
		System.out.printf("%n\tC = %s%n", c);
		System.out.println("\nLHS analysis");
		f.union(g);
		f.intersection(e);
		System.out.printf("\tLHS = %s%n", f);
		System.out.println("\nRHS analysis");
		b.intersection(h);
		c.intersection(a);
		b.union(c);
		System.out.printf("\tRHS = %s%n", b);
		System.out.println("\nConclusion");
		System.out.println("\tLHS = RHS is true\n");
		System.out.println("----------------------------------------------------------------");
	}
	
	//Displaying the submenu
	public static void displaySubmenu()
	{
		System.out.println("Some basic operations in set");
		System.out.println("\t1. Add an element");
		System.out.println("\t2. Check an Element");
		System.out.println("\t3. Cardinality");
		System.out.println("\t4. Enum Format");
		System.out.println("\t5. Year Format");
		System.out.println("\t9. Quit");
		System.out.println();
		System.out.print("Enter Your Option:");
	}
	
	//Displaying the first submenu and looping it
	public static void anExample()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nHere is an example of set");
		//Creating a new Set to be able to use in this method
		Set c = new Set(getASet());
		System.out.printf("\tA = %s%n", c);
		System.out.println("\tAll elements in set are distinct and random order");
		System.out.println();
		displaySubmenu();
		int choose = input.nextInt();
		System.out.println();
		//Creating a loop
		loop: while(true)
			
			//Adding the switch statement so that the user can choose between the options
			switch (choose)
			{
				case 1:
						//Allowing an element to be added and will not add the same element
						//that is already present in the set
						System.out.print("Enter an Element:");
						c.addElement(Zodiac.valueOf(input.next()));
						System.out.println("A = "+ c.toString());
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						System.out.println();
						break;
				case 2: 
						System.out.print("Enter an Element:");
						String x = input.next();
						
						//Checking if the element is present in the set
						if (c.belongTo(Zodiac.valueOf(x)) == true)
							System.out.printf("Element %s is in the set", x);
						else 
							System.out.printf("Element %s is not in the set", x);
						
						System.out.println();
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						break;
				case 3: 
						//printing out the number of sets present
						System.out.printf("%nNo of elements in set is %d%n", c.cardinality());
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						break;
				case 4:
						//printing out the enum notation
						System.out.println("Notation in enum format");
						System.out.printf("A = %s%n", c.getEnumFormat());
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						break;
				case 5:
						//printing out the year notation
						System.out.println("Notation in year format");
						System.out.printf("A = %s", c.getYearFormat());
						System.out.println();
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						break;
				case 9:
						//breaking out of this loop
						break loop;
				default:
						//Displaying this menu if keyed in a number out of the loop
						System.out.println("Not a choice in this menu");
						System.out.println("Type 9 if you want to exit from this menu");
						System.out.println();
						System.out.println("----------------------------------------------------------------");
						displaySubmenu();
						choose = input.nextInt();
						break;
			}
		//Displaying the menu immediately after breaking the loop
		displayMenu();
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		displayZodiacInfo();
		displayMenu();
		int choose1 = input.nextInt();
		//Allowing a loop unless the user key in 9
		loop2: while (	choose1 == 1 || choose1 == 2 || choose1 == 3 || 
						choose1 == 4 || choose1 == 5 || choose1 == 6 || 
						choose1 == 7 || choose1 == 8 || choose1 == 9 || choose1 == 0)
		{
			//Switch statement so that the use can choose what option he wants
			//each switch statement will give its respective displays
			switch(choose1)
				{
					case 0: 	
							anExample();
							choose1 = input.nextInt();
							break;
					case 1:
							unionExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 2: 
							intersectionExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 3:
							subsetExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 4:
							differenceExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 5:
							complementExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 6:
							equalityExample();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 7: 
							distributiveLaw1();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 8 :
							distributiveLaw2();
							displayMenu();
							choose1 = input.nextInt();
							break;
					case 9 :
							//Allowing user to break out of loop and exit stop the whole operation
							break loop2;
						
				}
		}	
	}
}