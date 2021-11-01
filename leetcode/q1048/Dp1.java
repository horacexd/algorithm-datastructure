package leetcode.q1048;

import java.util.Arrays;


public class Dp1 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() < b.length() ? -1 : 1);
        int[] dp = new int[words.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canChain(words[j], words[i])) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]++;
            globalMax = Math.max(globalMax, dp[i]);
        } 
        return globalMax;
    }
    
    private boolean canChain(String s, String l) {
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
            if (s.charAt(i) != l.charAt(j)) {
                if (flag) {
                    return false;
                } else {
                    j++;
                    flag = true;
                }
            }
        }
        return true;
    }    
}
