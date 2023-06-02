public class Student extends Person
{
  private int studentID;
  private Teacher[] teachers;

  public Student(String name, String bDay, int id, Teacher[] teachers)
  {
    super(name, bDay);
    studentID = id;
    //initialize the teachers field
    this.teachers = new Teacher[teachers.length];
    //copy all the elements from the parameter into the field
    for(int i = 0; i < teachers.length; i++)
    {
      this.teachers[i] = teachers[i];
    }
  }

  public int getStudentID()
  {
    return studentID;
  }

  public Teacher getTeacherForPeriod(int period)
  {
    if(period < teachers.length)
    {
      return teachers[period];
    }
    return null;
  }

  public String toString()
  {
    return super.toString() + "\nStudent ID: " + studentID;
  }
}