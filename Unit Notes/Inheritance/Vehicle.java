import java.util.ArrayList;

//Disables ability to create an object of Vehicle class as a vehicle should fall into one of a select few categories. Car, Bike, Plane, Boat, etc.
public abstract class Vehicle
{
	private String owner;
	private boolean purchased;
	private ArrayList<String> purchaseHistory = new ArrayList<String>();
	
	public Vehicle()
	{
		owner = null;
		purchased = false;
		purchaseHistory = new ArrayList<String>();
	}

	public Vehicle(String owner, String purchaseDate)
	{
		this.owner = owner;
		purchaseHistory.add(purchaseDate);
		purchased = true;
	}

	public String getOwner() 
	{
		return owner;
	}

	public boolean isPurchased() 
	{
		return purchased;
	}

	public String getPurchaseHistory() 
	{
		return ("Purchase Dates:" + purchaseHistory);
	}

	public void purchase(String newOwner, String purchaseDate) 
	{
		if (purchased) 
		{
			System.out.println("Already Purchased");
		}

		else 
		{
			owner = newOwner;
			purchaseHistory.add(purchaseDate);
			purchased = true;
		}
	}

	public void setOwner(String newOwner) 
	{
		owner = newOwner;
	}

	// forces all subclasses to have it's own toString() otherwise it wont compile.
	public abstract String toString();

}