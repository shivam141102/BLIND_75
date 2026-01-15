class Solution {
    public void recursion(int ind, int[] candidates, int target, int n, List<List<Integer>> ans, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i < n; i++){
            if(i > ind && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(candidates[i] <= target){
                ds.add(candidates[i]);
                recursion(i + 1, candidates, target - candidates[i], n, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(0, candidates, target, n, ans, ds);

        return ans;
    }
}