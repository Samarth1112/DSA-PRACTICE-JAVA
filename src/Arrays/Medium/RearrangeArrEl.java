
/*
 * Problem: Rearrange Array Elements by Sign
 * LeetCode: 2149
 * Topic: Arrays
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array containing equal numbers of positive
 * and negative elements, rearrange the array such that positive
 * and negative elements appear alternately, starting with
 * a positive element.
 *
 * The relative order of positive elements and negative
 * elements must remain unchanged.
 *
 * Example 1:
 * Input:  [2, 4, 5, -1, -3, -4]
 * Output: [2, -1, 4, -3, 5, -4]
 *
 * Example 2:
 * Input:  [1, 2, -4, -5, 3, 6]
 * Output: [1, -4, 2, -5, 3, 6]
 *
 * --------------------------------------------------
 * Approach 1: Using Two ArrayLists
 * --------------------------------------------------
 *
 * 1. Create two lists: pos and neg.
 * 2. Traverse the array and separate positive and negative
 *    elements into their respective lists.
 * 3. Insert elements alternately into the answer array.
 * 4. Return the rearranged array.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 *
 * --------------------------------------------------
 * Approach 2: Direct Index Placement
 * --------------------------------------------------
 *
 * 1. Create an answer array of the same size.
 * 2. Initialize posIdx = 0 and negIdx = 1.
 * 3. Positive elements are placed at even indexes.
 * 4. Negative elements are placed at odd indexes.
 * 5. Increment the respective index by 2 after placement.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n) including output array.
 * Extra Auxiliary Space: O(1)
 *
 * --------------------------------------------------
 * Approach 3: Handling Unequal Counts
 * --------------------------------------------------
 *
 * 1. Separate positive and negative elements into two lists.
 * 2. Compare the sizes of both lists.
 * 3. Insert elements alternately while both lists have elements.
 * 4. Append the remaining elements from the larger list.
 * 5. Return the answer array.
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 *
 * --------------------------------------------------
 * Dry Run:
 *
 * Input: [2, 4, 5, -1, -3, -4]
 *
 * Positive list: [2, 4, 5]
 * Negative list: [-1, -3, -4]
 *
 * Alternating placement:
 * ans[0] = 2
 * ans[1] = -1
 * ans[2] = 4
 * ans[3] = -3
 * ans[4] = 5
 * ans[5] = -4
 *
 * Output: [2, -1, 4, -3, 5, -4]
 *
 * --------------------------------------------------
 * Edge Cases:
 * 1. Equal positive and negative elements.
 * 2. More positive elements than negative elements.
 * 3. More negative elements than positive elements.
 * 4. All positive elements.
 * 5. All negative elements.
 * 6. Empty array.
 *
 * Note:
 * Standard LeetCode 2149 assumes equal positive and negative
 * counts and does not contain zero.
 *
 * The custom Approach 3 supports unequal counts.
 *
 * Mistakes / Revision Notes:
 * 1. Use separate lists when preserving relative order.
 * 2. Even indexes are used for positive elements.
 * 3. Odd indexes are used for negative elements.
 * 4. Increment indexes by 2, not by 1.
 * 5. Direct index placement requires equal counts.
 * 6. Append remaining elements when counts are unequal.
 * 7. In this implementation, zero is treated as negative
 *    because the condition checks nums[i] > 0.
 */

package Arrays.Medium;

import java.util.ArrayList;

public class RearrangeArrEl {

    // Approach 1: Using two ArrayLists
    public static int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            ans[2 * i] = pos.get(i);
            ans[2 * i + 1] = neg.get(i);
        }

        return ans;
    }

    // Approach 2: Direct index placement
    public static int[] rearrangeArray2(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int posIdx = 0;
        int negIdx = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }

        return ans;
    }

    // Approach 3: Handling unequal positive and negative counts
    public static int[] rearrangeArray3(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        if (pos.size() > neg.size()) {

            for (int i = 0; i < neg.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            int idx = neg.size() * 2;

            for (int i = neg.size(); i < pos.size(); i++) {
                ans[idx] = pos.get(i);
                idx++;
            }

        } else {

            for (int i = 0; i < pos.size(); i++) {
                ans[2 * i] = pos.get(i);
                ans[2 * i + 1] = neg.get(i);
            }

            int idx = pos.size() * 2;

            for (int i = pos.size(); i < neg.size(); i++) {
                ans[idx] = neg.get(i);
                idx++;
            }
        }

        return ans;
    }
}
