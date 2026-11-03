package Arrays.Easy;/*
        * i = 0: Insert 0 at index 0 -> [0]
        * i = 1: Insert 1 at index 1 -> [0, 1]
        * i = 2: Insert 2 at index 2 -> [0, 1, 2]
        * i = 3: Insert 3 at index 2 -> [0, 1, 3, 2]
        * i = 4: Insert 4 at index 1 -> [0, 4, 1, 3, 2]
        *
        * Output: {0, 4, 1, 3, 2}
        *
        * Time Complexity:
        * O(n^2) - inserting at an arbitrary ArrayList index may shift elements.
        * Across n insertions, the total shifting can take O(n^2) time.
        * Copying the list into the target array takes O(n) time.
        *
        * Auxiliary Space:
        * O(n) - the ArrayList and returned target array each store n elements.
        *
        * Edge Cases:
        * 1. Empty arrays: returns an empty target array.
        * 2. Single element: nums = {1}, index = {0} returns {1}.
        * 3. Insert at index 0: the new element becomes the first element.
        * 4. Insert at the end: the new element is appended.
        * 5. Repeated insertion positions: existing elements shift right.
        * 6. The problem guarantees equal input lengths and valid insertion indices.
        *
        * Mistakes / Revision Notes:
        * 1. Use list.add(index[i], nums[i]), not list.add(nums[i]).
        * 2. add(position, value) inserts at that position and shifts elements right.
        * 3. Process nums and index from left to right, in the given order.
        * 4. ArrayList<Integer> uses boxing when adding int values and unboxing
        *    when assigning list.get(i) to an int.
        * 5. Convert the ArrayList to int[] because the method returns an int array.
        * 6. Arbitrary-index ArrayList insertion is not O(1); shifting makes the
        *    overall approach O(n^2).
        */

import java.util.ArrayList;
import java.util.Arrays;

public class CreateTargetArrAL {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};

        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = list.get(i);
        }

        return target;
    }
}
