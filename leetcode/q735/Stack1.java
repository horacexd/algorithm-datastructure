package leetcode.q735;

import java.util.Deque;
import java.util.ArrayDeque;


public class Stack1 {
    public int[] asteroidCollision(int[] asteroids) {    
        Deque<Integer> stack = new ArrayDeque<>();
	    int i = 0;
        while (i < asteroids.length) {
		    if (stack.isEmpty()) {
			    stack.offerFirst(asteroids[i]);
		        i++;
            } else {
                int l = stack.peekFirst();
                int r = asteroids[i];
                if (l * r > 0) {
                    stack.offerFirst(r);
                    i++;
                } else if (l > 0 && r < 0) {
                    if (l + r > 0) {
                        i++;
                    } else if (l + r < 0) {
                        stack.pollFirst();
                    } else {
                        stack.pollFirst();
                        i++;
                    }
                }  else {
                    stack.offerFirst(r);
                    i++;
                }
            }
        }
        int[] result = new int[stack.size()];
        i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pollLast();
        }
        return result;
    } 
}
