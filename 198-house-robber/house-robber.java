// class Solution {
//     public int Rob(int ind, int[] nums, int[] dp){
//         if(ind == 0) return nums[ind];
//         if(ind < 0) return 0;

//         if(dp[ind] != -1) return dp[ind];
//         int rob = nums[ind] + Rob(ind - 2, nums, dp);
//         int notRob = 0 + Rob(ind - 1, nums, dp);

//         return dp[ind] = Math.max(rob, notRob);
//     }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
//         return Rob(n-1, nums, dp);
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int pick = nums[i];
            if(i > 1){
                pick += dp[i - 2];
            }
            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}