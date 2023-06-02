import java.util.ArrayList;
@SuppressWarnings("unused")
public class Delimiters
{
    /** The open and close delimiters. */
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     * close delimiter.
     * Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens)
    { 
    ArrayList<String> delimiters = new ArrayList<String>();
        for (String d: tokens) 
        {
            if (d == openDel || d == closeDel) 
            {
            delimiters.add(d);
            }
        }
        return delimiters;
    }

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     * Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        int numOpen = 0;
        int numClosed = 0;
        for (String s : delimiters) {
            if (s.equals(openDel)) {
                numOpen++;
            }
            if (s.equals(closeDel)) {
                numClosed++;
            }
            if (numClosed > numOpen) {
                return false;
            }
        }
        return numOpen == numClosed;
      }
    
    // Get type of delimiter.
    // Ex. <p> = html delimiter
    public String getType() 
    {
        String d = toString();
        boolean html = false;
        boolean math = false;
        for (int i = 0; i < d.length(); i++) 
        {
            if (d.substring(i, i+1).equals("<")) 
            {
                html = true;
            }
            if (d.substring(i, i+1).equals("(")) {
                math = true;

            }
        }
        if (html) 
        {
            return "html delimiter";
        }

        else if (math) 
        {
            return "math delimiter";
        }

        else 
        {
            return "unknown";
        }
        
    }
    // Return the delimiter as a String.
    public String toString()
    { 
        return (openDel + closeDel);
    }
  // There may be instance variables, constructors, and methods that are not shown.
} 