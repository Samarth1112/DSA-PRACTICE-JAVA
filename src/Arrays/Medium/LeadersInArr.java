
/*
 * Problem: Leaders in an Array
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Find all the leaders in an array.
 *
 * An element is a leader if it is greater than or equal
 * to every element on its right side.
 *
 * The rightmost element is always a leader.
 *
 * Example:
 * Input:  [1, 2, 5, 3, 1, 2]
 * Output: [5, 3, 2]
 *
 * --------------------------------------------------
 * Approach 1: Brute Force
 * --------------------------------------------------
 *
 * 1. Traverse each element using an outer loop.
 * 2. Check all elements to its right using an inner loop.
 * 3. If any element is greater, it is not a leader.
 * 4. Otherwise, add it to the result list.
 *
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1) excluding result list.
 *
 * --------------------------------------------------
 * Approach 2: Right-to-Left Traversal
 * --------------------------------------------------
 *
 * 1. Traverse the array from right to left.
 * 2. Maintain the maximum element seen so far (maxi).
 * 3. If nums[i] >= maxi, the current element is a leader.
 * 4. Add the leader to the result list.
 * 5. Update maxi.
 * 6. Reverse the list to restore original order.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1) excluding result list.
 *
 * --------------------------------------------------
 * Dry Run:
 *
 * Input: [1, 2, 5, 3, 1, 2]
 *
 * Right-to-left traversal:
 *
 * 2 -> Leader, maxi = 2
 * 1 -> Not a leader
 * 3 -> Leader, maxi = 3
 * 5 -> Leader, maxi = 5
 * 2 -> Not a leader
 * 1 -> Not a leader
 *
 * List before reversing: [2, 3, 5]
 * Final Output: [5, 3, 2]
 *
 * --------------------------------------------------
 * Edge Cases:
 * 1. Single element: [5] -> [5]
 * 2. Strictly increasing: [1, 2, 3] -> [3]
 * 3. Strictly decreasing: [5, 4, 3] -> [5, 4, 3]
 * 4. Duplicate elements: [5, 5, 2] -> [5, 5, 2]
 * 5. Negative elements: [-3, -2, -5] -> [-2, -5]
 * 6. Empty array: [] -> []
 *
 * Mistakes / Revision Notes:
 * 1. A leader is greater than OR equal to all elements
 *    on its right.
 * 2. Use >= instead of > in the optimal approach.
 * 3. Traverse from right to left to maintain maxi.
 * 4. Reverse the result to restore original order.
 * 5. Initialize maxi with Integer.MIN_VALUE to support
 *    arrays containing negative numbers.
 */

package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArr {

    // Approach 1: Brute Force
    public static List<Integer> leaders(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean leader = true;
            int el = nums[i];

            for (int j = i + 1; j < n; j++) {

                if (nums[j] > el) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                list.add(el);
            }
        }

        return list;
    }

    // Approach 2: Optimal - Right to Left Traversal
    public static List<Integer> leaders2(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] >= maxi) {
                list.add(nums[i]);
            }

            maxi = Math.max(maxi, nums[i]);
        }

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 3, 1, 2};

        System.out.println(leaders(nums));
        System.out.println(leaders2(nums));
    }
}
