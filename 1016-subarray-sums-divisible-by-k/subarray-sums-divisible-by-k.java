class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0, ans = 0;

        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];

            int remainder = prefixSum % k;
            if(remainder < 0) remainder += k;

            if(remainderMap.containsKey(remainder)){
                ans += remainderMap.get(remainder);
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }
        return ans;
    }
}