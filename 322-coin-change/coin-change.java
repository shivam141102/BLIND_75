class Solution {
    public int f(int ind, int amount, int n, int[] coins, int[][] dp){
        if(ind == 0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }
            return (int) Math.pow(10, 9);
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];

        int notTake = 0 + f(ind - 1, amount, n, coins, dp);
        int take = (int) Math.pow(10, 9);
        if(coins[ind] <= amount){
            take = 1 + f(ind, amount - coins[ind], n, coins, dp);
        }
        return dp[ind][amount] = Math.min(notTake, take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = f(coins.length - 1, amount, coins.length, coins, dp);
        if(ans >= (int) Math.pow(10, 9)){
            return -1;
        }
        return ans;
    }
}