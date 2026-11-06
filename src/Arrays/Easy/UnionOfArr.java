package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfArr {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2,3,4,5};
        int[] nums2 = {2,3,4,4,5,6};
        System.out.println(Union(nums1, nums2));
        System.out.println(Arrays.toString(UnionS(nums1, nums2)));
    }

    public static ArrayList<Integer> Union(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        ArrayList<Integer> unionArr = new ArrayList<>();

        while (i < n1 && j < n2){
            if (arr1[i] <= arr2[j]){
                if (unionArr.size() == 0 || unionArr.get(unionArr.size()-1) != arr1[i]){
                    unionArr.add(arr1[i]);
                }
                i++;
            }else {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size()-1) != arr2[j]){
                    unionArr.add(arr2[j]);
                }
                j++;
            }
        }

        //add remaining
        while (i < n1) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr1[i]) {
                unionArr.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != arr2[j]) {
                unionArr.add(arr2[j]);
            }
            j++;
        }
        return unionArr;
    }

    public static int[] UnionS(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        int[] union = new int[set.size()];
        int i = 0;
        for (int n : set){
            union[i] = n;
            i++;
        }
        return union;
    }
}
