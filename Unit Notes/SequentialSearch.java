import java.util.ArrayList;
public class SequentialSearch {
    //returns the first index of the target string in words, or -1 if it is not found
    public static int sequentialSearch(ArrayList<String> words, String target)
    {
      for(int i = 0; i < words.size(); i++)
      {
        if(target.equals(words.get(i)))
        {
          return i;//return the index of the target
        }
      }
    
      //If we reach here, then the target was not present 
      return -1; 
    }
    public static void main(String[] args) {
        ArrayList<String> months = new ArrayList<String>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        int location = sequentialSearch(months, "November");
        System.out.println(location);
        location = sequentialSearch(months, "Ḏḥwtyt");//Ḏḥwtyt was the first month of the ancient Egyptian calendar
        System.out.println(location);
      }
    }
