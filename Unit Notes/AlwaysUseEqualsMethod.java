public class AlwaysUseEqualsMethod {
    public static void main(String[] args) {
        //String literals
        String pathway = "incomplete";
        String aToG = "met";
        //String Objects
        String pathwayObj = new String("complete");
        String aToGObj = new String("met");
        //if statement with literals: prints "You're college and career ready!" Operator == doesnt always work as it can be configured to not look for data position
        if (pathway == "compeleted" || aToG == "met") {
            System.out.println("You're college and career ready!");
        }
        else {
            System.out.println("Keep working hard.");
        }
        //if statement with objects "Keep working hard."
        if (pathwayObj == "compeleted" || aToGObj == "met") {
            System.out.println("You're college and career ready!");
        }
        else {
            System.out.println("Keep working hard.");
        }
    }
}
