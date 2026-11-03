package Arrays.Easy;/*
 * Problem: Check if Array Is Sorted
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Check whether the given array is sorted in non-decreasing order.
 * An array is sorted in non-decreasing order if every element is
 * less than or equal to the next element.
 *
 * Example 1:
 * Input:  {1, 2, 3, 4, 5}
 * Output: true
 *
 * Example 2:
 * Input:  {5, 4, 6, 7, 8}
 * Output: false
 *
 * Approach:
 * 1. Traverse the array from index 0 to arr.length - 2.
 * 2. Compare each element with the next element.
 * 3. If arr[i] > arr[i + 1], the array is not sorted, so return false.
 * 4. If no such pair is found, return true.
 *
 * Dry Run:
 * Input: {5, 4, 6, 7, 8}
 *
 * i = 0:
 * arr[i]     = 5
 * arr[i + 1] = 4
 * Since 5 > 4, return false.
 *
 * Output: false
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * Mistakes / Revision Notes:
 * 1. Use i < arr.length - 1, not i < arr.length, to avoid
 *    ArrayIndexOutOfBoundsException when accessing arr[i + 1].
 * 2. Use arr[i] > arr[i + 1] to check non-decreasing order.
 * 3. Return false immediately when an unsorted adjacent pair is found.
 * 4. Return true after the loop if no unsorted pair is found.
 * 5. Empty arrays and single-element arrays are considered sorted.
 * 6. Duplicate elements are allowed, e.g. {1, 2, 2, 3}.
 */

public class CheckSorted {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 7, 8};

        boolean ans = checkSorted(nums);

        System.out.println(ans);
    }

    public static boolean checkSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
