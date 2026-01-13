class Solution {
    public void rec(int ind, int[] nums, int n, List<Integer> ds, Set<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        rec(ind + 1, nums, n, ds, ans);
        ds.remove(ds.size() - 1);
        rec(ind + 1, nums, n, ds, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> temp = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        rec(0, nums, n, ds, temp);
        return new ArrayList<>(temp);
    }
}