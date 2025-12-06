class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;

        while(left < right){
            int length = right - left;
            int breadth = Math.min(height[left], height[right]);
            ans = Math.max(ans, length*breadth);

            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return ans;
    }
}