class Solution {
    public int helper(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != 0) return dp[i][j];

        int up = helper(i - 1, j, grid, dp);
        int left = helper(i, j - 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        return helper(row - 1, col - 1, grid, dp);
    }
}