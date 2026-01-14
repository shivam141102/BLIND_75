class Solution {
    public void rec(int ind, int k, int size, int n, int currSum, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        if(ind == size){
            if(currSum == n){
                if(k == 0){
                    ans.add(new ArrayList<>(ds));
                    return;
                }
                else{
                    return;
                }
            }
            else{
                return;
            }
        }

        ds.add(nums[ind]);
        rec(ind + 1, k - 1, size, n, currSum + nums[ind], nums, ds, ans);
        ds.remove(ds.size() - 1);
        rec(ind + 1, k, size, n, currSum, nums, ds, ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int size = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rec(0, k, size, n, 0, nums, ds, ans);
        return ans;
    }
}