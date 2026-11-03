package Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
/* - Insert every array element into a HashSet.
 * - A HashSet stores each value only once.
 * - Return set.size().
 * - This method counts distinct values; it does not modify arr.
 *
 * Approach 2: removeDuplicates2()
 * - Two-pointer approach for a SORTED array.
 * - i marks the index of the last distinct element.
 * - j scans the array from left to right.
        * - When arr[j] differs from arr[i], place it at arr[i + 1]
        *   and advance i.
 * - The first i + 1 positions contain the distinct values.
 *
         * Dry Run for removeDuplicates2():
        * Initial array: [0, 0, 3, 3, 5, 6], initially i = 0.
        * j = 1: arr[1] == arr[0] (0 == 0), skip.
 * j = 2: arr[2] != arr[0] (3 != 0), write 3 at index 1; i = 1.
        *        Array: [0, 3, 3, 3, 5, 6]
        * j = 3: arr[3] == arr[1] (3 == 3), skip.
 * j = 4: arr[4] != arr[1] (5 != 3), write 5 at index 2; i = 2.
        *        Array: [0, 3, 5, 3, 5, 6]
        * j = 5: arr[5] != arr[2] (6 != 5), write 6 at index 3; i = 3.
        *        Array: [0, 3, 5, 6, 5, 6]
        * Return i + 1 = 4. Valid portion: [0, 3, 5, 6].
        *
        * Approach 3: findDuplicates()
 * - Compare each element with the elements after it.
        * - Skip values that appeared earlier.
 * - Print a value when a later matching value is found.
        * - Each duplicated value is printed only once.
 *
         * Approach 4: printDuplicates()
 * - Skip an element if it has already appeared before.
 * - Count its occurrences in the complete array.
 * - Print it if its frequency is greater than one.
        *
        * Approach 5: uniqueEl()
 * - Insert all values into a HashSet.
        * - Copy the set values into a new array.
 * - This returns DISTINCT values, not values whose frequency is one.
 * - HashSet does not preserve a guaranteed iteration order.
        *
* Complexity:
* removeDuplicates(): Average time O(n), auxiliary space O(n).
* removeDuplicates2(): Time O(n), auxiliary space O(1).
 *   Requires a sorted input array.
 * findDuplicates(): Time O(n^2), auxiliary space O(1).
 * printDuplicates(): Time O(n^2), auxiliary space O(1).
 * uniqueEl(): Average time O(n), auxiliary space O(n).
 *
 * Edge Cases:
        * - Empty array: removeDuplicates2() returns 0.
        * - One element: returns 1.
        * - All elements equal: returns 1 for a non-empty array.
        * - No repeated values: returns arr.length.
 * - Negative numbers and zero are supported.
 * - removeDuplicates2() only works correctly when the array is sorted.
        *
 * Mistakes / Revision Notes:
        * 1. Do not confuse distinct elements with unique (frequency-one) elements.
        * 2. HashSet gives distinct values, not frequency-one values.
        * 3. The two-pointer method requires a sorted array.
        * 4. Handle an empty array before returning i + 1; otherwise it returns 1.
        * 5. After removeDuplicates2(), only the first returned-length positions
 *    are meaningful. Remaining positions may contain old values.
        * 6. HashSet does not guarantee iteration order.
*/


public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 3, 5, 6};

//        System.out.println("Distinct count using HashSet: "
//                + removeDuplicates(nums));

        int newLength = removeDuplicates2(nums);

        System.out.println("Duplicates:");
        printDuplicates(nums);

        System.out.println("Distinct elements in a new array:");
        System.out.println(Arrays.toString(uniqueEl(nums)));
    }

    // Counts distinct elements. Does not modify the original array.
    //Average time O(n), auxiliary space O(n).
    public static int removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set.size();
    }

    // Removes duplicates in-place from a SORTED array.
    // Returns the number of distinct elements.
    //Time O(n), auxiliary space O(1).
    public static int removeDuplicates2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }

        return i + 1;
    }

    // Prints each duplicated value only once.
    public static void findDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean seenBefore = false;

            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    seenBefore = true;
                    break;
                }
            }

            if (seenBefore) {
                continue;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    break;
                }
            }
        }
    }

    // Prints each duplicated value once by counting its frequency.
    public static void printDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean seenBefore = false;

            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    seenBefore = true;
                    break;
                }
            }

            if (seenBefore) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(arr[i]);
            }
        }
    }

    // Returns a new array containing DISTINCT values (not frequency-one values).
    public static int[] uniqueEl(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int[] newArr = new int[set.size()];
        int i = 0;

        for (int el : set) {
            newArr[i] = el;
            i++;
        }

        return newArr;
    }
}