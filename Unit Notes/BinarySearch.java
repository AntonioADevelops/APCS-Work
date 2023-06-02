import java.util.ArrayList;
public class BinarySearch {
    public static void main(String[] args) 
  {
    ArrayList<String> animals = new ArrayList<String>();
    animals.add("Anteater");
    animals.add("Bear");
    animals.add("Elephant");
    animals.add("Giraffe");
    animals.add("Lion");
    animals.add("Panther");
    animals.add("Rhinoceros");
    animals.add("Turtle");

    int location = binarySearch(animals, "Rhinoceros");
    System.out.println(location);

    location = binarySearch(animals, "Flamingo");
    System.out.println(location);
  }

  /**
    * Precondition: words is sorted alphabetically/lexicographically 
    * Lexicographically is alphabetically but all captial letter preceed all lowercase letters. A-Z comes before a-z.
  */
  public static int binarySearch(ArrayList<String> words, String target)
  {
    int left = 0;
    int right = words.size() - 1; 
    while (left <= right) 
    { 
      int middle = left+ (right-left) / 2; 
  
      //Check if the target is present at middle 
      if (words.get(middle).equals(target)) 
          return middle; 

      //If target comes later lexicographically, ignore left half 
      if (target.compareTo(words.get(middle)) > 1) 
          left = middle + 1; 
      // If target comes earlier lexicographically, ignore right half 
      else
          right = middle - 1; 
    } 
  
    //If we reach here, then the target was not present 
    return -1; 
  }
}
