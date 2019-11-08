import java.sql.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//the exceptions are included here, see bellow.
		
		try {
			
		Flight flight1 = new Flight ("AM1234"  , "Amsterdam");
		
		Flight flight2 = new Flight ("AA1111"  , "Ams");

		Date d1 = new Date (21,12,2019);
		Date d2 = new Date (10,8,2019);
		Date d3 = new Date (1,2,2019);
		Date d4 = new Date (6,9,2019);
		Date d5 = new Date (5,3,2019);
		Date d6 = new Date (4,12,2019);
		Date d7 = new Date (7,1,2019);
		Date d8 = new Date (11,10,2019);
		Date d9 = new Date (1,1,2019);
		
		Customer c1 = new Customer ("AAAA", "Dedede"       , "D124456789");
		Customer c2 = new Customer ("BBBB", "Magogo"       , "V444655489");
		Customer c3 = new Customer ("CCCC", "Pashoto"      , "G444346789");
		Customer c4 = new Customer ("DDDD", "Mabobo"       , "H476556789");
		Customer c5 = new Customer ("EEEE", "Malolo"       , "Y454456789");
		Customer c6 = new Customer ("FFFF", "Lokolo"       , "E444456789");
		Customer c7 = new Customer ("GGGG", "Nonono"       , "Y214445678");
		Customer c8 = new Customer ("HHHH", "Kokoko"       , "I124456789");
		Customer c9 = new Customer ("IIII", "Magogo"       , "I422256789");

		
		FirstClassTicket f1 = new FirstClassTicket (352,c1, 300, Season.WINTER, d1, 28,7);
		FirstClassTicket f2 = new FirstClassTicket (353,c2, 555, Season.SPRING, d2, 26,8);
		FirstClassTicket f3 = new FirstClassTicket (354,c3, 670, Season.SUMMER, d3, 29,11);
		FirstClassTicket f4 = new FirstClassTicket (355,c4, 1000, Season.SUMMER, d4, 30,30);
		
		
		EconomyTicket e1 = new EconomyTicket (120, c5, 400, Season.SUMMER, d5 , 22, Meal.LUXURY , true);
		EconomyTicket e2 = new EconomyTicket (121, c6, 300, Season.WINTER, d5 , 21, Meal.BASIC , false);
		EconomyTicket e3 = new EconomyTicket (122, c7, 245, Season.AUTUMN, d5 , 10, Meal.PREMIUM , true);



		
		//flight1.addFlightTicket(f1);
		flight1.addFlightTicket(f1);
		flight1.addFlightTicket(f2);
		flight1.removeFlightTicket(f2);
		f2.setNumOfSeat(376);
		flight1.addFlightTicket(f2);
		flight1.addFlightTicket(f4);
		flight1.addFlightTicket(e1);
		flight1.addFlightTicket(e3);


		

		f4.setHandbagWeight(20);
		
		
		
		//flight1.printSpecialMeals();
		
		flight1.sortArr();
		System.out.println(flight1.toStringSorted());

		//System.out.println(flight1.getTotalWeight());
		//System.out.println(flight2.isActive());
		
		}
		
		catch  (InvalidNameException e)
		{
			System.out.println(e);
		}
		catch (InvalidPassportException p) 
		{
			System.out.println(p);
		}
		
		catch (InvalidWeightException w) 
		{
			System.out.println(w);
		}
		
		catch (InvalidSeatException s) 
		{
			System.out.println(s);
		}
		
	}

}
