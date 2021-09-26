package leetcode.q3;

import java.util.Map;
import java.util.HashMap;

public class SlidingWindow2 {
    
    public int lengthOfLongestSubstring(String s) {
        int globalMax = 0;
        int i = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (indexMap.containsKey(s.charAt(j))) {
                i = Math.max(indexMap.get(s.charAt(j)) + 1, i);
            }
            indexMap.put(s.charAt(j), j);
            globalMax = Math.max(globalMax, j - i + 1);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        String s = "abba";
        SlidingWindow2 sol = new SlidingWindow2();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
