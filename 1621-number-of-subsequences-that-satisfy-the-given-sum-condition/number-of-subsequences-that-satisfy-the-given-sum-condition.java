class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n - 1;
        int MOD = (int) Math.pow(10, 9) + 7;

        int[] pow = new int[n];
        pow[0] = 1;

        for(int i = 1; i < n; i++){
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int res = 0;
        while(l <= r){
            if(nums[l] + nums[r] > target){
                r -= 1;
            }
            else{
                res += pow[r - l];
                res %= MOD;
                l++;
            }
        }
        return res;
    }
}