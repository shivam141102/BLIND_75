// class Solution {
//     public int f(int ind, int amount, int n, int[] coins, int[][] dp){
//         if(ind == 0){
//             if(amount % coins[0] == 0){
//                 return amount/coins[0];
//             }
//             return (int) Math.pow(10, 9);
//         }
//         if(dp[ind][amount] != -1) return dp[ind][amount];

//         int notTake = 0 + f(ind - 1, amount, n, coins, dp);
//         int take = (int) Math.pow(10, 9);
//         if(coins[ind] <= amount){
//             take = 1 + f(ind, amount - coins[ind], n, coins, dp);
//         }
//         return dp[ind][amount] = Math.min(notTake, take);
//     }

//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }

//         int ans = f(coins.length - 1, amount, coins.length, coins, dp);
//         if(ans >= (int) Math.pow(10, 9)){
//             return -1;
//         }
//         return ans;
//     }
// }



class Solution {
    // public int f(int ind, int amount, int n, int[] coins, int[][] dp){
    //     if(ind == 0){
    //         if(amount % coins[0] == 0){
    //             return amount/coins[0];
    //         }
    //         return (int) Math.pow(10, 9);
    //     }
    //     if(dp[ind][amount] != -1) return dp[ind][amount];

    //     int notTake = 0 + f(ind - 1, amount, n, coins, dp);
    //     int take = (int) Math.pow(10, 9);
    //     if(coins[ind] <= amount){
    //         take = 1 + f(ind, amount - coins[ind], n, coins, dp);
    //     }
    //     return dp[ind][amount] = Math.min(notTake, take);
    // }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        for(int target = 0; target <= amount; target++){
            if(target % coins[0] == 0){
                dp[0][target] = target/coins[0];
            }
            else{
                dp[0][target] = (int) Math.pow(10, 9);
            }
        }

        for(int ind = 1; ind < n; ind++){
            for(int target = 0; target <= amount; target++){
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);
                if(coins[ind] <= target){
                    take = 1 + dp[ind][target - coins[ind]];
                }
                dp[ind][target] = Math.min(notTake, take);
            }
        }
        int ans = dp[n - 1][amount];

        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}