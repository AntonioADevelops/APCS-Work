//I learned that an Abstract class and Interface are similar as they are forms of abstractions however an interface is more of a contract making it mandatory to override it's methods, 
// where as an abstract class is still a super class with the ability to create and implement methods to be inherited. 
// An abstract class however is not able to have an object made of it's class unlike a normal superclass and like an interface, 
// abstract methods make it mandatory for subclasses to override it. 
// The difference is multiple interfaces can be implemented where as you can only extend from one abstract class.
public class Inheritance {
    public static void main(String[] args) {
        Boat ssb = new Boat("Jerome Griff", "2/24/2021", 54, "Santa Barbara" , "Sailboat");
        System.out.println(ssb.isPurchased());
        System.out.println(ssb);

        Car tesla = new Car("Tesla", "Model S");
        System.out.println(tesla.honk());


    }
}
