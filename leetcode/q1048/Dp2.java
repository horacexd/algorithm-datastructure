package leetcode.q1048;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Dp2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
	        if (a.length() == b.length()) {
		        return 0; // need to covert the case when equal, otherwise it may violate comparator contract
            }
            return a.length() < b.length() ? -1 : 1;
        });
        Map<String, Integer> lengthMap = new HashMap<>();
        lengthMap.put(words[0], 1);
        int globalMax = 1;
        for (int i = 1; i < words.length; i++) {
            int cur = 1;
            for (int j = 0; j < words[i].length(); j++) {
                String prev = words[i].substring(0, j) + words[i].substring(j + 1);
                if (lengthMap.containsKey(prev)) {
                    cur = Math.max(cur, lengthMap.get(prev) + 1);
                }
            }
            lengthMap.put(words[i], cur);
            globalMax = Math.max(globalMax, cur);
        } 
        return globalMax;
    }
}
