package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker f = new Faker();
	
	public String randomusername()
	{
		
		return f.name().username();
		
	}
	
	public String randompassword()
	{
		
		return f.internet().password();
	}
	
	public String fullusername()
	{
		
	 return f.name().fullName();
	}
	
	public String generateemailid()
	{
		
	return f.internet().emailAddress();
	
	}
	
	public String generatephonenumber()
	
	{
	 return f.phoneNumber().cellPhone();
		
	}
	
}
