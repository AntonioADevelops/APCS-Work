// Encapsulation is the control of access to data
public class EncapsulationNotes {

    // Class is a complex data type defined by a programmer
    // Represents somethign in the real world
    public class Employee {

        // Instance variables of the class aka. field, property, or isntance variable.
        // Almost always private so it can't be modified without using a constructor or method
        // Creates ownership relationships
        // Ex. Employee has a first name = firstName field
        private String firstName;
        private String lastName;
        private double salary;

        

        // This comment notation creates javadocs easily.
        /**
        * Creates an employee with the specified name and salary.
        * @param fn The employee’s first name.
        * @param ln The employee’s last name.
        * @param s The employee's annual salary.
        */

        // Constructor creates new objects
        // Called once when creating an object of the class
        // Ex. Employee fred = new Employee()
        public Employee(String firstName, String lastName, double salary)
        {
            // Use this.var to refer to the class variables if parameter and instance variables are called the same.
            // firstName = firstName set's firstName to itself
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public Employee(String fn, String ln)
        {
            // Dont have to set all fields
            // Unset field set to default
            // String or Other: null
            // int or double: 0
            // boolean: false
            firstName = fn;
            lastName = ln;
        }

        // Default No-Args Constructors.
        // Automatically added to classes without a constructor.
        // No-Args (No-Arguments) means no parameters.
        // Sets fields to default values: 0, false, null.
        public Employee() {
            firstName = null;
            lastName = null;
            salary = 0;
        }

        // Methods can be called upon to retrieve or modify an object's data
        // Methods that retrieve data are called accessor or "get" methods
        // Methods that modify data are called modifier, mutator, or "set" methods
        // Always public allowing access to data thats private to the class.
        public String getFirstName()
        {
            return firstName;
        }
        
        // Gets the employee’s last name.
        // @return A string representing the employee’s last name.
        public String getLastName()
        {
            return lastName;
        }
        
        // Gets the employee’s annual salary in USD.
        // * @return A double representing the employee’s annual salary in USD.
        public double getSalary()
        {
            return salary;
        }
        
        // Sets the employee’s first name.
        // @param newFirst A string representing the employee’s first name.
        public void setFirstName(String newFirst)
        {
            firstName = newFirst;
        }
        
        // Sets the employee’s last name.
        // @param newLast A string representing the employee’s last name.
        public void setLastName(String newLast)
        {
            lastName = newLast;
        }
        
        // Sets the employee’s annual salary.
        // @param newSalary A double representing the employee’s annual salary in USD.
        public void setSalary(double newSalary)
        {
            salary = newSalary;
        }
        
        // A regular method which neither retrieves or modifies data.
        // Call this method to print

        // Prints a sentence of the form "[this employee's name] has a meeting at [time] with [participants]."
        // @param time A string representing the time at which the meeting will take place.
        // @param participants A string representing the names of the participants in the meeting other than this employee.

        // Scope is the area of code in which variables exist.
        // Ex variable time exists only in the method scheduleMeetings.
        public void scheduleMeeting(String time, String participants)
        {
            System.out.println(firstName + " has a meeting at " + time + " with " + participants);
        }
    }
}