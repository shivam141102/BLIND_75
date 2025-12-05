class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0], maxProduct = nums[0], ans = maxProduct;
        for(int i = 1; i < nums.length; i++){
            int temp = maxProduct;
            maxProduct = Math.max(nums[i], Math.max(minProduct * nums[i], maxProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(minProduct * nums[i], temp * nums[i])); 

            ans = Math.max(ans, maxProduct);
        }
        return ans;
    }
}