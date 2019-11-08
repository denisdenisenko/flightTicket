import java.util.Collections;

abstract class FlightTicket implements Comparable <FlightTicket> {
	
	protected static int noOfTicket = 0;
	protected int numOfSeat;
	protected Customer customer;
	protected double price;
	protected Season season;
	protected Date date;
	protected double luggageWeight;

	
	protected FlightTicket (int numOfSeat, Customer customer, double price, Season season, Date date, 
			double luggage) throws InvalidWeightException, InvalidSeatException

	{
		
		setCustomer(customer);
		setDate(date);
		setLuggageWeight(luggage);
		setNumOfSeat(numOfSeat);
		setSeason(season);
		setPrice(price);
		
		noOfTicket ++;
	}
	

	public int getNumOfSeat() {
		return this.numOfSeat;
	}


	abstract void setNumOfSeat(int numOfSeat) throws InvalidSeatException ;



	public Customer getCustomer() {
		return this.customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getPrice() {
		return this.price;
	}


	public void setPrice(double price) {
		this.price = price;
	}



	public Date getDate() {
		return this.date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getLuggageWeight() {
		return this.luggageWeight;
	}


	abstract void setLuggageWeight(double luggageWeight) throws InvalidWeightException;


	
	public void setSeason (Season season) 
	{
		this.season = season;
	}
	
	public Season getSeason () 
	{
		return this.season;
	}
	

	public void giveSeasonDiscount () 


	{
		if (this.season == Season.AUTUMN || this.season==Season.SPRING)
				{
			this.price = getPrice() - (getPrice() * 0.1);
				}
	}
	
	
	
	public boolean equals (FlightTicket other) 
	
	{
		if ((other instanceof FlightTicket) && 
				(this.getCustomer().getId().equals(((FlightTicket)other).getCustomer().getId()))) 
		{
			return true;
		}
		
		else return false;
	}
	
	
	public String toString () 
	{
		return "The Customer is: " + this.getCustomer() + "\n" + 
				"Date: " + this.getDate() + "\n" + 
				"The number of seat is: " + this.getNumOfSeat() + "\n" +
				"The price is: " + this.getPrice() + "\n" + 
				"The season is: " + this.getSeason() + "\n" + 
				"The price is: " + this.getPrice() + "\n";
	}
	
	

	
}
