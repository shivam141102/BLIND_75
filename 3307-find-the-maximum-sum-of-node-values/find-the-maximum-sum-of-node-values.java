class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        long minDiff = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] ^ k) > nums[i]){
                count++;
                ans += nums[i]^k;
            }
            else{
                ans += nums[i];
            }
            minDiff = Math.min(minDiff, Math.abs((nums[i] ^ k) - nums[i]));
        }
        if(count % 2 != 0) ans -= minDiff;
        return ans;
    }
}