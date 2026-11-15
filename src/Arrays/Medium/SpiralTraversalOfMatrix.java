
package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Spiral Traversal of Matrix
 * LeetCode: 54
 * Topic: Arrays / Matrix
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an m x n matrix, return all elements of the matrix
 * in spiral order, starting from the top-left corner and
 * moving clockwise.
 *
 * Example 1:
 * Input:
 * {
 *   {1, 2, 3},
 *   {4, 5, 6},
 *   {7, 8, 9}
 * }
 *
 * Output:
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Example 2:
 * Input:
 * {
 *   {1, 2, 3, 4},
 *   {5, 6, 7, 8},
 *   {9, 10, 11, 12}
 * }
 *
 * Output:
 * [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 *
 * Approach: Four Boundaries
 *
 * 1. Initialize four boundaries:
 *    top = 0, bottom = rows - 1
 *    left = 0, right = cols - 1
 *
 * 2. Traverse from Left to Right:
 *    Visit all elements in the top row.
 *    Increment top.
 *
 * 3. Traverse from Top to Bottom:
 *    Visit all elements in the right column.
 *    Decrement right.
 *
 * 4. Traverse from Right to Left:
 *    If top <= bottom, visit all elements in the bottom row.
 *    Decrement bottom.
 *
 * 5. Traverse from Bottom to Top:
 *    If left <= right, visit all elements in the left column.
 *    Increment left.
 *
 * 6. Repeat until top > bottom or left > right.
 *
 * Dry Run:
 *
 * Matrix:
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * Initial boundaries:
 * top = 0, bottom = 2
 * left = 0, right = 2
 *
 * First round:
 * Left to Right: 1, 2, 3
 * Top to Bottom: 6, 9
 * Right to Left: 8, 7
 * Bottom to Top: 4
 *
 * Second round:
 * Remaining element: 5
 *
 * Final Output:
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * Time Complexity: O(rows * cols)
 * Every matrix element is visited exactly once.
 *
 * Auxiliary Space: O(1)
 * Output Space: O(rows * cols)
 *
 * Mistakes / Revision Notes:
 * 1. Update boundaries after every traversal.
 * 2. Use top <= bottom before traversing the bottom row.
 * 3. Use left <= right before traversing the left column.
 * 4. These conditions prevent duplicate elements.
 * 5. For rectangular matrices, rows and columns can differ.
 * 6. Handle an empty matrix before accessing matrix[0].
 */
public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 ||
                matrix[0].length == 0) {
            return list;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {

            // Left to Right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
