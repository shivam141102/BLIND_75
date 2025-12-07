class Solution {
    public int f(int ind, int amount, int[] coins, int[][] dp){
        if(ind == 0 ){
            if(amount % coins[0] == 0) return amount/coins[0];
            return (int)1e9;
        }

        if(dp[ind][amount] != -1) return dp[ind][amount];
        
        int notTake = 0 + f(ind - 1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount){
            take = 1 + f(ind, amount - coins[ind], coins, dp);
        }
        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }
        int ans = f(coins.length - 1, amount, coins, dp);
        return ans >= 1e9 ? -1 : ans;
    }
}