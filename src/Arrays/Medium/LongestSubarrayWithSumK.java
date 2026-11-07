package Arrays.Medium;

import java.util.HashMap;

/*
 * Problem: Longest Subarray with Sum K
 * Topic: Arrays, Prefix Sum, HashMap, Sliding Window
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums and an integer k, return the length of the
 * longest contiguous subarray whose sum is exactly k.
 *
 * Example:
 * Input: nums = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], k = 6
 * Output: 4
 * Explanation: [3, 1, 1, 1] is a contiguous subarray with sum 6 and length 4.
 *
 * Approach 1: Brute Force (longestSubarray)
 * Steps:
 * 1. Select each index i as a starting point.
 * 2. Reset sum = 0 for this starting point.
 * 3. Move j from i to the end, adding nums[j] to sum.
 * 4. Whenever sum == k, update the maximum length with j - i + 1.
 *
 * Dry Run:
 * nums = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], k = 6
 * Starting at i = 0: sums are 1, 3, 6 -> length 3.
 * Starting at i = 2: sums are 3, 4, 5, 6 -> length 4.
 * Maximum length = 4.
 *
 * Complexity: Time O(n^2), Auxiliary Space O(1).
 *
 * Approach 2: Prefix Sum + HashMap (longestSubarray2)
 * Key idea:
 * If current prefix sum is sum, look for an earlier prefix sum equal to
 * sum - k. The elements after that earlier prefix up to i sum to k.
 *
 * Steps:
 * 1. Maintain a running prefix sum.
 * 2. If sum == k, the subarray from index 0 to i has length i + 1.
 * 3. Calculate rem = sum - k.
 * 4. If rem exists in the map, length = i - firstIndex(rem).
 * 5. Store the current prefix sum only if it is not already present.
 *    Keeping the earliest index helps obtain the longest subarray.
 *
 * Dry Run:
 * nums = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], k = 6
 * i=0: sum=1, rem=-5; store {1=0}.
 * i=1: sum=3, rem=-3; store {3=1}.
 * i=2: sum=6; sum==k, so maxlen=3; store {6=2}.
 * i=3: sum=7, rem=1; first index of 1 is 0, length=3.
 * i=4: sum=8, rem=2; not found.
 * i=5: sum=9, rem=3; first index of 3 is 1, length=5-1=4.
 * Maximum length = 4.
 *
 * Complexity: Average Time O(n), Auxiliary Space O(n).
 * Works with positive, zero and negative numbers.
 *
 * Approach 3: Sliding Window / Two Pointers (longestSubarray3)
 * IMPORTANT: This implementation is valid only when all elements are
 * NON-NEGATIVE (zero or positive). It is not generally correct with negatives.
 *
 * Steps:
 * 1. Start with left = 0 and sum = 0.
 * 2. Expand the window by adding nums[right].
 * 3. While sum > k, shrink from the left.
 * 4. If sum == k, update the maximum length.
 * 5. Continue until right reaches the end.
 *
 * Dry Run:
 * nums = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3], k = 6
 * - Window [1,2,3]: sum=6, length=3.
 * - Add 1: sum=7; remove leftmost 1 -> [2,3,1], sum=6.
 * - Add 1: sum=7; remove leftmost 2 -> [3,1,1], sum=5.
 * - Add 1: window [3,1,1,1], sum=6, length=4.
 * Maximum length = 4.
 *
 * Complexity: Time O(n), Auxiliary Space O(1).
 * Each pointer moves forward at most n times.
 *
 * Comparison:
 * - Brute Force: O(n^2) time, O(1) space; works with any integers.
 * - Prefix Sum + HashMap: O(n) average time, O(n) space; works with negatives.
 * - Sliding Window: O(n) time, O(1) space; requires non-negative elements.
 *
 * Edge Cases:
 * - Empty array: return 0.
 * - No subarray sums to k: return 0.
 * - Entire array sums to k: return nums.length.
 * - Negative values: use brute force or prefix sum + HashMap, not this
 *   sliding-window implementation.
 *
 * Mistakes / Revision Notes:
 * 1. A subarray must be contiguous.
 * 2. Reset sum = 0 for every new starting index in brute force.
 * 3. In prefix sum, rem = sum - k (not k - sum).
 * 4. Use putIfAbsent to preserve the earliest prefix-sum index.
 * 5. Check sum == k to handle a subarray starting at index 0.
 * 6. Sliding window works only when all elements are non-negative.
 * 7. Initialize sliding-window sum to 0 and add nums[right] as the window
 *    expands; this handles empty arrays safely.
 */

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 6;

        System.out.println("Brute Force: " + longestSubarray(arr, k));
        System.out.println("Prefix Sum + HashMap: " + longestSubarray2(arr, k));
        System.out.println("Sliding Window: " + longestSubarray3(arr, k));
    }

    // Approach 1: Brute Force
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int length = 0;

        // Try every index as the starting point of a subarray.
        for (int i = 0; i < n; i++) {
            int sum = 0; // Reset sum for each new starting index.

            // Extend the subarray from i to j.
            for (int j = i; j < n; j++) {
                sum += nums[j]; // Include the current element.

                // If this subarray has sum k, update its length.
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
    }

    // Approach 2: Prefix Sum + HashMap
    public static int longestSubarray2(int[] nums, int k) {
        // Key = prefix sum; Value = earliest index where it occurred.
        HashMap<Integer, Integer> preSumMap = new HashMap<>();

        int sum = 0;
        int maxlen = 0;

        for (int i = 0; i < nums.length; i++) {
            // Step 1: Add current element to get the prefix sum.
            sum += nums[i];

            // Step 2: Handle a subarray starting at index 0.
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            // Step 3: Find the prefix sum needed before this subarray.
            int rem = sum - k;

            // Step 4: If it exists, calculate the subarray length.
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxlen = Math.max(maxlen, len);
            }

            // Step 5: Keep only the first occurrence of each prefix sum.
            // An earlier index can produce a longer subarray.
            preSumMap.putIfAbsent(sum, i);
        }

        return maxlen;
    }

    // Approach 3: Sliding Window / Two Pointers
    // Use this method only if all array elements are non-negative.
    public static int longestSubarray3(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int maxlen = 0;

        // right expands the current window.
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Add the new rightmost element.

            // If the sum is too large, remove elements from the left.
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // The current window [left, right] has the required sum.
            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
        }

        return maxlen;
    }
}
