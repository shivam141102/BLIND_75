class Solution {
    public void recursion(int ind, int target, int n, int[] candidates, List<List<Integer>> ans, List<Integer> ds){
        if(ind == n){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            else return;
        }  

        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            recursion(ind, target - candidates[ind], n, candidates, ans, ds);
            ds.remove(ds.size() - 1);
        }

        recursion(ind + 1, target, n, candidates, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        recursion(0, target, n, candidates, ans, ds);
        return ans;
    }
}