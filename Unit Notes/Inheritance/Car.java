public class Car extends Vehicle
{
    private String brand;
    private String model;
    private String horn = "Tuut Tuut!";

    public Car(String owner, String purchaseDate, String brand, String model)
    {
        super(owner, purchaseDate);
        this.brand = brand;
        this.model = model; 
    }

    public Car(String brand, String model)
    {
        super();
        this.brand = brand;
        this.model = model; 
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public String honk() 
	{
		return horn;
	}

	public void setHorn(String horn) 
	{
		this.horn = horn;
	}

    public String toString() {
        if (super.isPurchased())
        {
            return ("This" + brand + " " + model + " is owned by " + super.getOwner());
        }
        return ("This " + brand + " " + model + " is up for sale.");
    }
}