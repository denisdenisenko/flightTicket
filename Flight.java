import java.util.ArrayList;
import java.util.Collections;

import sun.tools.tree.ForStatement;

public class Flight {
	
	private String numberOfFlight;
	private String destination;
	private ArrayList <FlightTicket> flights;
	private String letters;                       //this is for two destination letters
	
	private ArrayList <Integer> seat;
	private ArrayList <Customer> customers;
	
	// creating additional arrays for sorting;
	
	private ArrayList <FlightTicket> economy;
	private ArrayList <FlightTicket> premium;
	private ArrayList <FlightTicket> first;
	private ArrayList <FlightTicket> sorted;


	
	public Flight (String numberOfFlight, String destination) 

	
	{
		
		this.flights = new ArrayList<FlightTicket> ();
		this.seat = new ArrayList<>();
		this.customers = new ArrayList <Customer>();
		this.economy = new ArrayList<FlightTicket> ();
		this.premium = new ArrayList<FlightTicket> ();
		this.first = new ArrayList<FlightTicket> ();
		this.sorted = new ArrayList<FlightTicket> ();
		

		
		
			setDestination(destination);
			setLettres(letters);
			setNumberOfFlight(numberOfFlight);
			
			//seat.add(this.);
			
	}

	
	public void setSeat (FlightTicket ticket) 
	{
		seat.add(ticket.getNumOfSeat());
	}

	
	public String getDestination() 
	{
		return destination;
	}

	public void setDestination(String destination) 

	{
		int notChars = 0;
		for (int i = 0; i < destination.length(); i++) 
		{
			if(Character.isAlphabetic(destination.charAt(i))) 
			{
				continue;
			}
			else 
			{
				notChars++;
			}
		}
		
		if (notChars > 0) 
		{
			System.out.println("Wrong destination, must be a city! \n");
			
		}
		else 
		{
			this.destination=destination;
		}
	}
	
	



	public String getLettres() 
	{
		return this.letters;
	}
	



	public void setLettres(String letters) 
	{
		this.letters = this.getDestination().substring(0, 2).toUpperCase();
	}


	public String getNumberOfFlight() 
	{
		return this.numberOfFlight;
	}


	public void setNumberOfFlight(String numberOfFlight) 
	{	
		boolean isDigit = true;
		
		for (int i = 2; i < numberOfFlight.length(); i++) 
		{
			if(Character.isDigit(numberOfFlight.charAt(i))) 
			{
				continue;
			}
			else 
			{
				isDigit = false;
			}
				
		}
		
		if ((numberOfFlight.toUpperCase().charAt(0)==this.destination.toUpperCase().charAt(0)) &&
				(numberOfFlight.toUpperCase().charAt(1)==this.destination.toUpperCase().charAt(1)) && (isDigit ==true )) 
		{
			this.numberOfFlight = numberOfFlight;
		}
	}
	 
	
	public double removeFlightTicket (FlightTicket ticket) 
	
	{
		int counter = 0;
		double penalty = 0; 
		boolean FlExists = false ;
		
		for (FlightTicket t : flights) 
			
		{
			
			if(((FlightTicket)t).getNumOfSeat()==ticket.getNumOfSeat()) 
			
			{
				
				//flights.remove(ticket);
				counter++;
				FlExists = true;
			}
			
		}
		if (counter>0) 
		{
		penalty = (ticket.getPrice()*0.15);
		System.out.println("The penalty for cancelling was: " + penalty + "\n");
		this.seat.add(ticket.getNumOfSeat());
		flights.remove(ticket);
		return penalty;
		}
		else 
		{
			System.out.println("The penalty was: " + penalty + "\n");
			return penalty;
		}
	
	}
	
	
	public void addFlightTicket (FlightTicket ticket) 
	
	{
		int counter = 0;        //counts duplicate tickets
		boolean seatExist =false;
		
		for (Integer i : seat) 
		{
			if (i == ticket.getNumOfSeat()) 
			{
				seatExist = true;
			}
		}
		
		
		for (FlightTicket t : flights) 
		{
			if (t.getNumOfSeat()==ticket.getNumOfSeat()) 
			{
				counter++;
				break;
			}

		}
		if ((counter == 0 )&& seatExist == false) 
		{
			this.flights.add(ticket);
			seat.add(ticket.getNumOfSeat());
		}
		else if ((counter==0) && seatExist == true)
		{
			System.out.println("The seat is unavailible, choose another seat! \n");
		}
		else if (counter>0) 
		{
			System.out.println("The number of seat is not availible! \n");

		}
	}

	
	public double getTotalWeight () 
	
	{
		double totalWeight = 0;
		
		for (FlightTicket f : flights) 
		{
			System.out.println(f.getLuggageWeight());
			totalWeight = (totalWeight + f.getLuggageWeight());
		}
		
		return totalWeight;
	}
	
	public boolean isActive () 
	
	{
		int notActiveCount = 0;
		
		if (this.getDestination() == null|| this.getNumberOfFlight()== null) 
		{
			notActiveCount++;
		}
		
		if (notActiveCount>0) 
		{
			System.out.println("Is the flight active? ");
			return false;
		}
		else 
		{
			System.out.println("Is the flight active?  "); 
			return true;
		}
	}

	public void printSpecialMeals () 

	
	{
		int premMeal = 0;
		int luxMeal = 0;
		for (FlightTicket f : flights) 
		{
			if ((f instanceof EconomyTicket) && ((EconomyTicket)f).getMeal() == Meal.PREMIUM ) 
			{
				premMeal++;
			}
			else if ((f instanceof EconomyTicket) && ((EconomyTicket)f).getMeal() == Meal.LUXURY ) 
			{
				luxMeal++;
				System.out.println("1");

			}
		}
		System.out.println("The number of premium meals was: " + premMeal + "\n");
		System.out.println("The number of luxury meals was: " + luxMeal + "\n");

	}
	
	public ArrayList <Customer> getFirstClassCustomers () 
	
	{
		for (FlightTicket f : flights) 
		{
			if (f instanceof FirstClassTicket) 
			{
				customers.add(f.getCustomer());
			}
		}
		
		return customers;
	}
	
	
	public String toString () 
	
	{
		return "The Flight number is: " + getNumberOfFlight() + "\n" +
				"The destination is: " + getDestination() + "\n" + 
				"The Flight tickets are: " +"\n" + 
				"*************************************" + "\n\n" + flights + "\n";
	}
	
	// implement this method to print sorted list.
	
	public String toStringSorted () 
	
	{
		return "The Flight number is: " + getNumberOfFlight() + "\n" +
				"The destination is: " + getDestination() + "\n" + 
				"The Flight tickets are: " +"\n" + 
				"*************************************" + "\n\n" + sorted + "\n";
	}
	
	
	// some sorting function
	public void sortArr ()  
	{
		for (FlightTicket f : flights) 
		{
			if(f  instanceof EconomyTicket ) 
			{
				economy.add(f);
			}
			else if(f  instanceof PremiumTicket ) 
			{
				premium.add(f);
			}
			else if(f  instanceof FirstClassTicket ) 
			{
				first.add(f);
			}
		}
		
		sorted.addAll(economy);
		sorted.addAll(premium);
		sorted.addAll(first);

		
	}



	
	

}
