import java.util.Scanner;
public class Unit1Project { 
    //Unit Conversion Calculator
    public static void main(String[] args) {
        //Pick Calculator.
        Scanner scanCalcType = new Scanner(System.in); //create scanner object
        System.out.println("Type either of the following to select calculator: ft&miles, cylinder");
        String userCalcType = scanCalcType.nextLine();
        while (!userCalcType.equalsIgnoreCase("ft&miles") && !userCalcType.equalsIgnoreCase("cylinder")) {
            System.out.println("That is not a calculator option. Please try again.");
            userCalcType = scanCalcType.nextLine(); // Read user input 
        } 
        if (userCalcType.equalsIgnoreCase("ft&miles")) {
            //Feet to Miles conversion
            System.out.println("What are to converting from, Feet or Miles?");
            String userUnitType = scanCalcType.nextLine();  // Read user input
            while (!userUnitType.equalsIgnoreCase("feet") && !userUnitType.equalsIgnoreCase("ft") && !userUnitType.equalsIgnoreCase("miles") && !userUnitType.equalsIgnoreCase("mi")) {
                System.out.println("That is neither feet or miles, please try again.");
                userUnitType = scanCalcType.nextLine(); // Read user input 
            } 
            if (userUnitType.equalsIgnoreCase("feet") || userUnitType.equalsIgnoreCase("ft")) {
                System.out.println("Converting from Feet to Miles. Enter distance to be converted:"); // Confirm Output of Feet
                double conversionValue = scanCalcType.nextDouble(); // Read value to be converted
                System.out.print("Converting: " + conversionValue + "ft to Miles: ");  
                System.out.print(conversionValue /= 5280);// Output user input conversion
                System.out.println("mi");
                scanCalcType.close();
            }
            else if (userUnitType.equalsIgnoreCase("miles") || userUnitType.equalsIgnoreCase("mi")) {
                scanCalcType.close();
                System.out.println("Converting from Miles to Feet. Enter distance to be converted:"); // Confirm Output of Miles
                double conversionValue = scanCalcType.nextDouble(); // Read value to be converted
                System.out.print("Converting: " + conversionValue + "mi to Feet: ");  
                System.out.println(conversionValue *= 5280); // Output user input covnersion
                System.out.println("mi");
            }                        
        }

        if (userCalcType.equalsIgnoreCase("cylinder")) {
            System.out.println("Calculating cylinder volume.");
            System.out.println("Enter radius and height (rounded to nearest whole)");
            int r = scanCalcType.nextInt();  // Read user input
            int h = scanCalcType.nextInt();
            double pi = 3.14;
            double volume = pi * r * r * h;
            System.out.print("Cylinder Volume = ");
            System.out.print(volume);
        }
        scanCalcType.close();
    }
}
