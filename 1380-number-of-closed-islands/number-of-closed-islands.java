class Solution {
    public boolean dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean left = dfs(i - 1, j, grid);
        boolean right = dfs(i + 1, j, grid);
        boolean up = dfs(i, j + 1, grid);
        boolean down = dfs(i, j - 1, grid);

        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}