package Arrays.Medium;

import java.util.Arrays;

/*
 * Problem: Sort Colors / Sort Zero One Two
 * Problem Number: LeetCode 75
 * Topic: Arrays, Counting, Three Pointers, Dutch National Flag Algorithm
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array containing only 0s, 1s, and 2s, sort the array in-place
 * so that all 0s come first, followed by all 1s, and then all 2s.
 *
 * Example 1:
 * Input:  nums = [1, 0, 2, 1, 0]
 * Output: nums = [0, 0, 1, 1, 2]
 *
 * Example 2:
 * Input:  nums = [2, 0, 1]
 * Output: nums = [0, 1, 2]
 *
 * ------------------------------------------------------------
 * APPROACH 1: COUNTING (Three Passes)
 * ------------------------------------------------------------
 * 1. Create three counters: count0, count1, and count2.
 * 2. Traverse the array and count how many 0s, 1s, and 2s exist.
 * 3. Overwrite the first count0 positions with 0.
 * 4. Overwrite the next count1 positions with 1.
 * 5. Fill all remaining positions with 2.
 *
 * Dry Run:
 * Input: [1, 0, 2, 1, 0]
 *
 * Counting pass:
 * count0 = 2, count1 = 2, count2 = 1
 *
 * Rewrite pass:
 * Indices 0 to 1     -> 0: [0, 0, 2, 1, 0]
 * Indices 2 to 3     -> 1: [0, 0, 1, 1, 0]
 * Remaining index 4  -> 2: [0, 0, 1, 1, 2]
 *
 * Time Complexity: O(n) - one counting traversal and one rewriting traversal.
 * Auxiliary Space: O(1) - only three counters are used.
 *
 * ------------------------------------------------------------
 * APPROACH 2: DUTCH NATIONAL FLAG ALGORITHM (One Pass)
 * ------------------------------------------------------------
 * Use three pointers:
 * low  = next position where a 0 should be placed.
 * mid  = current element being examined.
 * high = next position where a 2 should be placed.
 *
 * Initially: low = 0, mid = 0, high = nums.length - 1.
 *
 * While mid <= high:
 *
 * 1. If nums[mid] == 0:
 *    Swap nums[low] and nums[mid].
 *    Increment both low and mid.
 *
 * 2. If nums[mid] == 1:
 *    The element is already in the middle region.
 *    Increment mid.
 *
 * 3. If nums[mid] == 2:
 *    Swap nums[mid] and nums[high].
 *    Decrement high only.
 *
 * IMPORTANT:
 * Do not increment mid in the nums[mid] == 2 case. The element swapped
 * from the high position has not been examined yet.
 *
 * Dry Run:
 * Input: [1, 0, 2, 1, 0]
 *
 * Start: low = 0, mid = 0, high = 4
 *
 * 1. nums[mid] = 1 -> mid++
 *    Array: [1, 0, 2, 1, 0]
 *    low = 0, mid = 1, high = 4
 *
 * 2. nums[mid] = 0 -> swap(nums, low, mid), low++, mid++
 *    Array: [0, 1, 2, 1, 0]
 *    low = 1, mid = 2, high = 4
 *
 * 3. nums[mid] = 2 -> swap(nums, mid, high), high--
 *    Array: [0, 1, 0, 1, 2]
 *    low = 1, mid = 2, high = 3
 *
 * 4. nums[mid] = 0 -> swap(nums, low, mid), low++, mid++
 *    Array: [0, 0, 1, 1, 2]
 *    low = 2, mid = 3, high = 3
 *
 * 5. nums[mid] = 1 -> mid++
 *    Array: [0, 0, 1, 1, 2]
 *    low = 2, mid = 4, high = 3
 *
 * Stop because mid > high.
 *
 * Time Complexity: O(n) - each element is examined a constant number of times.
 * Auxiliary Space: O(1) - sorting is performed in-place.
 *
 * ------------------------------------------------------------
 * COMPARISON
 * ------------------------------------------------------------
 * Counting approach:
 * - Time: O(n)
 * - Auxiliary Space: O(1)
 * - Uses two traversals: count values, then overwrite the array.
 *
 * Dutch National Flag approach:
 * - Time: O(n)
 * - Auxiliary Space: O(1)
 * - Uses one traversal and rearranges elements through swaps.
 *
 * EDGE CASES:
 * - Empty array: both methods leave it unchanged.
 * - One-element array: remains unchanged.
 * - All 0s, all 1s, or all 2s: both methods work.
 * - Mixed values: both methods sort the array.
 *
 * ASSUMPTION:
 * The input contains only 0, 1, and 2. In Approach 1, the final else
 * counts every value other than 0 or 1 as a 2, so this constraint matters.
 *
 * MISTAKES / REVISION NOTES:
 * - In the counting approach, make sure the second loop starts at count0
 *   and the third loop starts at count0 + count1.
 * - In the Dutch National Flag approach, the loop condition is mid <= high.
 * - When nums[mid] == 2, decrement high but do not increment mid.
 * - When nums[mid] == 0, increment both low and mid.
 * - The swap helper exchanges two array elements using a temporary variable.
 */

public class SortZeroOneTwo {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};

        // Choose either approach. Each method modifies the array in-place.
        sortZeroOneTwo2(nums);

        System.out.println(Arrays.toString(nums));
    }

    // Approach 1: Counting - O(n) time and O(1) auxiliary space.
    public static void sortZeroOneTwo(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int n : nums) {
            if (n == 0) {
                count0++;
            } else if (n == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }

        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    // Approach 2: Dutch National Flag Algorithm - O(n) time and O(1) space.
    public static void sortZeroOneTwo2(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper method to swap two elements in the array.
    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
