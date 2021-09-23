package leetcode.q215;

import java.util.Arrays;

public class Sort {
    
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
