package Arrays.Easy;/* Dry Run - Left Rotation by Reversal:
        * Input: {1, 2, 3, 4, 5}, k = 2
        * Initial:                 {1, 2, 3, 4, 5}
        * Reverse first 2:         {2, 1, 3, 4, 5}
        * Reverse remaining 3:     {2, 1, 5, 4, 3}
        * Reverse entire array:    {3, 4, 5, 1, 2}
        *
        * Time Complexity:
        * 1. leftRotateArrayByK(): O(n).
        * 2. leftRotateArrayByK2(): O(n).
        * 3. rightRotateByK(): O(n).
        * 4. reverse(): O(end - start + 1) for the selected range.
        *
        * Auxiliary Space:
        * 1. Temporary-array approach: O(k).
        * 2. Reversal approach: O(1).
        *
        * Edge Cases:
        * 1. Empty array: return before calculating k % n (avoids division by zero).
        * 2. Single-element array: remains unchanged.
        * 3. k = 0 or k = n: array remains unchanged.
        * 4. k > n: k % n gives the effective rotation count.
        * 5. Duplicate, zero, and negative array values work normally.
        *
        * Mistakes / Revision Notes:
        * 1. Check n == 0 before using k % n.
        * 2. This implementation assumes k is non-negative.
        * 3. Left reversal order: reverse(0, k-1), reverse(k, n-1),
        *    reverse(0, n-1).
        * 4. Right reversal order: reverse(n-k, n-1), reverse(0, n-k-1),
        *    reverse(0, n-1).
        * 5. The reverse method uses inclusive start and end indices.
        * 6. O(2n) simplifies to O(n).
        * 7. Reversal modifies the original array and uses constant extra space.
        */

import java.util.Arrays;

public class LeftRotateByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        leftRotateArrayByK2(arr, 2);
        System.out.println("Left rotation: " + Arrays.toString(arr));

        int[] rightArr = {1, 2, 3, 4, 5};
        rightRotateByK(rightArr, 2);
        System.out.println("Right rotation: " + Arrays.toString(rightArr));
    }

    // Left rotation using a temporary array: O(n) time, O(k) space.
    public static void leftRotateArrayByK(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        k = k % n;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        int num = 0;
        for (int i = n - k; i < n; i++) {
            nums[i] = temp[num];
            num++;
        }
    }

    // Left rotation using reversal: O(n) time, O(1) auxiliary space.
    public static void leftRotateArrayByK2(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        k = k % n;
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    // Right rotation using reversal: O(n) time, O(1) auxiliary space.
    public static void rightRotateByK(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        k = k % n;
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, 0, n - 1);
    }

    // Reverse elements between start and end (inclusive).
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
