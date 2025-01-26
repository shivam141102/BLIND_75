class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return new int[1];
        int[] leftToRight = new int[nums.length];
        leftToRight[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            leftToRight[i] = leftToRight[i - 1]*nums[i];
        }

        int[] rightToLeft = new int[nums.length];
        rightToLeft[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            rightToLeft[i] = rightToLeft[i + 1]*nums[i];
        }

        int[] ans = new int[nums.length];
        ans[0] = rightToLeft[1];
        ans[nums.length - 1] = leftToRight[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i++){
            ans[i] = leftToRight[i-1]*rightToLeft[i+1];
        }
        return ans;
    }
}