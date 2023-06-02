public class Teacher extends Person
{
  private String[] credentials;

  public Teacher(String name, String bDay, String[] creds)
  {
    super(name, bDay);
    //initialize credentials
    credentials = new String[creds.length];
    //copy all the elements from the parameter into the field
    for(int i = 0; i < creds.length; i++)
    {
      credentials[i] = creds[i];
    }
  }

  public boolean isCredentialedInSubject(String subject)
  {
    for(String c: credentials)
    {
      if(c.equals(subject))
      {
        return true;
      }
    }
    return false;
  }
}