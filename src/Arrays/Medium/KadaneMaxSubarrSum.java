
package Arrays.Medium;

/*
 * Problem: Maximum Subarray Sum
 * Problem Number: LeetCode 53
 * Topic: Arrays
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one element) which has the largest sum.
 * Return the maximum sum.
 *
 * Example:
 * Input:  [2, 3, 5, -2, 7, -4]
 * Output: 15
 *
 * Explanation:
 * Maximum subarray = [2, 3, 5, -2, 7]
 * Maximum sum = 2 + 3 + 5 - 2 + 7 = 15
 *
 * --------------------------------------------------
 * Approach 1: Brute Force (Three Loops)
 * --------------------------------------------------
 *
 * - Use i to select the starting index.
 * - Use j to select the ending index.
 * - Use k to calculate the sum from i to j.
 * - Update maxi whenever a larger sum is found.
 *
 * Time Complexity: O(n^3)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Approach 2: Better Brute Force (Two Loops)
 * --------------------------------------------------
 *
 * - Use i to select the starting index.
 * - Initialize sum = 0 for every starting index.
 * - Use j to extend the subarray.
 * - Add nums[j] to sum.
 * - Update maxi at every step.
 *
 * This avoids recalculating the sum using a third loop.
 *
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Approach 3: Kadane's Algorithm
 * --------------------------------------------------
 *
 * - Maintain currentSum and maxi.
 * - Add the current element to currentSum.
 * - Update maxi if currentSum is greater.
 * - If currentSum becomes negative, reset it to 0.
 *
 * Why reset?
 * A negative running sum decreases the sum of any future
 * subarray that includes it. Starting fresh is better.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Approach 4: Kadane's Algorithm (Print Subarray)
 * --------------------------------------------------
 *
 * - Maintain currentSum, maxi and start.
 * - When currentSum is 0, mark the potential start index.
 * - Add the current element.
 * - If currentSum is greater than maxi, update maxi,
 *   ansStart and ansEnd.
 * - If currentSum becomes negative, reset it to 0.
 *
 * This approach returns the maximum sum and also prints
 * the starting and ending indices of the subarray.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Dry Run:
 *
 * Array = [2, 3, 5, -2, 7, -4]
 *
 * Index   Element   Current Sum   Maximum Sum
 *  0         2          2              2
 *  1         3          5              5
 *  2         5         10             10
 *  3        -2          8             10
 *  4         7         15             15
 *  5        -4         11             15
 *
 * Maximum sum = 15
 * Starting index = 0
 * Ending index = 4
 * Maximum subarray = [2, 3, 5, -2, 7]
 *
 * --------------------------------------------------
 * Edge Cases:
 *
 * 1. All positive: [1, 2, 3] -> 6
 * 2. All negative: [-5, -2, -8] -> -2
 * 3. Single element: [5] -> 5
 * 4. Mixed values: [-2, 1, -3, 4] -> 4
 * 5. Zeros: [0, 0, 0] -> 0
 *
 * Mistakes / Revision Notes:
 *
 * 1. Use k <= j in Approach 1.
 * 2. Initialize maxi with Integer.MIN_VALUE.
 * 3. Do not reset maxi when currentSum becomes negative.
 * 4. Reset currentSum only, not maxi.
 * 5. Kadane's Algorithm works with negative, positive
 *    and zero values.
 * 6. Approach 4 tracks indices to print the subarray.
 */

public class KadaneMaxSubarrSum {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, -2, 7, -4};

        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray2(arr));
        System.out.println(maxSubArray3(arr));
        System.out.println(printMaxSubArray3(arr));
    }

    // Approach 1: Brute Force - Three Loops
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                maxi = Math.max(sum, maxi);
            }
        }

        return maxi;
    }

    // Approach 2: Better Brute Force - Two Loops
    public static int maxSubArray2(int[] nums) {

        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                maxi = Math.max(sum, maxi);
            }
        }

        return maxi;
    }

    // Approach 3: Kadane's Algorithm
    public static int maxSubArray3(int[] nums) {

        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }

    // Approach 4: Kadane's Algorithm - Print Subarray
    public static int printMaxSubArray3(int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < nums.length; i++) {

            // Potential starting index
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            // Update maximum sum and indices
            if (sum > maxi) {

                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // Reset negative running sum
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Max Subarray Sum = " + maxi);
        System.out.println("Starts at index = " + ansStart);
        System.out.println("Ends at index = " + ansEnd);

        System.out.print("Maximum Subarray = [");

        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i]);

            if (i < ansEnd) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        return maxi;
    }
}
