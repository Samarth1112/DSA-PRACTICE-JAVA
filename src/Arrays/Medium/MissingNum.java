package Arrays.Medium;

/*
 * Problem: Find Missing Number
 * Problem Number: 268 (LeetCode) / 116 (takeUforward practice)
 * Topic: Arrays, Mathematics, Bit Manipulation
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array nums containing N distinct numbers in the range [0, N],
 * return the only number in this range that is missing from the array.
 *
 * Example 1:
 * Input: nums = [3, 0, 1]
 * Output: 2
 * Explanation: The complete range is [0, 1, 2, 3]. Only 2 is missing.
 *
 * Example 2:
 * Input: nums = [0, 1]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
 * Output: 8
 *
 * Approach 1: Brute Force (missingNumber)
 * - For every number i from 0 to N, search the complete array.
 * - If the number is not found, return i.
 *
 * Dry Run:
 * nums = [3, 0, 1], N = 3
 * i = 0: found at index 1 -> continue.
* i = 1: found at index 2 -> continue.
        * i = 2: not found -> return 2.
        *
        * Complexity: Time O(N^2), Auxiliary Space O(1).
        *
  * Approach 2: Sum Formula (missingNumber2)
  * - Expected sum of numbers from 0 to N = N * (N + 1) / 2.
        * - Calculate the actual sum of the array.
        * - Subtract actual sum from expected sum.
        *
        * Dry Run:
        * nums = [3, 0, 1], N = 3
        * Expected sum = 3 * 4 / 2 = 6.
        * Actual sum = 3 + 0 + 1 = 4.
        * Missing number = 6 - 4 = 2.
        *
        * Complexity: Time O(N), Auxiliary Space O(1).
        *
  * Approach 3: XOR (missingNumber3)
  * - XOR every number from 0 to N into xor1.
        * - XOR every array element into xor2.
        * - Since x ^ x = 0 and x ^ 0 = x, matching values cancel.
  * - The remaining value is the missing number.
  *
          * Dry Run:
        * nums = [3, 0, 1], N = 3
        * xor1 = 0 ^ 0 ^ 1 ^ 2 ^ 3 = 0
        * xor2 = 0 ^ 3 ^ 0 ^ 1 = 2
        * Answer = xor1 ^ xor2 = 2.
        *
        * Complexity: Time O(N), Auxiliary Space O(1).
        *
        * Edge Cases:
        * - Missing number is 0: [1, 2, 3] -> 0.
        * - Missing number is N: [0, 1, 2] -> 3.
        * - Single element: [0] -> 1, and [1] -> 0.
        *
        * Mistakes / Revision Notes:
        * 1. Start the brute-force outer loop at 0 because 0 can be missing.
  * 2. Use i <= N because N can be missing.
        * 3. Use j < N to inspect every valid array index.
        * 4. Use long for sum calculations to avoid integer overflow for large N.
        * 5. In XOR, include N as well as indices 0 through N-1.
        * 6. Assumes exactly one value is missing and all other values are distinct
  *    and lie in the range [0, N].
        */

public class MissingNum {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};

        System.out.println("Brute Force: " + missingNumber(nums));
        System.out.println("Sum Formula: " + missingNumber2(nums));
        System.out.println("XOR: " + missingNumber3(nums));
    }

    // Approach 1: Brute Force
    public static int missingNumber(int[] nums) {
        int N = nums.length;

        for (int i = 0; i <= N; i++) {
            int flag = 0;

            for (int j = 0; j < N; j++) {
                if (nums[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                return i;
            }
        }

        return -1;
    }

    // Approach 2: Sum Formula
    public static int missingNumber2(int[] nums) {
        int N = nums.length;
        long sum = (long) N * (N + 1) / 2;
        long sum2 = 0;

        for (int i = 0; i < N; i++) {
            sum2 += nums[i];
        }

        return (int) (sum - sum2);
    }

    // Approach 3: XOR
    public static int missingNumber3(int[] nums) {
        int N = nums.length;
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < N; i++) {
            xor1 ^= i;
            xor2 ^= nums[i];
        }

        xor1 ^= N;

        return xor1 ^ xor2;
    }
}
