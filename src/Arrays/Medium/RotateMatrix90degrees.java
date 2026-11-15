
package Arrays.Medium;

import java.util.Arrays;

/*
 * Problem: Rotate Matrix by 90 Degrees Clockwise
 * Topic: Arrays / Matrix
 * Difficulty: Medium
 * Problem Source: takeUforward - Problem 70
 *
 * Problem Statement:
 * Given an n x n matrix, rotate the matrix by 90 degrees
 * clockwise.
 *
 * The rotation must be performed in place for the optimal
 * approach.
 *
 * Example:
 *
 * Input:
 * {
 *   {1, 2, 3},
 *   {4, 5, 6},
 *   {7, 8, 9}
 * }
 *
 * Output:
 * {
 *   {7, 4, 1},
 *   {8, 5, 2},
 *   {9, 6, 3}
 * }
 *
 * Approach 1: Brute Force - Using Extra Matrix
 *
 * 1. Create a new n x n matrix called ans.
 * 2. Traverse the original matrix using nested loops.
 * 3. Place each element at its rotated position:
 *
 *    ans[j][n - 1 - i] = matrix[i][j];
 *
 * 4. Copy the elements of ans back into the original matrix.
 *
 * Dry Run:
 *
 * Original:
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * Position mapping:
 * matrix[0][0] = 1 -> ans[0][2]
 * matrix[0][1] = 2 -> ans[1][2]
 * matrix[0][2] = 3 -> ans[2][2]
 * matrix[1][0] = 4 -> ans[0][1]
 * matrix[2][0] = 7 -> ans[0][0]
 *
 * Rotated:
 * 7  4  1
 * 8  5  2
 * 9  6  3
 *
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(n^2) for the extra matrix.
 *
 * Approach 2: Optimal - Transpose + Reverse Each Row
 *
 * Step 1: Transpose the matrix.
 * Swap matrix[i][j] with matrix[j][i].
 * Start j from i + 1 to avoid swapping elements twice.
 *
 * Step 2: Reverse every row using two pointers.
 * Initialize left = 0 and right = n - 1.
 * Swap elements until left >= right.
 *
 * Dry Run:
 *
 * Original:
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * After Transpose:
 * 1  4  7
 * 2  5  8
 * 3  6  9
 *
 * After Reversing Each Row:
 * 7  4  1
 * 8  5  2
 * 9  6  3
 *
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 *
 * Mistakes / Revision Notes:
 * 1. The destination position in brute force is
 *    ans[j][n - 1 - i], not ans[i][n - 1 - i].
 *
 * 2. Initialize the extra matrix using new int[n][n].
 *
 * 3. In transpose, start the inner loop from j = i + 1.
 *
 * 4. Reverse each row separately, not each column.
 *
 * 5. The optimal approach modifies the original matrix
 *    without using another matrix.
 *
 * 6. Both approaches assume a square matrix.
 */
public class RotateMatrix90degrees {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateMatrix2(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Approach 1: Brute Force
    public static void rotateMatrix(int[][] matrix) {

        int n = matrix.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    // Approach 2: Optimal - Transpose + Reverse
    public static void rotateMatrix2(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
