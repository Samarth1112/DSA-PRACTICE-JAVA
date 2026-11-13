
/*
 * Problem: Next Permutation
 * LeetCode: 31
 * Topic: Arrays
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers, rearrange it into the next
 * lexicographically greater permutation.
 *
 * If no greater permutation exists, rearrange the array
 * into its lowest possible order (ascending order).
 *
 * The rearrangement must be done in-place.
 *
 * Example 1:
 * Input:  [1, 2, 3]
 * Output: [1, 3, 2]
 *
 * Example 2:
 * Input:  [3, 2, 1]
 * Output: [1, 2, 3]
 *
 * Example 3:
 * Input:  [1, 1, 5]
 * Output: [1, 5, 1]
 *
 * Approach: Pivot and Reversal
 *
 * Step 1: Find the Pivot
 * Traverse the array from right to left.
 * Find the first index where nums[i] < nums[i + 1].
 * This index is called the pivot.
 *
 * Step 2: Handle No Pivot
 * If pivot remains -1, the array is in descending order.
 * Reverse the entire array and return.
 *
 * Step 3: Find the Next Greater Element
 * Traverse from the right side of the array.
 * Find the first element greater than nums[pivot].
 * Swap it with the pivot element.
 *
 * Step 4: Reverse the Suffix
 * Reverse all elements after the pivot.
 * This produces the smallest possible suffix and
 * therefore the immediate next permutation.
 *
 * Dry Run:
 * Input: [1, 2, 3, 6, 5, 4]
 *
 * Step 1:
 * Start checking from right to left.
 * 5 > 4, so continue.
 * 6 > 5, so continue.
 * 3 < 6, therefore pivot index = 2.
 * Pivot value = 3.
 *
 * Step 2:
 * Find the rightmost element greater than 3.
 * Element = 4.
 *
 * Step 3:
 * Swap 3 and 4.
 * Array = [1, 2, 4, 6, 5, 3]
 *
 * Step 4:
 * Reverse the suffix after pivot.
 * Suffix [6, 5, 3] becomes [3, 5, 6].
 *
 * Final Output:
 * [1, 2, 4, 3, 5, 6]
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * Edge Cases:
 * 1. Already ascending array: [1, 2, 3]
 * 2. Descending array: [3, 2, 1]
 * 3. Duplicate elements: [1, 1, 5]
 * 4. Single element: [1]
 *
 * Mistakes / Revision Notes:
 * 1. Traverse from right to left when finding the pivot.
 * 2. Use i--, not i++, in reverse traversal.
 * 3. If pivot == -1, reverse the entire array and return.
 * 4. Find the rightmost element greater than the pivot.
 * 5. Use break after swapping.
 * 6. Reverse only the suffix after the pivot.
 * 7. The algorithm modifies the original array in-place.
 */

package Arrays.Medium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {1, 2, 3, 6, 5, 4};

        nextPermutation(nums);
        nextPermutation(nums2);
        nextPermutation(nums3);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot exists
        if (pivot == -1) {
            reverseArr(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the rightmost greater element
        for (int i = n - 1; i > pivot; i--) {

            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4: Reverse the suffix
        reverseArr(nums, pivot + 1, n - 1);
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverseArr(int[] arr, int i, int j) {

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
