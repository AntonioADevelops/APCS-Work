/** 
 * Represents an employee.
 * @author Mrs. Adams
*/
public class Employee {
	private String firstName;
	private String lastName;
	/**
	 * The employee's annual salary in USD.
	 */
	private double salary;
	
	/** 
	 * Creates an employee with the specified name
	 * and salary.
	 *
 	 * @param fn The employee’s first name.
 	 * @param ln The employee’s last name.
 	 * @param s The employee's annual salary.
	 */
	public Employee(String fn, String ln, double s) {
		firstName = fn;
		lastName = ln;
		salary = s;
	}
	
	/** 
	 * Creates an employee with the specified name.
	 * The salary is set to 0.
	 *
 	 * @param fn The employee’s first name.
 	 * @param ln The employee’s last name.
	 */
	public Employee(String fn, String ln) {
		firstName = fn;
		lastName = ln;
	}
	
	/** 
	 * Gets the employee’s first name.
	 *
	 * @return A string representing the employee’s first
	 *         name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/** 
	 * Gets the employee’s last name.
	 *
	 * @return A string representing the employee’s last
	 *         name.
	 */
	public String getLastName()  {
		return lastName;
	}
	
	/** 
	 * Gets the employee’s annual salary in USD.
	 *
	 * @return A double representing the employee’s annual
	 * 	       salary in USD.
	 */
	public double getSalary() {
		return salary;
	}
	
	/** 
	 * Sets the employee’s first name.
	 *
	 * @param newFirst A string representing the employee’s
	 *                 first name.
	 */
	public void setFirstName(String newFirst) {
		firstName = newFirst;
	}
	
	/** 
	 * Sets the employee’s last name.
	 *
	 * @param newLast A string representing the employee’s
	 *                 last name.
	 */
	public void setLastName(String newLast) {
		lastName = newLast;
	}
	
	/** 
	 * Sets the employee’s annual salary.
	 *
	 * @param newSalary A double representing the employee’s
	 *                 annual salary in USD.
	 */
	public void setSalary(double newSalary) {
		salary = newSalary;
	}
	
	/** 
	 * Prints a sentence of the form "[this employee's name] 
	 * has a meeting at [time] with [participants]."
	 *
	 * @param time A string representing the time at 
	 *             which the meeting will take place.
	 * @param participants A string representing the 
	 *                     names of the participants 
	 *                     in the meeting other than 
	 *                     this employee.
	 */
	public void scheduleMeeting(String time, String participants) {
		System.out.println(firstName + " has a meeting at " + time + " with " + participants);
	}

  /** 
	 * Returns the employee's first and last name
	 *
	 * @return A string with the employee's first name 
   * followed by the empolyee's last name
	 */
  public String toString() {
    return firstName + " " + lastName;
  }
}
