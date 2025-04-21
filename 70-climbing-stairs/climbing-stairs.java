// Memoization
//class Solution {
//     public int f(int n, int[] dp){
//         if(n == 0 || n == 1) return 1;
//         if(dp[n] != -1) return dp[n];

//         return dp[n] = f(n - 1, dp) + f(n - 2, dp);
//     }
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         for(int i = 0; i <= n; i++){
//             dp[i] = -1;
//         }
//         return f(n, dp);
//     }
// }

// Tabulation
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         // for(int i = 0; i <= n; i++){
//         //     dp[i] = -1;
//         // }

//         dp[0] = 1;
//         dp[1] = 1;

//         for(int ind = 2; ind <=n ; ind++){
//             dp[ind] = dp[ind - 1] + dp[ind - 2];
//         }

//         return dp[n];
//     }
// }


// Space Optimization
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for(int ind = 2; ind <=n ; ind++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}