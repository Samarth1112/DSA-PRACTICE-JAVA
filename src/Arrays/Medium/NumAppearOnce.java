package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Number Appearing Once (Single Number)
 * Topic: Arrays, Brute Force, Bit Manipulation, Hashing
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array where exactly one element appears once and every other
 * element appears twice, find and return the element appearing once.
 *
 * Example 1:
 * Input: arr = [2, 2, 1]
 * Output: 1
 *
 * Example 2:
 * Input: arr = [4, 1, 2, 1, 2]
 * Output: 4
 *
 * Example 3:
 * Input: arr = [7]
 * Output: 7
 *
 * Approach 1: Brute Force (onlyOnce)
 * - Select each element and count its occurrences in the complete array.
 * - If its frequency is exactly one, return it.
 * - Returns the first single-occurrence element in original array order.
 *
 * Dry Run:
 * arr = [4, 1, 2, 1, 2]
 * num = 4 -> frequency = 1 -> return 4.
 *
 * Complexity: Time O(n^2), Auxiliary Space O(1).
 *
 * Approach 2: XOR (onlyOnce2)
 * - XOR all array elements.
 * - Since x ^ x = 0 and x ^ 0 = x, pairs cancel out.
 * - The remaining value is the element appearing once.
 *
 * Dry Run:
 * arr = [4, 1, 2, 1, 2]
 * xor = 0 ^ 4 ^ 1 ^ 2 ^ 1 ^ 2 = 4.
 *
 * Complexity: Time O(n), Auxiliary Space O(1).
 *
 * IMPORTANT XOR CONDITION:
 * Exactly one element must appear once and every other element must appear
 * exactly twice. XOR is not a general solution for arbitrary frequencies.
 *
 * Approach 3: Frequency Array (onlyOnce3)
 * - Find the maximum value.
 * - Create an array of size max + 1.
 * - Count occurrences using hash[arr[i]]++.
 * - Return the first index whose frequency is exactly one.
 *
 * Complexity: Time O(n + maxValue), Auxiliary Space O(maxValue).
 *
 * Limitations:
 * - Requires a non-empty array of non-negative values.
 * - Large maximum values can require too much memory.
 * - Returns the smallest value occurring once, not necessarily the first
 *   such value in the original array.
 *
 * Approach 4: HashMap (onlyOnce4)
 * - Store each number as a key and its frequency as the value.
 * - Use getOrDefault(num, 0) + 1 to update the frequency.
 * - Find an entry whose value (frequency) is one.
 *
 * Complexity: Average Time O(n), Auxiliary Space O(n).
 *
 * Note:
 * HashMap does not guarantee iteration order. If multiple values occur once,
 * this method may return any one of them. To return the first such value in
 * the original array, traverse arr after building the map and check
 * map.get(num) == 1.
 *
 * Comparison:
 * 1. Brute Force: O(n^2) time, O(1) space.
 * 2. XOR: O(n) time, O(1) space; requires all other values to occur twice.
 * 3. Frequency Array: O(n + maxValue) time, O(maxValue) space; non-negative
 *    values and a manageable maximum are required.
 * 4. HashMap: O(n) average time, O(n) space; supports negative and large values.
 *
 * Edge Cases:
 * - One element: [7] -> 7.
 * - Negative values: XOR and HashMap support them.
 * - Empty array: brute force, XOR and HashMap return -1; frequency array
 *   must check before accessing arr[0].
 *
 * Mistakes / Revision Notes:
 * 1. XOR only works under the exact pair-duplicates condition.
 * 2. Guard the frequency-array method against an empty array.
 * 3. Negative numbers cannot be used directly as array indices.
 * 4. HashMap iteration order is not guaranteed.
 * 5. Distinguish any single-occurrence element from the first one in input order.
 */

public class NumAppearOnce {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        System.out.println("Brute Force: " + onlyOnce(nums));
        System.out.println("XOR: " + onlyOnce2(nums));
        System.out.println("Frequency Array: " + onlyOnce3(nums));
        System.out.println("HashMap: " + onlyOnce4(nums));
    }

    // Approach 1: Brute Force
    public static int onlyOnce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num) {
                    count++;
                }
            }

            if (count == 1) {
                return num;
            }
        }

        return -1;
    }

    // Approach 2: XOR
    // Exactly one element appears once; every other element appears twice.
    public static int onlyOnce2(int[] arr) {
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }

    // Approach 3: Frequency Array
    // Assumes a non-empty array of non-negative, reasonably small values.
    public static int onlyOnce3(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int maxi = arr[0];

        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        if (maxi < 0) {
            return -1;
        }

        int[] hash = new int[maxi + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    // Approach 4: HashMap frequency counting
    // If multiple answers exist, HashMap may return any one of them.
    public static int onlyOnce4(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find an element with frequency 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
