public class Person
{
  private String name;
  private String birthday;

  public Person(String n, String b)
  {
    name = n;
    birthday = b;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String newName)
  {
    name = newName;
  }

  public String getBirthday()
  {
    return birthday;
  }

  public String toString()
  {
    return "Name: " + name + "\nBirthday: " + birthday;
  }

  public boolean hasSameName(Person other)
  {
    return this.name.equals(other.name);
  }
}