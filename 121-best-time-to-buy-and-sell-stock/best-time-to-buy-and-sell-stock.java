class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int end = prices.length;

        int ans = 0;
        while(right < end){
            if(prices[left] < prices[right]){
                int currAns = prices[right] - prices[left];
                ans = Integer.max(ans, currAns);
                right++;
            }
            else{
                left = right;
                right = left + 1;
            }
        }
        return ans;
    }
}