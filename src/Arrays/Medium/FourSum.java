package Arrays.Medium;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum3(arr, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j]
                                + nums[k] + nums[l];

                        if (sum == target){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);

                            Collections.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target){
        int n = nums.length;
        HashSet<List<Integer>> ansSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                HashSet<Long> set = new HashSet<>();
                for (int k = j+1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = (long) target - sum;
                    if (set.contains(fourth)){      // Store quadruplet
                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int) fourth);

                        Collections.sort(list);

                        ansSet.add(list);
                    }
                    set.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(ansSet);
    }

    public static List<List<Integer>> fourSum3(int[] nums, int target){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;  //Avoid duplicates
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;   //Avoid duplicates
                int k = j+1;
                int l = n-1;
                while (k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else {   // quadruplet found
                        List<Integer> temp =
                                Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l &&  nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
