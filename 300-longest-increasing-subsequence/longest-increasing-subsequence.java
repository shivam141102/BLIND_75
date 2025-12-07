class Solution {
    public int f(int[] nums, int ind, int prev, int size, int[][] dp){
        if(ind == size) return 0;

        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int pick = Integer.MIN_VALUE;
        if(prev == -1 || nums[ind] > nums[prev]){
            pick = 1 + f(nums, ind + 1, ind, size, dp);
        }
        int notPick = f(nums, ind + 1, prev, size, dp);
        return dp[ind][prev + 1] = Math.max(pick, notPick);
    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size + 1][size + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(nums, 0, -1, size, dp);
    }
}