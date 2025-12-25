class Solution {
    public int helper(int i, int[] dp){
        if(i < 3) return i;

        if(dp[i] != 0) return dp[i];

        return dp[i] = helper(i - 1, dp) + helper(i - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }
}