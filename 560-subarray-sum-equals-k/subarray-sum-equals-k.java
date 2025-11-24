class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int curr = 0, ans = 0;

        for(int i = 0; i < nums.length; i++){
            curr += nums[i];

            if(mp.containsKey(curr - k)){
                ans += mp.get(curr - k);
            }
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}