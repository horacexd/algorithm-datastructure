package laicode.q84;

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    public int largestRectangle(int[] array) {
        int globalMax = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && cur >= array[stack.peekFirst()]) {
                int height = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                globalMax = Math.max(globalMax, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return globalMax;
    }

    public static void main(String[] args) {

    }
}