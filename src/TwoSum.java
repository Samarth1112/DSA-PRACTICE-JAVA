/*
 * Problem: Two Sum | LeetCode 1
 * Topic: Arrays, HashMap, Two Pointers
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer array nums and a target, return the indices of two
 * different elements whose sum equals target.
 *
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9.
 *
 * APPROACH 1: BRUTE FORCE
 * Steps:
 * 1. Use i to traverse each array element.
 * 2. For each i, use j = i + 1 to check the elements after it.
 * 3. If nums[i] + nums[j] == target, return {i, j}.
 * 4. If no pair is found, return {-1, -1}.
 *
 * Dry Run:
 * i = 0, j = 1 -> 2 + 7 = 9 -> return [0, 1].
 *
 * Time: O(n^2) - nested loops.
 * Auxiliary Space: O(1).
 *
 * APPROACH 2: HASHMAP
 * Idea: For each number, search for its complement (target - number)
 * among the elements already visited. Store number -> index in the map.
 *
 * Steps:
 * 1. Create a HashMap<Integer, Integer>.
 * 2. Traverse the array from left to right.
 * 3. Calculate rem = target - nums[i].
 * 4. If rem is in the map, return {map.get(rem), i}.
 * 5. Otherwise, store nums[i] and its index.
 * 6. If no pair is found, return {-1, -1}.
 *
 * Dry Run:
 * i = 0: num = 2, rem = 7. 7 is not in map. Store {2=0}.
 * i = 1: num = 7, rem = 2. 2 is in map at index 0.
 *        Return [0, 1].
 *
 * IMPORTANT:
 * Your original code returned {i, map.get(rem)}, producing [1, 0].
 * Use {map.get(rem), i} to return indices in ascending array order.
 *
 * Time: O(n) average - one traversal and average O(1) map operations.
 * Auxiliary Space: O(n) - the map can store up to n elements.
 *
 * APPROACH 3: SORTING + TWO POINTERS
 * This version checks whether a pair exists; it returns boolean, not indices.
 *
 * Steps:
 * 1. Sort the array.
 * 2. Set left = 0 and right = nums.length - 1.
 * 3. Calculate sum = nums[left] + nums[right].
 * 4. If sum < target, increment left.
 * 5. If sum > target, decrement right.
 * 6. If sum == target, return true.
 * 7. If pointers meet, return false.
 *
 * Dry Run:
 * Sorted array = [2, 7, 11, 15], target = 9
 * 2 + 15 = 17 -> too large, decrement right.
 * 2 + 11 = 13 -> too large, decrement right.
 * 2 + 7 = 9 -> found, return true.
 *
 * Time: O(n log n) - sorting dominates; two-pointer scan is O(n).
 * Auxiliary Space: Depends on the sorting implementation.
 *
 * IMPORTANT LIMITATIONS:
 * - Sorting changes the original array.
 * - This method returns true/false, not original indices.
 * - For LeetCode 1, use the HashMap approach when indices are required.
 * - To return original indices with two pointers, store each value with
 *   its original index before sorting.
 *
 * QUICK REVISION:
 * Brute Force = check every pair.
 * HashMap = look for target - current value in previously visited elements.
 * Two Pointers = sort, then move left/right based on the sum.
 *
 * Edge cases: negative values, duplicate values (e.g. [3,3], target=6),
 * no solution, and a pair at the beginning/end.
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));

        // Pass a copy because twoSum3 sorts the array in place.
        System.out.println(twoSum3(Arrays.copyOf(nums, nums.length), target));
    }

    // Approach 1: Brute Force
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Approach 2: HashMap
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rem = target - num;

            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }

            map.put(num, i);
        }

        return new int[]{-1, -1};
    }

    // Approach 3: Sorting + Two Pointers
    // Returns only whether a pair exists; sorts and modifies nums.
    public static boolean twoSum3(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
