public class MathInJava {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //Integer Arithmetic
        int a = 5/2; //x gets the value 2. Decimal is dropped not rounded
        int b = 7/3; //y gets 2
        int c = 17/5; //z get 3
        double d = 5/2; //q gets 2.0 Interprets 5/2 as an integer operation adds x.0 as double
        double e = 5.0/2; //w gets 2.5 since a decimal was specified.

        //Modulo:"mod" Operator:%
        int f = 5%3; // 5/3 gives remainder of 2, 5%3 = 2
        f = 5%3; //"Five modulo three" or "Five mod three"
        int g = 20%2; // b = 0, no remainder
        int h = 21%2; // c = 1, 21/2 gives remainder of 1

        //Casting: Parenthesis, Casting, (Multiplicataion, Divison, Modulo), (Adition subtraction)
        int i = 3;
        double j = i; //automatic casting
        System.out.println(i); //prints 3
        System.out.println(j); //prints 3.0

        double k = 2.3;
        int l = (int) k; //cast to an int: the decimal is dropped, NOT rounded
        System.out.println(k); //prints 2.3
        System.out.println(l); //prints 2
        
        //Casting: Rounding
        double num1 = 5.8;
        double num2 = -5.8;
        int roundedPos = (int) (num1 + 0.5); //for positive
        int roundedNeg = (int) (num2 - 0.5); // for negative

        //Compound Assignment Operators and Increments
        int x = 1;
        x += 1; // x = x + 1
        x -= 1; // x = x - 1
        x *= 1; // x = x * 1
        x /= 1; // x = x / 1
        x %= 1; // x = x % 1
        x++; // x = x + 1
        x--; // x = x - 1

        //Minimum and Maximum int values
        int IntegerMIN_VALUE = (-2^31); //Minimum
        int IntegerMAX_VALUE = (2^31 - 1); //Maximum
        int smallest = Integer.MIN_VALUE;
        int largest = Integer.MAX_VALUE;
        //Integer overflow
        int largestOverflow = Integer.MAX_VALUE + 1; // largestOveflow = Integer.MIN_VALUE
        int smallestOverflow = Integer.MIN_VALUE - 1; // largestOveflow = Integer.MAX_VALUE

        //Math.Random setting the range
        int max = 11;
        int min = 10;
        int range;
        range = (max - min) + 1;     //inclusive
        range = (max - min); //exclusive
        int random = (int)(Math.random() * range) + min;
    }
}