
public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) 
	{
		setDay(day);
		setMonth(month);
		setYear(year);
		
	}
	
	public int getDay() 
	{
		return day;
	}
	public void setDay(int day) 
	{
		if (day>=1 && day <31) 
		{
			this.day = day;
		}
	}
	public int getMonth() 
	{
		return month;
	}
	public void setMonth(int month) 
	{
		if (month>=1 && month <31) 
		{
			this.month = month;
		}	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		if (year>=1900 && day <2019) 
		{
			this.year = year;
		}	
		
	}
	public String toString () 
	{
		return  this.day + "/" + this.month + "/" + this.year;
	}
	
}

