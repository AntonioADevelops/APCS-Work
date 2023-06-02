public class IterationNotes {
    public static void main(String[] args) {
        // Iteration: repeat a process (while & for loops)
        // While Loops: repeat until condition is met.
        boolean x = false;
        while (x == false) { // loop header
            x = true; // loop body
        }

        // For Loops: repeat for specified amount of times.
        int i;
        for (i=0; i<8; i++) {
            System.out.println("Hi");
        }

        // Enhanced for loop / for each loop
        // Can only go forwards.
        // # of loops is equal to array.length.
        // For each item in words, creates a copy of the "remote control" (w) pointing to the object at words[each position]. 
        // Cannot change the location at which the position is pointing to but can change the objects' values.
        // Ex. Cannot make words[1] point to a different object. 
        Employee[] employees = {new Employee("Bob", "Smith"), new Employee("Jeremy", "Hoff"), new Employee("Samantha", "Green")};
        for (Employee e: employees) {
            // Changes the first name of the employee object at employees[each position] and prints each object in employees[].
            e.setFirstName("Henry");
            System.out.println(e);

            // Prints null for words.length but does not set employees[each position] = null.
            e = null; 
            System.out.println(e);        
        }
    }
}
