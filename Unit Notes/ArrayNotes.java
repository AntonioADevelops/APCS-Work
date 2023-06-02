public class ArrayNotes {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Creates an array with 5 places for values set to default 0 as they have not been initialized. {0, 0, 0, 0, 0}
        int[] x = new int[5];

        // Creates an array with 5 places for values set to {1, 2, 3, 4, 5} respectively
        int[] y = {1, 2, 3, 4, 5};

        // Creates null as the array object has not been initialized
        int[] z;

        // Passing reference to array nums
        // Once method1 is called and code is finished, input array no longer exists but nums records the change to position 2
        int[] nums = new int[3];
        method1(nums);
    }
    public static void method1(int[] input) {
        input[2] = 21;
    }
}
