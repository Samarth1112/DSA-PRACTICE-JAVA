
/*
 * Problems:
 * 1. Valid Palindrome
 * 2. Valid Palindrome II
 * 3. Longest Palindromic Substring
 *
 * Topic: Strings, Two Pointers, Palindrome
 * Difficulty: Easy to Medium
 *
 * =========================================================
 * Problem 1: Valid Palindrome
 * LeetCode: 125
 * Difficulty: Easy
 * =========================================================
 *
 * Problem Statement:
 * Given a String s, determine whether it is a palindrome
 * after converting uppercase letters into lowercase and
 * removing all non-alphanumeric characters.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Explanation:
 * After removing spaces and special characters:
 * "amanaplanacanalpanama"
 *
 * It reads the same forward and backward.
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * Example 3:
 * Input: " "
 * Output: true
 *
 * Approach: Two Pointers
 *
 * 1. Initialize left = 0 and right = s.length() - 1.
 * 2. Skip non-alphanumeric characters from both ends.
 * 3. Convert both characters into lowercase.
 * 4. Compare the characters.
 * 5. If they are different, return false.
 * 6. Otherwise, move both pointers towards the centre.
 * 7. If all comparisons match, return true.
 *
 * Dry Run:
 * Input: "A man, a plan, a canal: Panama"
 *
 * After ignoring spaces and special characters:
 * "amanaplanacanalpanama"
 *
 * First comparison: a == a
 * Second comparison: m == m
 * Third comparison: a == a
 * All comparisons match.
 *
 * Output: true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 *
 * =========================================================
 * Problem 2: Valid Palindrome II
 * LeetCode: 680
 * Difficulty: Easy
 * =========================================================
 *
 * Problem Statement:
 * Given a String s, return true if it can become a
 * palindrome after deleting at most one character.
 *
 * Example 1:
 * Input: "aba"
 * Output: true
 *
 * Explanation:
 * Already a palindrome.
 *
 * Example 2:
 * Input: "abca"
 * Output: true
 *
 * Explanation:
 * Delete 'b' or 'c'.
 * Remaining String: "aca" or "aba".
 *
 * Example 3:
 * Input: "abc"
 * Output: false
 *
 * Approach: Two Pointers + One Deletion
 *
 * 1. Initialize left = 0 and right = s.length() - 1.
 * 2. Compare characters from both ends.
 * 3. If characters match, move both pointers inward.
 * 4. If characters do not match, we get two choices:
 *
 *    Option 1: Skip the left character.
 *    Option 2: Skip the right character.
 *
 * 5. Check whether either remaining substring is a
 *    palindrome using the helper method.
 *
 * Important Logic:
 *
 * return isPalindrome(s, left, right - 1) ||
 *        isPalindrome(s, left + 1, right);
 *
 * Dry Run:
 * Input: "abxyba"
 *
 * Step 1:
 * a b x y b a
 * ^         ^
 * L         R
 *
 * a == a -> Match
 *
 * Step 2:
 * a b x y b a
 *   ^     ^
 *   L     R
 *
 * b == b -> Match
 *
 * Step 3:
 * a b x y b a
 *     ^ ^
 *     L R
 *
 * x != y -> Mismatch
 *
 * Option 1: Skip 'y'.
 * Remaining String: "abxba"
 * It is a palindrome.
 *
 * Option 2: Skip 'x'.
 * Remaining String: "abyba"
 * It is also a palindrome.
 *
 * Output: true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 *
 * =========================================================
 * Problem 3: Longest Palindromic Substring
 * LeetCode: 5
 * Difficulty: Medium
 * =========================================================
 *
 * Problem Statement:
 * Given a String s, return the longest palindromic
 * substring in s.
 *
 * A substring is a contiguous sequence of characters.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 *
 * Explanation:
 * "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 *
 * Approach: Brute Force
 *
 * 1. Generate all possible substrings using two loops.
 * 2. Check whether each substring is a palindrome.
 * 3. Calculate its length using j - i + 1.
 * 4. If its length is greater than maxLen:
 *    - Update maxLen.
 *    - Update start.
 *    - Update end.
 * 5. Return the longest substring using:
 *
 *    s.substring(start, end + 1)
 *
 * Dry Run:
 * Input: "babad"
 *
 * Possible palindromic substrings:
 *
 * "b"   -> Length = 1
 * "a"   -> Length = 1
 * "bab" -> Length = 3
 * "aba" -> Length = 3
 * "d"   -> Length = 1
 *
 * When "bab" is found:
 * maxLen = 3
 * start = 0
 * end = 2
 *
 * When "aba" is found:
 * Length = 3
 *
 * Since we use > instead of >=, the existing answer
 * remains "bab".
 *
 * Final Output: "bab"
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(1) auxiliary space
 *
 * Explanation:
 * O(n^2) possible substrings.
 * O(n) time to check each substring.
 *
 *
 * =========================================================
 * Helper Method: Check Palindrome
 * =========================================================
 *
 * 1. Initialize two pointers l and r.
 * 2. Compare characters from both ends.
 * 3. If characters are different, return false.
 * 4. Otherwise, move both pointers inward.
 * 5. If all characters match, return true.
 *
 *
 * =========================================================
 * Mistakes / Revision Notes
 * =========================================================
 *
 * 1. Use Character.isLetterOrDigit() to ignore spaces
 *    and special characters.
 *
 * 2. Use Character.toLowerCase() for case-insensitive
 *    comparison.
 *
 * 3. Valid Palindrome II allows at most ONE deletion.
 *
 * 4. At the first mismatch, check both possibilities:
 *    skip left OR skip right.
 *
 * 5. In substring(start, end), the end index is exclusive.
 *    Therefore, use substring(start, end + 1) when end
 *    represents an inclusive index.
 *
 * 6. For Longest Palindromic Substring:
 *    - Generate all substrings.
 *    - Check each substring.
 *    - Track the maximum length.
 *
 * 7. Brute Force takes O(n^3).
 *    An optimized approach is Expand Around Center: O(n^2).
 *
 */

package Strings.Easy;

public class ValidPalindrome {

    public static void main(String[] args) {

        // Problem 1: Valid Palindrome
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Valid Palindrome: " + isPalindrome(s1));

        // Problem 2: Valid Palindrome II
        String s2 = "abca";
        System.out.println("Valid Palindrome II: " + validPalindrome(s2));

        // Problem 3: Longest Palindromic Substring
        String s3 = "babad";
        System.out.println("Longest Palindrome: " + longestPalindrome(s3));
    }

    // =====================================================
    // Problem 1: Valid Palindrome (LeetCode 125)
    // Two Pointers
    // =====================================================

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // =====================================================
    // Problem 2: Valid Palindrome II (LeetCode 680)
    // Two Pointers + One Deletion
    // =====================================================

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) ||
                        isPalindrome(s, left + 1, right);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    // Helper Method for Valid Palindrome II
    // Checks whether the given range is a palindrome.

    public static boolean isPalindrome(String s, int l, int r) {

        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    // =====================================================
    // Problem 3: Longest Palindromic Substring (LeetCode 5)
    // Brute Force
    // =====================================================

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
