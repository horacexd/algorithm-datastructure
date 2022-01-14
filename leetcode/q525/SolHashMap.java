package leetcode.q525;

import java.util.Map;
import java.util.HashMap;

class SolHashMap {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int preSum = 0;
        int globalMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preSum -= 1;
            } else {
                preSum += 1;
            }
            if (indexMap.containsKey(preSum)) {
                globalMax = Math.max(globalMax, i - indexMap.get(preSum));
            } else {
                indexMap.put(preSum, i);
            }
        }
        return globalMax;
    }
}