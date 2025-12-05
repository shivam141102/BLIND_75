class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, ans = Integer.MAX_VALUE;

        while(left < right){
            int mid = (left + right) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}