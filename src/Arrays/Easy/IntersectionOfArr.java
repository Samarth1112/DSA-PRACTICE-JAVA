package Arrays.Easy;

import java.util.ArrayList;

public class IntersectionOfArr {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] B = {2, 3, 3, 5, 6, 6, 7};
        System.out.println(Intersection(A, B));
        System.out.println(Intersection2(A, B));
    }

    public static ArrayList<Integer> Intersection(int[] A, int[] B){
        int n1 = A.length;
        int n2 = B.length;

        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (A[i] == B[j] && vis[j] == 0){
                    ans.add(A[i]);
                    vis[j] = 1;
                    break;
                }
                if (B[j] > A[i]){
                    break;
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> Intersection2(int[] A, int[] B) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = A.length;
        int m = B.length;
        int i = 0, j = 0;

        // Since arrays are sorted, we can use two-pointer approach
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                i++;
            } else if (B[j] < A[i]) {
                j++;
            } else { // A[i] == B[j]
                // Avoid duplicates
//                if (ans.size() == 0 || ans.get(ans.size() - 1) != A[i]) {
//                    ans.add(A[i]);
//                }
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}
