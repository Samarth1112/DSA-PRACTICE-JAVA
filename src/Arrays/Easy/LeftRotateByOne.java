package Arrays.Easy;/*
 * Problem: Left Rotate an Array by One
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array, rotate it to the left by one position.
 * The first element moves to the last position, and every other
 * element moves one position to the left.
 *
 * Examples:
 *
 * Example 1:
 * Input:  {1, 2, 3, 4, 5}
 * Output: {2, 3, 4, 5, 1}
 *
 * Example 2:
 * Input:  {10}
 * Output: {10}
 * Explanation: Rotating a one-element array does not change it.
 *
 * Example 3:
 * Input:  {}
 * Output: {}
 * Explanation: An empty array remains empty.
 *
 * Approach:
 * 1. Store the first element in a temporary variable.
 * 2. Traverse the array from index 1 to the last index.
 * 3. Move each element one position to the left using arr[i - 1] = arr[i].
 * 4. Place the saved first element at the last index.
 *
 * Java Code:
        * See the implementation below.
        *
        * Dry Run:
        * Input: {1, 2, 3, 4, 5}
        *
        * temp = arr[0] = 1
        *
        * i = 1: arr[0] = arr[1] -> {2, 2, 3, 4, 5}
        * i = 2: arr[1] = arr[2] -> {2, 3, 3, 4, 5}
        * i = 3: arr[2] = arr[3] -> {2, 3, 4, 4, 5}
        * i = 4: arr[3] = arr[4] -> {2, 3, 4, 5, 5}
        *
        * Place temp at arr[n - 1]:
        * arr[4] = 1
        *
        * Output: {2, 3, 4, 5, 1}
        *
        * Time Complexity: O(n) - the array is traversed once.
        * Auxiliary Space: O(1) - only one temporary variable is used.
        *
        * Edge Cases:
        * 1. Empty array: return without accessing arr[0].
        * 2. Single-element array: remains unchanged.
        * 3. Two-element array: {1, 2} becomes {2, 1}.
        * 4. Negative numbers and zero: handled normally.
        *
        * Mistakes / Revision Notes:
        * 1. Save arr[0] before shifting; otherwise its value is lost.
        * 2. Start the loop at i = 1 because arr[0] is filled from arr[1].
        * 3. Use arr[i - 1] = arr[i] to shift each element left.
        * 4. Place the saved first element at arr[n - 1].
        * 5. Check for an empty array before accessing arr[0].
        * 6. The method modifies the original array in place.
        */

import java.util.Arrays;

public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        rotateArrayByOne(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void rotateArrayByOne(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        int temp = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }
}
