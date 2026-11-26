
/*
 * Problem: Valid Anagram
 * LeetCode: 242
 * Topic: Strings, Sorting, Frequency Array
 * Difficulty: Easy
 *
 * =========================================================
 * Problem Statement:
 * =========================================================
 *
 * Given two strings s and t, return true if t is an anagram
 * of s, and false otherwise.
 *
 * An anagram is a word or phrase formed by rearranging
 * the letters of another word or phrase.
 *
 * Both strings must contain exactly the same characters
 * with the same frequency.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Explanation:
 * Both strings contain:
 * a -> 3 times
 * n -> 1 time
 * g -> 1 time
 * r -> 1 time
 * m -> 1 time
 *
 * Therefore, both strings are anagrams.
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Explanation:
 * The characters and their frequencies are different.
 *
 * Example 3:
 * Input: s = "aab", t = "abb"
 * Output: false
 *
 * Explanation:
 * a occurs 2 times in s but only 1 time in t.
 *
 *
 * =========================================================
 * Approach 1: Sorting
 * =========================================================
 *
 * Method: isAnagram()
 *
 * Logic:
 *
 * 1. Convert both strings into character arrays.
 *
 * 2. Sort both character arrays using Arrays.sort().
 *
 * 3. After sorting, anagrams will have the same
 *    characters in the same order.
 *
 * 4. Compare both arrays using Arrays.equals().
 *
 * 5. If both arrays are equal, return true.
 *    Otherwise, return false.
 *
 * Dry Run:
 *
 * Input:
 * s = "listen"
 * t = "silent"
 *
 * Step 1: Convert into character arrays.
 *
 * sArr = ['l', 'i', 's', 't', 'e', 'n']
 * tArr = ['s', 'i', 'l', 'e', 'n', 't']
 *
 * Step 2: Sort both arrays.
 *
 * sArr = ['e', 'i', 'l', 'n', 's', 't']
 * tArr = ['e', 'i', 'l', 'n', 's', 't']
 *
 * Step 3: Compare both arrays.
 *
 * Arrays.equals(sArr, tArr) -> true
 *
 * Output: true
 *
 * Time Complexity: O(n log n)
 *
 * Explanation:
 * Converting strings to arrays: O(n)
 * Sorting first array: O(n log n)
 * Sorting second array: O(n log n)
 * Comparing arrays: O(n)
 *
 * Overall: O(n log n)
 *
 * Space Complexity: O(n)
 *
 * Explanation:
 * Two character arrays are created.
 * Java sorting may also use temporary space.
 *
 *
 * =========================================================
 * Approach 2: Frequency Array
 * =========================================================
 *
 * Method: isAnagram2()
 *
 * Logic:
 *
 * 1. First check whether both strings have equal lengths.
 *
 * 2. If their lengths are different, return false.
 *
 * 3. Create an integer array of size 26.
 *    Each index represents one lowercase English letter.
 *
 * 4. Traverse the first string:
 *    Increase the frequency of each character.
 *
 *    count[ch - 'a']++;
 *
 * 5. Traverse the second string:
 *    Decrease the frequency of each character.
 *
 *    count[ch - 'a']--;
 *
 * 6. Traverse the frequency array.
 *
 * 7. If any frequency is not zero, return false.
 *
 * 8. If all frequencies are zero, return true.
 *
 * Character Index Mapping:
 *
 * a -> 0
 * b -> 1
 * c -> 2
 * ...
 * z -> 25
 *
 * Dry Run:
 *
 * Input:
 * s = "aab"
 * t = "aba"
 *
 * Initially:
 * count = [0, 0, 0, ...]
 *
 * Step 1: Traverse s = "aab"
 *
 * 'a' -> count[0]++
 * 'a' -> count[0]++
 * 'b' -> count[1]++
 *
 * count:
 * a -> 2
 * b -> 1
 *
 * Step 2: Traverse t = "aba"
 *
 * 'a' -> count[0]--
 * 'b' -> count[1]--
 * 'a' -> count[0]--
 *
 * count:
 * a -> 0
 * b -> 0
 *
 * Step 3: Check frequency array.
 *
 * All values are zero.
 *
 * Output: true
 *
 *
 * Another Example:
 *
 * Input:
 * s = "aab"
 * t = "abb"
 *
 * After processing both strings:
 *
 * a -> 1
 * b -> -1
 *
 * Since frequencies are not zero:
 *
 * Output: false
 *
 * Time Complexity: O(n)
 *
 * Explanation:
 * First string traversal: O(n)
 * Second string traversal: O(n)
 * Frequency array traversal: O(26)
 *
 * Overall:
 * O(n + n + 26) = O(n)
 *
 * Space Complexity: O(1)
 *
 * Explanation:
 * We use a fixed-size integer array of 26 elements.
 * Its size does not depend on the input length.
 *
 * Note:
 * This implementation supports only lowercase English
 * letters from 'a' to 'z'.
 *
 *
 * =========================================================
 * Approach Comparison:
 * =========================================================
 *
 * Approach          Time Complexity    Space Complexity
 *
 * Sorting           O(n log n)         O(n)
 * Frequency Array   O(n)               O(1)
 *
 * Frequency Array is more efficient because it avoids
 * sorting and directly compares character frequencies.
 *
 *
 * =========================================================
 * Mistakes / Revision Notes:
 * =========================================================
 *
 * 1. Anagram means same characters with the same frequency.
 *
 * 2. Checking only whether characters exist is not enough.
 *    Their frequencies must also match.
 *
 * 3. Always check string lengths before processing.
 *
 * 4. Use Arrays.sort() to sort character arrays.
 *
 * 5. Use Arrays.equals() to compare array contents.
 *    Do not use == to compare array contents.
 *
 * 6. count[ch - 'a'] converts a lowercase character
 *    into its corresponding array index.
 *
 * 7. Increment frequency for the first string.
 *
 * 8. Decrement frequency for the second string.
 *
 * 9. If every frequency becomes zero, both strings
 *    are anagrams.
 *
 * 10. Frequency array is the optimal approach for
 *     lowercase English letters.
 *
 */

package Strings.Easy;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        // Approach 1: Sorting
        System.out.println("Using Sorting: " +
                obj.isAnagram(s, t));

        // Approach 2: Frequency Array
        System.out.println("Using Frequency Array: " +
                obj.isAnagram2(s, t));
    }


    // =====================================================
    // Approach 1: Sorting
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    // =====================================================

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }


    // =====================================================
    // Approach 2: Frequency Array
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Assumption: Lowercase English letters (a-z)
    // =====================================================

    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {

            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {

            count[ch - 'a']--;
        }

        for (int num : count) {

            if (num != 0) {
                return false;
            }
        }

        return true;
    }

}
