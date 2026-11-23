
/*
 * Problem: Reverse String and Reverse Words
 * Topic: Strings
 * Difficulty: Easy
 *
 * --------------------------------------------------
 * 1. Reverse a String using StringBuilder
 * --------------------------------------------------
 *
 * Problem Statement:
 * Given a String, reverse all its characters.
 *
 * Example:
 * Input:  "Interview"
 * Output: "weivretnI"
 *
 * Approach:
 * 1. Create a StringBuilder object using the input String.
 * 2. Use the reverse() method.
 * 3. Convert StringBuilder into String using toString().
 *
 * Dry Run:
 * Input: "Interview"
 *
 * StringBuilder sb = new StringBuilder("Interview");
 * sb.reverse();
 *
 * Output: "weivretnI"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * --------------------------------------------------
 * 2. Reverse a String using a Loop
 * --------------------------------------------------
 *
 * Problem Statement:
 * Reverse a String by traversing it from the last
 * character to the first character.
 *
 * Example:
 * Input:  "Interview"
 * Output: "weivretnI"
 *
 * Approach:
 * 1. Create an empty String rev.
 * 2. Start traversing from the last index.
 * 3. Append each character to rev.
 * 4. Return the reversed String.
 *
 * Dry Run:
 * Input: "Java"
 *
 * i = 3 -> a
 * i = 2 -> av
 * i = 1 -> ava
 * i = 0 -> avaJ
 *
 * Output: "avaJ"
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Note:
 * Repeated String concatenation creates new String
 * objects. StringBuilder is more efficient.
 *
 * --------------------------------------------------
 * 3. Reverse Words in a String
 * --------------------------------------------------
 *
 * Problem Statement:
 * Given a String containing multiple words,
 * reverse the order of words in the String.
 *
 * Example 1:
 * Input:  "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input:  "hello world"
 * Output: "world hello"
 *
 * Approach:
 * 1. Split the String using split(" +").
 * 2. Store the words in a String array.
 * 3. Traverse the array from the last index to 0.
 * 4. Append each word to StringBuilder.
 * 5. Add spaces between the words.
 * 6. Return the final String.
 *
 * Dry Run:
 * Input: "the sky is blue"
 *
 * words = ["the", "sky", "is", "blue"]
 *
 * i = 3 -> blue
 * i = 2 -> blue is
 * i = 1 -> blue is sky
 * i = 0 -> blue is sky the
 *
 * Output: "blue is sky the"
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * --------------------------------------------------
 * Mistakes / Revision Notes:
 *
 * 1. String is immutable, whereas StringBuilder is mutable.
 * 2. reverse() reverses all characters, not just words.
 * 3. split(" +") handles multiple consecutive spaces.
 * 4. StringBuilder avoids repeated String concatenation.
 * 5. Use toString() to convert StringBuilder into String.
 *
 * --------------------------------------------------
 */

package Strings.Easy;

public class ReverseWords {

    public static void main(String[] args) {

        String s = "the sky is blue";

        System.out.println(reverseWords(s));
        System.out.println(reverseEachWords(s));

        String str = "Interview";

        System.out.println(reverse(str));
        System.out.println(reverse2(str));
    }

    // Reverse complete String using StringBuilder
    public static String reverse(String s) {

        StringBuilder sb = new StringBuilder(s);

        return sb.reverse().toString();
    }

    // Reverse complete String using loop
    public static String reverse2(String s) {

        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {

            rev += s.charAt(i);
        }

        return rev;
    }

    // Reverse the order of words
    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" +");

        for (int i = words.length - 1; i >= 0; i--) {

            sb.append(words[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    // Reverse each word individually
    public static String reverseEachWords(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }

        return result.toString().trim();
    }
}
