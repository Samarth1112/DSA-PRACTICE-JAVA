package Arrays.Easy;/*
 * Problem: Find the Highest Altitude
 * Problem Number: LeetCode 1732
 * Topic: Arrays, Prefix Sum
 * Difficulty: Easy
 *
 * Problem Statement:
 * A biker starts a trip at altitude 0. The integer array gain contains
 * the net altitude change between consecutive points.
 * Return the highest altitude reached, including the starting altitude.
 *
 * Examples:
 * Example 1:
 * Input:  gain = {-5, 1, 5, 0, -7}
 * Altitudes: {0, -5, -4, 1, 1, -6}
 * Output: 1
 *
 * Example 2:
 * Input:  gain = {-4, -3, -2, -1, 4, 3, 2}
 * Altitudes: {0, -4, -7, -9, -10, -6, -3, -1}
 * Output: 0
 *
 * Approach:
 * 1. Initialize sum = 0 because the starting altitude is 0.
 * 2. Initialize max = 0 to include the starting altitude in the answer.
 * 3. Traverse the gain array.
 * 4. Add gain[i] to sum to calculate the current altitude.
 * 5. Update max using Math.max(max, sum).
 * 6. Return max after processing all gains.
 *
 * Dry Run:
 * Input: gain = {-5, 1, 5, 0, -7}
 *
 * Starting altitude = 0
 * gain[i] | Current altitude (sum) | Maximum altitude (max)
 *   -5    |          -5            |          0
 *    1    |          -4            |          0
 *    5    |           1            |          1
 *    0    |           1            |          1
 *   -7    |          -6            |          1
 *
 * Output: 1
 *
 * Time Complexity: O(n) - each gain element is visited once.
 * Auxiliary Space: O(1) - only sum and max variables are used.
 *
 * Edge Cases:
 * 1. Empty gain array: returns 0 because the biker stays at altitude 0.
 * 2. All negative gains: returns 0 because no altitude exceeds the start.
 * 3. All positive gains: the final altitude is the highest altitude.
 * 4. Mixed positive and negative gains: the maximum running sum is returned.
 * 5. Zero gains: altitude remains unchanged for that segment.
 * 6. The highest altitude may occur before the final point.
 *
 * Mistakes / Revision Notes:
 * 1. The starting altitude is 0 and must be considered.
 * 2. Initialize max = 0, not Integer.MIN_VALUE.
 * 3. Update sum before comparing it with max.
 * 4. Do not return the final sum; the maximum may occur earlier.
 * 5. This is a prefix-sum problem: each running sum represents an altitude.
 */

public class LargestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
