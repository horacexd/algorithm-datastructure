package leetcode.q3;

import java.util.Set;
import java.util.HashSet;

public class SlidingWindow {

    public int lengthOfLongest(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        Set<Character> window = new HashSet<>();
        int globalMax = 0;
        for (int j = 0; j < s.length(); j++) {
            while (window.contains(s.charAt(j))) {
                window.remove(s.charAt(i));
                i++;
            }
            window.add(s.charAt(j));
            globalMax = Math.max(globalMax, j - i + 1);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        SlidingWindow sol = new SlidingWindow();
        System.out.println(sol.lengthOfLongest(s));
    }
    
}