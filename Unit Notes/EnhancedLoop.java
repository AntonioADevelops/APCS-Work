public class EnhancedLoop {
    public static void main(String[] args) {

        boolean[] myArray = new boolean[10];
        System.out.println("Print using a regular for loop:");
        
        for(int i = 0; i < myArray.length; i++) {
            System.out.println(i + ": " + myArray[i]);
        }
        System.out.println("Print using an enhanced for loop:");
        
        for(boolean b: myArray) {
            b = true;
            System.out.println(b);
        }

        // No change to myArray as changing b does not affect myArray
        for (boolean b: myArray) {
            System.out.println(b);
        }

        Employee[] employees = new Employee[3];

        for (Employee e: employees) {
            System.out.println(e);
        }
        
        // Set to default value null as the values in the array have not been initialized.

        employees[0] = new Employee("Bob", "Smith");
        employees[1] = new Employee("Jeremy", "Hoff");
        employees[2] = new Employee("Samantha", "Green");

        for (Employee e: employees) {
            System.out.println(e);
        }

        for (Employee e: employees) {
            e.setFirstName("Henry");
            System.out.println(e);
        }

        for (Employee e: employees) {
            System.out.println(e);
        }

        for (Employee e: employees) {
            e = null;
            System.out.println(e);
        }

        for (Employee e: employees) {
            System.out.println(e);
        }
  }

  /*
  Directions:
  1. In the enhanced for loop above, change the value of b before printing it.  Then add a loop after the enhanced for loop that prints the values in myArray again.  Did changing the value of b change the values in myArray?  Why do you think this is?
  2. Create an array of 3 Employee objects.
  3. Print the values in the array.  Why are they null?
  4. Initialize each value in the array by calling the Employee constructor.  Then write an ENHANCED for loop to print all the values again.  Notice that the toString method of the Employee class is called automatically when you print an Employee object.
  5. In your enhanced for loop from step 4, use your loop variable to call the setFirstName method for each Employee.  Notice what is printed by this loop now.  Draw a stack frame and memory model like the ones in the videos yesterday to illustrate how this happens.
  */
}
