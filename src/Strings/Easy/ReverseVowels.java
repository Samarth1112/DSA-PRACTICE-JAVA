
/*
 * Problems: Reverse Vowels and Count Vowels
 * Topic: Strings, Two Pointers
 * Difficulty: Easy
 *
 * ==================================================
 * Problem 1: Count Vowels and Consonants
 * ==================================================
 *
 * Problem Statement:
 * Given a String, count the total number of vowels
 * and consonants present in it.
 *
 * Only English alphabet characters are considered.
 * Spaces, digits and special characters are ignored.
 *
 * Example:
 * Input: "IceCreAm"
 *
 * Output:
 * Vowels: 4
 * Consonants: 4
 *
 * Approach:
 * 1. Initialize vowels and consonants to 0.
 * 2. Traverse the String character by character.
 * 3. Check whether the character is an alphabet.
 * 4. If it is a vowel, increment vowels.
 * 5. Otherwise, increment consonants.
 * 6. Print both counts.
 *
 * Dry Run:
 * Input: "IceCreAm"
 *
 * I -> Vowel   -> vowels = 1
 * c -> Consonant -> consonants = 1
 * e -> Vowel   -> vowels = 2
 * C -> Consonant -> consonants = 2
 * r -> Consonant -> consonants = 3
 * e -> Vowel   -> vowels = 3
 * A -> Vowel   -> vowels = 4
 * m -> Consonant -> consonants = 4
 *
 * Output:
 * Vowels: 4
 * Consonants: 4
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ==================================================
 * Problem 2: Count the Number of Vowel Strings
 * LeetCode: 2586
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array of Strings words and two integers
 * left and right, return the number of strings in the
 * inclusive range [left, right] that start and end
 * with a vowel.
 *
 * Example 1:
 * Input:
 * words = ["are","amy","u"], left = 0, right = 2
 *
 * Output: 2
 *
 * Explanation:
 * "are" starts and ends with a vowel.
 * "amy" starts with a vowel but ends with y.
 * "u" starts and ends with a vowel.
 *
 * Total = 2
 *
 * Approach:
 * 1. Initialize count = 0.
 * 2. Traverse the array from left to right.
 * 3. Get the first character of each word.
 * 4. Get the last character of each word.
 * 5. Check whether both characters are vowels.
 * 6. If both are vowels, increment count.
 * 7. Return count.
 *
 * Dry Run:
 * words = ["are","amy","u"]
 * left = 0, right = 2
 *
 * i = 0 -> "are"
 * First = a, Last = e
 * Both vowels -> count = 1
 *
 * i = 1 -> "amy"
 * First = a, Last = y
 * Not both vowels -> count = 1
 *
 * i = 2 -> "u"
 * First = u, Last = u
 * Both vowels -> count = 2
 *
 * Output: 2
 *
 * Time Complexity: O(m)
 * Space Complexity: O(1)
 *
 * m = Number of words in the selected range.
 *
 * ==================================================
 * Problem 3: Reverse Vowels of a String
 * LeetCode: 345
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a String s, reverse only the vowels in the String
 * and return the resulting String.
 *
 * Vowels: a, e, i, o, u
 *
 * Both uppercase and lowercase vowels are considered.
 *
 * Example 1:
 * Input: "IceCreAm"
 * Output: "AceCreIm"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 *
 * Approach: Two Pointers
 *
 * 1. Convert the String into a character array.
 * 2. Initialize start = 0 and end = n - 1.
 * 3. Traverse using a while loop while start < end.
 * 4. If the start character is not a vowel,
 *    increment start.
 * 5. If the end character is not a vowel,
 *    decrement end.
 * 6. If both characters are vowels, swap them.
 * 7. Move both pointers towards the centre.
 * 8. Convert the character array back into String.
 *
 * Dry Run:
 * Input: "IceCreAm"
 *
 * Initial:
 * I c e C r e A m
 * ^             ^
 *
 * Step 1:
 * I and m -> I is vowel, m is not.
 * Move end left.
 *
 * Step 2:
 * I and A -> Both vowels.
 * Swap I and A.
 *
 * A c e C r e I m
 *
 * Step 3:
 * Move start and end.
 * c and e -> c is not a vowel.
 * Move start right.
 *
 * Step 4:
 * e and e -> Both vowels.
 * Swap them (no visible change).
 *
 * Final Output:
 * "AceCreIm"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * ==================================================
 * Mistakes / Revision Notes:
 *
 * 1. Use == to compare char values.
 * 2. Check uppercase and lowercase vowels.
 * 3. Use two pointers to avoid unnecessary traversal.
 * 4. Skip consonants using start++ and end--.
 * 5. Swap only when both characters are vowels.
 * 6. Use toCharArray() because String is immutable.
 * 7. Use new String(arr) to return the modified String.
 *
 */

package Strings.Easy;

public class ReverseVowels {

    public static void main(String[] args) {

        String s = "IceCreAm";

        System.out.println(reverseVowels(s));

        countVowels(s);
    }

    // Problem 1: Count vowels and consonants
    public static void countVowels(String s) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')) {

                if (isVowel(ch)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels : " + vowels);
        System.out.println("Consonants : " + consonants);
    }

    // Problem 2: LeetCode 2586
    // Count the Number of Vowel Strings in Range
    class Solution {

        public int vowelStrings(String[] words, int left, int right) {

            int count = 0;

            for (int i = left; i <= right; i++) {

                char start = words[i].charAt(0);

                char end = words[i].charAt(words[i].length() - 1);

                if (isVowel(start) && isVowel(end)) {
                    count++;
                }
            }

            return count;
        }
    }

    // Problem 3: LeetCode 345
    // Reverse Vowels of a String
    public static String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int n = s.length();

        int start = 0;
        int end = n - 1;

        while (start < end) {

            if (!isVowel(arr[start])) {
                start++;
            }

            else if (!isVowel(arr[end])) {
                end--;
            }

            else {

                char temp = arr[start];

                arr[start] = arr[end];

                arr[end] = temp;

                start++;
                end--;
            }
        }

        return new String(arr);
    }

    // Check whether a character is a vowel
    public static boolean isVowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

            return true;
        }

        else if (ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U') {

            return true;
        }

        else {
            return false;
        }
    }
}
