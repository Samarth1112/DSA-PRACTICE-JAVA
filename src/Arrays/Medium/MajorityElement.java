
package Arrays.Medium;

import java.util.HashMap;

/*
 * Problem: Majority Element
 * Problem Number: LeetCode 169
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer array nums of size n, find the element that
 * appears more than n/2 times.
 *
 * Return -1 if no majority element exists.
 *
 * Example:
 * Input:  [7, 0, 0, 1, 7, 7, 2, 7, 7]
 * Output: 7
 *
 * Explanation:
 * Element 7 appears 5 times.
 * Since 5 > 9/2, 7 is the majority element.
 *
 * --------------------------------------------------
 * Approach 1: Brute Force
 * --------------------------------------------------
 *
 * - Select each element one by one.
 * - Count its occurrences by traversing the entire array.
 * - If count > n/2, return that element.
 *
 * Dry Run:
 * Array = [7, 0, 0, 1, 7, 7, 2, 7, 7]
 *
 * First element = 7
 * Occurrences of 7 = 5
 * n/2 = 9/2 = 4
 *
 * Since 5 > 4, return 7.
 *
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Approach 2: HashMap
 * --------------------------------------------------
 *
 * - Store each array element as a key.
 * - Store its frequency as the value.
 * - Use getOrDefault() to update the frequency.
 * - Traverse the HashMap and check which element
 *   has frequency greater than n/2.
 *
 * Frequency Map:
 * 7 -> 5
 * 0 -> 2
 * 1 -> 1
 * 2 -> 1
 *
 * Since frequency of 7 is 5 > 4, return 7.
 *
 * Time Complexity: O(n) average
 * Auxiliary Space: O(n)
 *
 * --------------------------------------------------
 * Approach 3: Boyer-Moore Voting Algorithm
 * --------------------------------------------------
 *
 * - Maintain two variables: element and count.
 * - If count becomes 0, select the current element
 *   as a new candidate.
 * - If the current element equals the candidate,
 *   increment count.
 * - Otherwise, decrement count.
 * - Different elements cancel each other.
 *
 * After the first traversal, the candidate is a
 * possible majority element.
 *
 * IMPORTANT:
 * Verify the candidate in a second traversal when
 * a majority element is not guaranteed to exist.
 *
 * Dry Run:
 * Array = [7, 0, 0, 1, 7, 7, 2, 7, 7]
 *
 * The cancellation process leaves candidate = 7.
 * Frequency of 7 = 5.
 * Since 5 > 4, return 7.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Edge Cases:
 *
 * 1. Single element: [5] -> 5
 * 2. All elements same: [2,2,2,2] -> 2
 * 3. No majority: [1,2,3,4] -> -1
 * 4. Negative values: [-1,-1,2] -> -1
 *    (because -1 appears 2 times, so output is -1;
 *     note that -1 is also the no-majority sentinel.)
 *
 * Mistakes / Revision Notes:
 *
 * 1. Use count > n/2, not count >= n/2.
 * 2. HashMap uses containsKey(), not contains().
 * 3. getOrDefault(value, 0) + 1 updates frequency.
 * 4. Boyer-Moore finds a candidate; verification is
 *    necessary if majority is not guaranteed.
 */

public class MajorityElement {

    public static void main(String[] args) {

        int[] arr = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr));
    }

    // Approach 1: Brute Force
    public static int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Approach 2: HashMap
    public static int majorityElement2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.put(nums[i],
                    map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {

            if (map.get(key) > n / 2) {
                return key;
            }
        }

        return -1;
    }

    // Approach 3: Boyer-Moore Voting Algorithm
    public static int majorityElement3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;

        int element = 0;
        int count = 0;

        // First traversal: Find possible candidate
        for (int i = 0; i < n; i++) {

            if (count == 0) {
                element = nums[i];
                count = 1;
            }
            else if (element == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        // Second traversal: Verify candidate
        int count1 = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == element) {
                count1++;
            }
        }

        if (count1 > n / 2) {
            return element;
        }

        return -1;
    }
}
