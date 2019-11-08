
public class EconomyTicket extends FlightTicket  {
	
	private Meal meal;
	private boolean earphones;
	
	public EconomyTicket (int numOfSeat, Customer customer, double price, Season season, Date date, 


			double luggage, Meal meal, boolean earphones) throws InvalidWeightException, InvalidSeatException 
	
	{
		super (numOfSeat, customer, price, season, date, 
				luggage);
		setMeal(meal);
		setEarPhones(earphones);
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
		if (numOfSeat >= 1 && numOfSeat <=200 ) 
		{
			this.numOfSeat = numOfSeat;

		}
		else throw new InvalidSeatException ("Invalid seat, choose another one (Economy ticket)");
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
		
		if (luggageWeight>0 && luggageWeight < 20 ) 
		{
			this.luggageWeight = luggageWeight;
		}
		else if (luggageWeight > 20) 
			
		{
			this.luggageWeight = luggageWeight;
			overWeight = luggageWeight - 20 ;
			
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
		else throw new InvalidWeightException("The weight is wrong, enter a right weight! (Economy Ticket)");
	}
	
	public void setMeal (Meal meal) 


	{
		if (this.meal == Meal.PREMIUM) 
		{
			this.price = this.getPrice()+10;
			this.meal=meal;
		}
		
		else if (this.meal == Meal.LUXURY) 
		{
			this.price = this.getPrice() +30;
			this.meal = meal;
		}
		
		else 
		{
			this.meal = meal;
		}
	}
	
	public Meal getMeal () 
	{
		return this.meal;
	}
	
	public void setEarPhones (boolean earphones) 
	{
		this.earphones = earphones;
	}
	
	public boolean getEarPhones () 
	
	{
		return this.earphones;
	}
	
	public void wantsEarphones ()
	
	{
		
		if (this.earphones==true) 
		
		{
			this.price = this.getPrice()+20;
		}
		
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
		if ( (other instanceof EconomyTicket) &&
				(this.getNumOfSeat()== (((EconomyTicket)other).getNumOfSeat()))) 
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
		return this.getCustomer() + "\n" + 
				"Date: " + this.getDate() + "\n" + 
				"The number of seat is: " + this.getNumOfSeat() + "\n" +				 
				"The season is: " + this.getSeason() + "\n" + 
				"The price is: " + this.getPrice() + "\n" +  
				"The meal is :" + this.getMeal() + "\n" + 
				"Want earphones? : " + this.getEarPhones() + "\n \n";
	}

	@Override
	public int compareTo(FlightTicket o) {
		this.getClass().getName();
		return 0;
	}
	
	
	
	
}
