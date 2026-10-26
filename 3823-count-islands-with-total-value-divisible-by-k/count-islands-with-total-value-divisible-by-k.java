class Solution {
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0 && visited[i][j] == 0) {
                    long island = dfs(grid, i, j, visited);
                    if (island % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public long dfs(int[][] grid, int row, int col, int[][] visited) {
        long sum = grid[row][col];
        visited[row][col] = 1;

        if (row > 0 && grid[row - 1][col] != 0
                && visited[row - 1][col] == 0) {
            sum += dfs(grid, row - 1, col, visited);
        }

        if (col > 0 && grid[row][col - 1] != 0
                && visited[row][col - 1] == 0) {
            sum += dfs(grid, row, col - 1, visited);
        }

        if (row < grid.length - 1 && grid[row + 1][col] != 0
                && visited[row + 1][col] == 0) {
            sum += dfs(grid, row + 1, col, visited);
        }

        if (col < grid[0].length - 1 && grid[row][col + 1] != 0
                && visited[row][col + 1] == 0) {
            sum += dfs(grid, row, col + 1, visited);
        }

        return sum;
    }
}