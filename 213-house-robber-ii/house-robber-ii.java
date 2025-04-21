// MEMOIZATION
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
//         if(n == 1) return nums[0];
//         int[] dp1 = new int[n];
//         int[] dp2 = new int[n];
//         Arrays.fill(dp1, -1);
//         Arrays.fill(dp2, -1);

//         int[] nums1 = new int[n - 1];
//         int[] nums2 = new int[n - 1];

//         for(int i = 0; i < n - 1; i++){
//             nums1[i] = nums[i];
//         }
//         for(int i = 1; i < n; i++){
//             nums2[i - 1] = nums[i];
//         }
//         return Math.max(Rob(n-2, nums1, dp1), Rob(n-2, nums2, dp2));
//     }
// }

// TABULATION
class Solution {
    public int Rob(int[] nums) {
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

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            nums1[i] = nums[i];
        }
        for(int i = 1; i < n; i++){
            nums2[i - 1] = nums[i];
        }
        return Math.max(Rob(nums1), Rob(nums2));
    }
}

// SPACE OPTIMIZATION
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int prev = nums[0];
//         int prev2 = 0;

//         for(int i = 1; i < n; i++){
//             int pick = nums[i];
//             if(i > 1){
//                 pick += prev2;
//             }
//             int notPick = 0 + prev;
//             int curr = Math.max(pick, notPick);
//             prev2 = prev;
//             prev = curr;
//         }
//         return prev;
//     }
// }