package leetcode.q695;

public class Dfs {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        // sanity check
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int globalMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    globalMax = Math.max(globalMax, dfs(i, j, m, n, grid, visited));
                }
            }
        }
        return globalMax;
    }
    
    private int dfs(int x, int y, int m, int n, int[][] grid, boolean[][] visited) {
        visited[x][y] = true; // mark visited
        int cur = 1;
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            cur += dfs(nx, ny, m, n, grid, visited);
        }
        return cur;
    }
}
