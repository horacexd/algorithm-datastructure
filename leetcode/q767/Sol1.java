package leetcode.q767;

import java.util.PriorityQueue;

public class Sol1 {
    public String reorganizeString(String s) {
        int[] countMap = new int[26];
        for (char c : s.toCharArray()) {
            countMap[c - 'a']++;
        }

        PriorityQueue<Element> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.count, e1.count));
        for (int i = 0; i < 26; i++) {
            if (countMap[i] != 0) {
                maxHeap.offer(new Element((char) (i + 'a'), countMap[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            Element e1 = maxHeap.poll();
            Element e2 = maxHeap.poll();
            char a = e1.c;
            char b = e2.c;
            for (int i = 0; i < e2.count; i++) {
                sb.append(a);
                sb.append(b);
            }
            if (e1.count - e2.count > 0) {
                e1.count -= e2.count;
                maxHeap.offer(e1);
            }
        }
        return maxHeap.size() == 1 ? "" : sb.toString();
    }

    static class Element {
        char c;
        int count;

        Element(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
