import java.util.ArrayList;
public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(85);
        nums.add(12);
        nums.add(34);
        nums.add(61);
        nums.add(27);
        nums.add(91);
        nums.add(13);
        nums.add(8);
        nums.add(5);
        SelectionSort2(nums);
        System.out.print(nums);
    }

    public static void SelectionSort2 (ArrayList<Integer> a) {
        int smallestIndex = 0;

        //loop forward through the array
        for (int i = 0; i < a.size() - 1; i++) {
            smallestIndex = i;

            //Loop from i+1 to the end to find smallest value
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j) < a.get(smallestIndex)) {
                    smallestIndex = j;
                }
            }

            //swap value at i with the value of smallestIndex
            int temp = a.get(i);
            a.set(i, a.get(smallestIndex));
            a.set(smallestIndex, temp);
        }
    }
}
