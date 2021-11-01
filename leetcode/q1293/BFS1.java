package leetcode.q1293;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

public class BFS1 {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> q = new ArrayDeque<>();
        Node start = new Node(0, 0, k - grid[0][0]);
        q.offer(start);
        Set<Node> visited = new HashSet<>();
        visited.add(start);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.x == m - 1 && cur.y == n - 1) {
                    return level;
                }
                for (int[] dir : DIRS) {
                    int nextX = cur.x + dir[0];
                    int nextY = cur.y + dir[1];
                    if (nextX < 0 || nextX >= m|| nextY < 0 || nextY >= n) {
                        continue;
                    }
                    Node next = new Node(nextX, nextY, cur.k - grid[nextX][nextY]);
                    if (next.k < 0) {
                            continue;
                    }
                    if (visited.add(next)) {
                            q.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int k;
        Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node that = (Node) obj;
            return this.x == that.x && this.y == that.y && this.k == that.k;
        }

        @Override
        public int hashCode() {
            return 31 * 31 * this.x + 31 * this.y + this.k;
        }
    }
}
