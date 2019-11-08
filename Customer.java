
public class Customer {

	private String name;
	private String lastName;
	private String Id;
	
	public Customer (String name, String lastName, String Id) throws InvalidNameException, InvalidPassportException 
	
	{
		setId(Id);
		setLastName(lastName);
		setName(name);
		
	}

	//Setters
	
	public void setName(String name) throws InvalidNameException 
	{
		if ((name.length() > 1 )&& hasDigit(name)==false) 
		{
			this.name = name;

		}
		else throw new InvalidNameException("You entered wrong name, try another one");
	}

	public void setLastName(String lastName) 
	{
		
		if ((lastName.length() > 1 )&& hasDigit(lastName)==false) 
		{
			this.lastName = lastName;

		}		
	}

	public void setId(String id) throws InvalidPassportException
	{
		if ((id.length()==10)&& (Character.isDigit(id.charAt(0)) == false) && 
				(Character.isUpperCase(id.charAt(0)) == true) && (hasChar(id.substring(1)) == false))
		this.Id = id;	
		
		else throw new InvalidPassportException("You've entered invalid Passport ID, try again");
	}
	
	public boolean hasDigit(String str1) 
	{
		boolean digit = false;
		for (int i = 0; i < str1.length(); i++) 
		{
			if (Character.isDigit(str1.charAt(i))) 
			{
				digit = true;
			}
		}
		return digit;
	}
	
	
	public boolean hasChar (String str1) 


	{
		boolean hasChar = false; 
		
		for (int i = 0; i < str1.length(); i++) 
		{
			
			if (Character.isAlphabetic(str1.charAt(i))) 
			{
				hasChar = true; 
			}
			
		}
		
		return hasChar;
	}

	//Getters
	
	

	public String getName() 
	{
		
		return this.name;
	}

	public String getLastName() 
	{
		return this.lastName;
	}

	public String getId() 
	{
		return this.Id;
	}


	// toString
	
	public String toString () 
	{
		
		return "The customer name is: " + this.getName() + "\n" + 
		"The customer last name is: " + this.getLastName()+ "\n" +
				"The customer ID is: " + this.getId() ;
		
	}
	
	
	
	// equals 
	
	public boolean equals (Customer other) 
	
	{
		if ((this.getName().equals(other.getName())) && (this.getLastName().equals(other.getLastName()) &&
				 this.getId().equals(other.getId())))
				
				{
					return true;
				}
		
			return false;
	}
	
	
}
