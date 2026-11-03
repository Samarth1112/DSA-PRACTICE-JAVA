package Arrays.Easy;/*
 * Problem: Maximum Consecutive Ones
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a binary array containing only 0s and 1s, find the maximum
 * number of consecutive 1s in the array.
 *
 * Examples:
 *
 * Example 1:
 * Input:  {1, 1, 0, 0, 1, 1, 1, 0}
 * Output: 3
 * Explanation: The longest consecutive sequence of 1s is {1, 1, 1}.
 *
 * Example 2:
 * Input:  {1, 1, 1, 1}
 * Output: 4
 *
 * Example 3:
 * Input:  {0, 0, 0}
 * Output: 0
 *
 * Example 4:
 * Input:  {}
 * Output: 0
 *
 * Approach:
 * 1. Initialize count = 0 to track the current consecutive sequence of 1s.
 * 2. Initialize maxCount = 0 to store the longest sequence found.
 * 3. Traverse the array:
 *    - If nums[i] == 1, increment count and update maxCount.
 *    - Otherwise, reset count to 0 because the sequence of 1s is broken.
 * 4. Return maxCount after processing the array.
 *
 * Java Code:
 * See the implementation below.
 *
 * Dry Run:
 * Input: {1, 1, 0, 0, 1, 1, 1, 0}
 *
 * Value | count | maxCount
 *   1   |   1   |    1
 *   1   |   2   |    2
 *   0   |   0   |    2
 *   0   |   0   |    2
 *   1   |   1   |    2
 *   1   |   2   |    2
 *   1   |   3   |    3
 *   0   |   0   |    3
 *
 * Output: 3
 *
 * Time Complexity: O(n) - each array element is checked once.
 * Auxiliary Space: O(1) - only two counters are used.
 *
 * Edge Cases:
 * 1. Empty array: returns 0.
 * 2. All zeroes: returns 0.
 * 3. All ones: returns nums.length.
 * 4. Single element {1}: returns 1.
 * 5. Single element {0}: returns 0.
 * 6. Consecutive ones at the beginning, middle, or end are handled.
 * 7. The method assumes the input is a binary array containing only 0s and 1s.
 *
 * Mistakes / Revision Notes:
 * 1. Reset count to 0 whenever a 0 is found.
 * 2. Update maxCount while counting 1s so the longest run is not lost.
 * 3. Do not reset maxCount when a 0 appears; earlier runs may be longer.
 * 4. Use Math.max(count, maxCount) to retain the maximum run.
 * 5. The algorithm scans the array once and uses constant extra space.
 */

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
