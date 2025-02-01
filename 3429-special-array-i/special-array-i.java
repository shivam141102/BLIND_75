class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 2) return (nums[0] % 2 != nums[1] % 2);
        for(int i = 1; i < nums.length - 1; i++){
            if(!((nums[i - 1] % 2 != nums[i] % 2) && (nums[i] % 2 != nums[i + 1] % 2))){
                return false;
            }
        }
        return true;
    }
}