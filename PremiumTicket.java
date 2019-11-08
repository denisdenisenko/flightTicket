
public class PremiumTicket extends FlightTicket implements HandbagWeight {
	
	private boolean wine;
	private boolean blanket;
	private double  handbagWeight;
	
	
	public PremiumTicket (int numOfSeat, Customer customer, double price, Season season, Date date, 
			double luggage, boolean wine, boolean blanket, double  handbagWeight) 
	throws InvalidSeatException, InvalidWeightException
	
	{
		super (numOfSeat, customer, price, season, date, 
				luggage);	
		
		setWine(wine);
		setBlanket(blanket);
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
		if (numOfSeat >= 201 && numOfSeat <=350 ) 
		{
			this.numOfSeat = numOfSeat;

		}
		else throw new InvalidSeatException("You have entered wrong seat (Premium class)");
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
		
		if (luggageWeight>0 && luggageWeight < 23 ) 
		{
			this.luggageWeight = luggageWeight;
		}
		else if (luggageWeight > 23) 
			
		{
			this.luggageWeight = luggageWeight;
			overWeight = luggageWeight - 23 ;
			
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
		else throw new InvalidWeightException("You have entered wrong weight (Premium class)");
	}
		
	public boolean getWine()

 {
		return wine;
	}
	
	public void setWine(boolean wine) 
	{
		this.wine = wine;
	}

	public boolean getBlanket() 
	{
		return blanket;
	}

	public void setBlanket(boolean blanket) 
	{
		this.blanket = blanket;
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
		if ( (other instanceof PremiumTicket) &&
				(this.getNumOfSeat()== (((PremiumTicket)other).getNumOfSeat()))) 
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
		return "The Customer is: " + this.getCustomer() + "\n" + 
				"Date: " + this.getDate() + "\n" + 
				"The number of seat is: " + this.getNumOfSeat() + "\n" + 
				"The season is: " + this.getSeason() + "\n" + 
				"The price is: " + this.getPrice() + "\n" +  
				"With wine? :" + this.getWine() + "\n" + 
				"With blanlket? : " + this.getBlanket() + "\n";
	}
	
	
	
	
	
	public void setHandbagWeight (double weight) 
	{
		double penalty = 0;
		
		if (weight>8) 
		{
			penalty = ((weight - 8 ) *10);
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
	
	
}
