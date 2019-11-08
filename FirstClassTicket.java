
public class FirstClassTicket extends FlightTicket {
	
	private double handbagWeight;
	
	public FirstClassTicket (int numOfSeat, Customer customer, double price, Season season, Date date, 
			double luggage, double handbagWeight) throws InvalidSeatException, InvalidWeightException
	
	{
		super (numOfSeat,customer,price, season,
				date, luggage);
		setLuggageWeight(luggage);

		
	}
	
	@Override
	public int getNumOfSeat() 
	{
		return this.numOfSeat;
	}

	@Override
	public void setNumOfSeat(int numOfSeat) throws InvalidSeatException
	{
		if (numOfSeat >= 351 && numOfSeat <= 400 ) 
		{
			this.numOfSeat = numOfSeat;

		}
		else throw new InvalidSeatException("You have entered wrong seat! (First class) !");
	}

	
	@Override
	public Customer getCustomer() 
	{
		return this.customer;
	}

	@Override
	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}

	@Override
	public double getPrice() 
	{
		return this.price;
	}

	@Override
	public void setPrice(double price) 
	{
		if (price >=100) 
		{
		this.price = price;
		}
	}

	@Override
	public Date getDate() 
{
		return date;
	}

	@Override
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	@Override
	public double getLuggageWeight() 
	{
		return luggageWeight;
	}

	@Override
	public void setLuggageWeight(double luggageWeight) throws InvalidWeightException
	{
		double overWeight = 0;
		
		if (luggageWeight>0 && luggageWeight < 27 ) 
		{
			this.luggageWeight = luggageWeight;
		}
		else if (luggageWeight > 27) 
			
		{
			this.luggageWeight = luggageWeight;
			overWeight = luggageWeight - 27 ;
			
			if (overWeight>0 && overWeight < 1) 
			{
				this.setPrice(this.getPrice() + 15);
				return;
			}
			
			else 
			{
				this.setPrice(this.getPrice() + (overWeight * 15 ));
			
			}
		}
		else throw new InvalidWeightException("You have entered the wrong weight (First class)!");
	}
	
	@Override
	public void giveSeasonDiscount () 


	{
		if (this.season == Season.AUTUMN || this.season==Season.SPRING)
				{
			this.price = getPrice() - (getPrice() * 0.1);
				}
	}

	
	@Override
	public boolean equals (FlightTicket other) 
	
	{
		if ( (other instanceof FirstClassTicket) &&
				(this.getNumOfSeat()== (((FirstClassTicket)other).getNumOfSeat()))) 
		{
			System.out.println("Thats true, they got the same Number of seat. \n");
			return true;
		}
		
		else {
			System.out.println("Thats false, they dont have the same Number of seat. \n");
			return false;
			
			}
		}
	
	
	@Override
	public String toString () 
	{
		return  this.getCustomer() + "\n" +
				"Date: " + this.getDate() + "\n" + 
				"The number of seat is: " + this.getNumOfSeat() + "\n" +
				"The price is: " + this.getPrice() + "\n" + 
				"The season is: " + this.getSeason() + "\n \n"  ;
				

	}
		
	
	public void setHandbagWeight (double weight) 
	{
		double penalty = 0;
		
		if (weight>10) 
		{
			penalty = ((weight - 8 ) *8);
			this.setPrice(this.getPrice()+penalty);
			this.handbagWeight = weight;
		}
		if (weight<0) 
		{
			this.handbagWeight = 0;
		}
		
	}
	
	
	public double getHandbagWeight () 
	
	{
		return this.handbagWeight;
	}

	@Override
	public int compareTo(FlightTicket o) {
		this.getClass().getName();
		return 0;
	}
	
	
}
