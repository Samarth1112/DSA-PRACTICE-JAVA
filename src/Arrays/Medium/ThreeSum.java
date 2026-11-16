
package Arrays.Medium;

import java.util.*;

/*
 * Problem: 3Sum
 * LeetCode: 15
 * Topic: Arrays / Hashing / Sorting / Two Pointers
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, return all unique triplets
 * [nums[i], nums[j], nums[k]] such that:
 *
 * 1. i != j, i != k, and j != k.
 * 2. nums[i] + nums[j] + nums[k] == 0.
 * 3. The solution must not contain duplicate triplets.
 *
 * Example 1:
 * Input:
 * nums = {-1, 0, 1, 2, -1, -4}
 *
 * Output:
 * [[-1, -1, 2], [-1, 0, 1]]
 *
 * Explanation:
 * -1 + -1 + 2 = 0
 * -1 +  0 + 1 = 0
 *
 * Example 2:
 * Input:
 * nums = {0, 1, 1}
 *
 * Output:
 * []
 *
 * Example 3:
 * Input:
 * nums = {0, 0, 0}
 *
 * Output:
 * [[0, 0, 0]]
 *
 *
 * Approach 1: Brute Force - Three Nested Loops
 *
 * 1. Use three nested loops to select three elements.
 * 2. Check whether their sum equals zero.
 * 3. If the sum is zero, store the three elements in a list.
 * 4. Sort the triplet to maintain a consistent order.
 * 5. Insert the sorted triplet into a HashSet.
 * 6. HashSet prevents duplicate triplets.
 *
 * Time Complexity: O(n^3)
 * Auxiliary Space: O(u) for unique triplets.
 *
 *
 * Approach 2: Better - Hashing with Three Variables
 *
 * 1. Fix the first element using the outer loop.
 * 2. Create a new HashSet for every fixed element.
 * 3. Traverse the remaining elements using the inner loop.
 * 4. Calculate the required third element:
 *
 *    third = -(nums[i] + nums[j])
 *
 * 5. Check whether the third element exists in the HashSet.
 * 6. If found, store the triplet.
 * 7. Sort the triplet and insert it into the answer HashSet.
 * 8. Add the current nums[j] to the HashSet after checking.
 *
 * Why add after checking?
 * To ensure that the third element comes from a previously
 * visited index and the same index is not reused.
 *
 * Time Complexity: O(n^2) average
 * Auxiliary Space: O(n + u)
 *
 * Note:
 * The long version protects against integer overflow
 * while calculating the required third element.
 *
 *
 * Approach 3: Hashing without Long
 *
 * 1. Fix the first element using the outer loop.
 * 2. Create a HashSet for previously visited elements.
 * 3. Calculate the required third element using int.
 * 4. Check whether the third element exists in the HashSet.
 * 5. If found, create and sort the triplet.
 * 6. Add the triplet to the answer HashSet.
 * 7. Insert nums[j] into the HashSet after checking.
 *
 * Time Complexity: O(n^2) average
 * Auxiliary Space: O(n + u)
 *
 * Note:
 * This version assumes the input constraints guarantee
 * that integer arithmetic does not overflow.
 *
 *
 * Approach 4: Optimal - Sorting + Two Pointers
 *
 * 1. Sort the input array.
 * 2. Fix the first element using index i.
 * 3. Skip duplicate first elements.
 * 4. Initialize two pointers:
 *
 *    j = i + 1
 *    k = n - 1
 *
 * 5. Calculate the sum:
 *
 *    sum = nums[i] + nums[j] + nums[k]
 *
 * 6. If sum < 0, increment j.
 * 7. If sum > 0, decrement k.
 * 8. If sum == 0:
 *    - Store the triplet.
 *    - Increment j.
 *    - Decrement k.
 *    - Skip duplicate second and third elements.
 *
 * 9. Continue until j >= k.
 *
 * Dry Run:
 *
 * Input:
 * [-1, 0, 1, 2, -1, -4]
 *
 * After Sorting:
 * [-4, -1, -1, 0, 1, 2]
 *
 * First valid triplet:
 * -1 + -1 + 2 = 0
 * Result: [-1, -1, 2]
 *
 * Second valid triplet:
 * -1 + 0 + 1 = 0
 * Result: [-1, 0, 1]
 *
 * Final Output:
 * [[-1, -1, 2], [-1, 0, 1]]
 *
 * Time Complexity:
 * Sorting: O(n log n)
 * Two-pointer traversal: O(n^2)
 * Overall: O(n^2)
 *
 * Auxiliary Space: O(1), excluding output and sorting
 * implementation details.
 *
 *
 * Approach Comparison:
 *
 * Brute Force:
 * Time: O(n^3)
 * Space: O(u)
 *
 * Hashing:
 * Time: O(n^2) average
 * Space: O(n + u)
 *
 * Hashing without Long:
 * Time: O(n^2) average
 * Space: O(n + u)
 *
 * Sorting + Two Pointers:
 * Time: O(n^2)
 * Auxiliary Space: O(1), excluding output and sorting.
 *
 *
 * Mistakes / Revision Notes:
 *
 * 1. Use j = i + 1 and k = j + 1 in brute force.
 *
 * 2. Sort every triplet before inserting it into a HashSet
 *    to avoid duplicates in different orders.
 *
 * 3. Create a new HashSet inside the outer loop
 *    in the hashing approach.
 *
 * 4. Add nums[j] after checking whether third exists.
 *
 * 5. Use (int) third when checking a HashSet<Integer>
 *    if third is declared as long and its range is valid.
 *
 * 6. In the optimal approach, compare sum with ZERO,
 *    not with the pointer k.
 *
 * 7. Use else if for the sum comparison conditions.
 *
 * 8. Skip duplicate first, second and third elements.
 *
 * 9. Sorting modifies the original input array.
 *
 * 10. Use long when input constraints can cause
 *     integer overflow.
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum3(nums));
    }

    // Approach 1: Brute Force
    public static List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp);

                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    // Approach 2: Better - Hashing with Long
    public static List<List<Integer>> threeSum2(int[] nums) {

        int n = nums.length;

        HashSet<ArrayList<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                long third = -((long) nums[i] + nums[j]);

                if (third >= Integer.MIN_VALUE &&
                        third <= Integer.MAX_VALUE &&
                        set.contains((int) third)) {

                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add((int) third);

                    Collections.sort(list);

                    ansSet.add(list);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ansSet);
    }

    // Approach 3: Hashing without Long
    public static List<List<Integer>> threeSum2WithoutLong(int[] nums) {

        int n = nums.length;

        HashSet<ArrayList<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {

                int third = -(nums[i] + nums[j]);

                if (set.contains(third)) {

                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);

                    Collections.sort(list);

                    ansSet.add(list);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ansSet);
    }

    // Approach 4: Optimal - Sorting + Two Pointers
    public static List<List<Integer>> threeSum3(int[] nums) {

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {

                    // Found triplet
                    List<Integer> temp =
                            Arrays.asList(nums[i], nums[j], nums[k]);

                    ans.add(temp);

                    j++;
                    k--;

                    // Skip duplicate second elements
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicate third elements
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return ans;
    }
}
