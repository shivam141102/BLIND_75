class Solution {
    public boolean f(int ind, int[] nums, int[][] dp, int target){
        if(ind == 0) return nums[0] == target;
        if(target == 0) return true;

        if (dp[ind][target] != -1){
            return dp[ind][target] == 0 ? false : true;
        }
        boolean notTake = f(ind - 1, nums, dp, target);
        boolean take = false;
        if(nums[ind] <= target){
            take = f(ind - 1, nums, dp, target - nums[ind]);
        }

        dp[ind][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int target = (totalSum / 2);
        int[][] dp = new int[nums.length][target + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        if(totalSum % 2 == 0){
            return f(nums.length - 1, nums, dp, target);
        }
        return false;
    }
}