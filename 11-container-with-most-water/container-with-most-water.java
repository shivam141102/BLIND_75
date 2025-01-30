class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;

        while(start < end){
            int area = (end - start) * Integer.min(height[end], height[start]);
            result = Integer.max(area, result);
            if(height[end] > height[start]) start++;
            else end--;
        }
        return result;
    }
}