package Arrays.Easy;
/*
 * Problem: Reverse an Array
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Reverse the elements of an array in place.
 *
 * Approach:
 * Use two pointers: left starts at index 0,
 * and right starts at the last index.
 * Swap arr[left] and arr[right], then move
 * left forward and right backward.
 * Repeat until left >= right.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * Mistakes / Revision Notes:
 * 1. Last index is arr.length - 1.
 * 2. Use left < right as the loop condition.
 * 3. Use a temporary variable to swap values.
 * 4. Move both pointers after each swap.
 */

import java.util.Arrays;

class ReverseArray {
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        reverse(arr);

        System.out.println(Arrays.toString(arr));
    }
}
