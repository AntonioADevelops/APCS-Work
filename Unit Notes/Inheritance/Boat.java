public class Boat extends Vehicle
{
    private int numFish;
    private String dockLocation;
    private String type;

    public Boat(String owner, String purchaseDate, int numFishCaughtOnBoat, String dockLocation, String typeBoat)
    {
        super(owner, purchaseDate);
        numFish = numFishCaughtOnBoat;
        this.dockLocation = dockLocation;
        type = typeBoat;
    }

    public Boat(int numFishCaughtOnBoat, String dockLocation, String typeBoat)
    {
        numFish = numFishCaughtOnBoat;
        this.dockLocation = dockLocation;
        type = typeBoat;
    }

    public String toString() {
        if (super.isPurchased())
        {
            return ("This " + type + " is docked at " + dockLocation + " with a catch count of " + numFish + " fish, and is currently owned by " + super.getOwner() + ".");
        }
        return ("This " + type + " is docked at " + dockLocation + " with a catch count of " + numFish + " fish, and is currently up for sale.");
    }
}