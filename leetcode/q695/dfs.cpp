#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int globalMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    globalMax = max(globalMax, dfs(i, j, m, n, grid, visited));
                }
            }
        }
        return globalMax;
    }

private:
    const int[4][2] DIRS = {-1, 0, 1, 0, 0, 1, 0, -1};
    int dfs(int x, int y, const int& m, const int& n, const vector<vector<int>>& grid, vector<vector<bool>>& visited) {
        int cur = 1, nx, ny;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            nx = DIRS[i][0] + x;
            ny = DIRS[i][1] + y;
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
};
