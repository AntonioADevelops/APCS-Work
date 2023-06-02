public class Main
{
  public static void main(String[] args) 
  {
    //poly = many
    //morph = shape
    //polymorphism = the ability to take on many forms

    String[] c = {"physics, physical education"};
    Person t = new Teacher("Ms. Doe", "January 1, 1980", c);//t is a polymorphic object because it passes the "IS-A" test for more than one class (both Teacher and Person)
    System.out.println(t); 
    System.out.println();

    Teacher[] ts = {(Teacher)t};//only one teacher
    Student s = new Student("Jackson", "November 18, 2004", 804581, ts);
    System.out.println(s.getStudentID());
    System.out.println();

    Person s2 = new Student("Jesse", "May 17, 2005", 127428, ts);
    System.out.println(s2);
    System.out.println(((Student)s2).getStudentID());
    System.out.println();

    System.out.println(s2.hasSameName(s));
  }
}