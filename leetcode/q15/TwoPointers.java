package leetcode.q15;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length - 2) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                if (nums[j] + nums[k] == target - nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j + 1 < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    while (k - 1 > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if (nums[j] + nums[k] < target - nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoPointers sol = new TwoPointers();
        // System.out.println(sol.threeSum(new int[] {-1, 0, 1, 2, -1, -4}, 0));
        // System.out.println(sol.threeSum(new int[] {0}, 0));
        // System.out.println(sol.threeSum(new int[] {}, 0));
        System.out.println(sol.threeSum(new int[] {0, 0, 0, 0}, 0));
    }
}