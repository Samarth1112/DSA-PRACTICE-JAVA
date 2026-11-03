package Arrays.Easy;

/*
 * Problem: Second Largest, Second Smallest
 * Topic: Arrays
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer array:
 * 1. Find the second-largest distinct element.
 * 2. Find the second-smallest distinct element.
 * 3. Find the second-largest element using both one and two traversals.
 *
 * Examples:
 * Input: {1, 2, 8, 3, 9, 7}
 * Second largest: 8
 * Second smallest: 2
 *
 * Input: {5, 5, 5}
 * Second largest: -1 (no second distinct value)
 * Second smallest: -1 (no second distinct value)
 *
 * Approach:
 * A) Second Largest - One Traversal:
 * 1. Track the largest and second-largest distinct values.
 * 2. If a new largest is found, move the old largest into secondLargest.
 * 3. Otherwise, update secondLargest if the current value is distinct
 *    from largest and greater than the current second-largest value.
 *
 * B) Second Smallest - One Traversal:
 * 1. Track the smallest and second-smallest distinct values.
 * 2. If a new smallest is found, move the old smallest into secondSmallest.
 * 3. Otherwise, update secondSmallest if the current value is distinct
 *    from smallest and smaller than the current second-smallest value.
 *
 * C) Second Largest - Two Traversals:
 * 1. First traversal finds the largest value.
 * 2. Second traversal finds the greatest value strictly smaller than largest.
 *
 * Dry Run - Second Largest:
 * Input: {1, 2, 8, 3, 9, 7}
 *
 * Value | largest | secondLargest
 *   1   |    1    | not found
 *   2   |    2    |      1
 *   8   |    8    |      2
 *   3   |    8    |      3
 *   9   |    9    |      8
 *   7   |    9    |      8
 *
 * Output: 8
 *
 * Time Complexity:
 * 1. secondLargest(): O(n), one traversal.
 * 2. secondSmallest(): O(n), one traversal.
 * 3. secondLargest2(): O(2n) = O(n), two traversals.
 *
 * Auxiliary Space: O(1) for every method.
 *
 * Edge Cases:
 * 1. Empty array: no second-largest or second-smallest value.
 * 2. Single-element array: no second distinct value.
 * 3. All elements equal: no second distinct value.
 * 4. Duplicate maximum/minimum values are not counted as second values.
 * 5. Negative numbers and zero are supported.
 * 6. Integer.MIN_VALUE and Integer.MAX_VALUE are supported.
 * 7. Already sorted and reverse-sorted arrays.
 *
 * Mistakes / Revision Notes:
 * 1. Second-largest and second-smallest must be distinct.
 * 2. Initializing a candidate to -1 fails for arrays containing negatives.
 * 3. Integer.MIN_VALUE/MAX_VALUE alone are unsafe as "not found" markers
 *    because they may be valid array elements. Use a boolean flag.
 * 4. Check the array length before accessing arr[0].
 * 5. O(2n) simplifies to O(n).
 * 6. For non-decreasing order, equal adjacent elements are allowed.
 * 7. This code returns -1 when no second distinct value exists, following
 *    the common problem convention. If -1 may be a valid answer, use a
 *    different return design such as OptionalInt.
 */
public class SecondLargest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 3, 9, 7};

        System.out.println(secondLargest2(nums));
        System.out.println(secondLargest(nums));
        System.out.println(secondSmallest(nums));

    }

    // One traversal: O(n) time, O(1) auxiliary space.
    public static int secondLargest(int[] arr){
        if (arr == null || arr.length < 2){
            return -1;
        }
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        return (sLargest == Integer.MIN_VALUE) ? -1 : sLargest;
    }

    // One traversal: O(n) time, O(1) auxiliary space.
//    public static int secondLargest(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return -1;
//        }
//
//        int largest = arr[0];
//        int sLargest = 0;
//        boolean foundSecond = false;
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > largest) {
//                sLargest = largest;
//                largest = arr[i];
//                foundSecond = true;
//            } else if (arr[i] < largest &&
//                    (!foundSecond || arr[i] > sLargest)) {
//                sLargest = arr[i];
//                foundSecond = true;
//            }
//        }
//
//        return foundSecond ? sLargest : -1;
//    }

    public static int secondLargest2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        int sLargest = 0;
        boolean foundSecond = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < largest &&
                    (!foundSecond || arr[i] > sLargest)) {
                sLargest = arr[i];
                foundSecond = true;
            }
        }

        return foundSecond ? sLargest : -1;
    }

    // One traversal: O(n) time, O(1) auxiliary space.
    public static int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int smallest = arr[0];
        int sSmallest = 0;
        boolean foundSecond = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                sSmallest = smallest;
                smallest = arr[i];
                foundSecond = true;
            } else if (arr[i] > smallest &&
                    (!foundSecond || arr[i] < sSmallest)) {
                sSmallest = arr[i];
                foundSecond = true;
            }
        }

        return foundSecond ? sSmallest : -1;
    }
}
