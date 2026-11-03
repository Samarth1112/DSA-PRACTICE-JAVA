package Arrays.Medium;
/*
 * Problem: Move Zeroes
 * Platform: LeetCode 283
 * Topic: Arrays / Two Pointers
 * Difficulty: Easy
 *
 * Approach: Two Pointers
 * Move non-zero elements to the front
 * while maintaining their relative order.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
