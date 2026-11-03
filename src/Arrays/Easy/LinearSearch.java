package Arrays.Easy;/*
 * Problem: Linear Search
 * Topic: Arrays / Searching
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer array nums and an integer target, find the index of
 * the first occurrence of target in nums. If target is not present,
 * return -1.
 *
 * Examples:
 *
 * Example 1:
 * Input:  nums = {4, 2, 7, 1, 7}, target = 7
 * Output: 2
 * Explanation: The first occurrence of 7 is at index 2.
 *
 * Example 2:
 * Input:  nums = {10, 20, 30}, target = 5
 * Output: -1
 * Explanation: The target is not present in the array.
 *
 * Example 3:
 * Input:  nums = {}, target = 5
 * Output: -1
 * Explanation: An empty array contains no elements to search.
 *
 * Example 4:
 * Input:  nums = {8}, target = 8
 * Output: 0
 * Explanation: The target is at index 0.
 *
 * Approach:
 * 1. Start from the first element (index 0).
 * 2. Compare each element with target.
 * 3. If nums[i] == target, return i immediately.
 *    This returns the first occurrence if duplicates exist.
 * 4. If the loop finishes without finding target, return -1.
 *
 * Java Code:
 * See the implementation below.
 *
 * Dry Run:
 * Input: nums = {4, 2, 7, 1, 7}, target = 7
 *
 * i = 0: nums[0] = 4, not equal to 7.
 * i = 1: nums[1] = 2, not equal to 7.
 * i = 2: nums[2] = 7, target found; return 2.
 *
 * Output: 2
 *
 * Time Complexity:
 * Best case: O(1) - target is the first element.
 * Worst case: O(n) - target is last or absent.
 * Average case: O(n).
 *
 * Auxiliary Space: O(1) - only the loop variable is used.
 *
 * Edge Cases:
 * 1. Empty array: returns -1.
 * 2. Single-element array: returns 0 if it matches; otherwise -1.
 * 3. Target at the first index: returns 0.
 * 4. Target at the last index: returns the last index.
 * 5. Target absent: returns -1.
 * 6. Duplicate values: returns the index of the first occurrence.
 * 7. Negative values and zero: handled normally.
 *
 * Mistakes / Revision Notes:
 * 1. Array indices start at 0, not 1.
 * 2. Use i < nums.length to avoid accessing nums[nums.length].
 * 3. Return as soon as the target is found to get the first occurrence.
 * 4. Return -1 only after checking every element.
 * 5. This implementation assumes nums is not null. If nums can be null,
 *    add a null check before accessing nums.length.
 */

class LinearSearch {
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 1, 7};
        int target = 7;
        int ans = linearSearch(nums, target);
        System.out.println(ans);
    }
}

