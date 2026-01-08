/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(TreeNode root, int targetSum, List<Integer> ans, List<List<Integer>> res){
        if(root == null) return;
        if(root.left == null && root.right == null){
            targetSum -= root.val;
            ans.add(root.val);
            if(targetSum == 0){
                List<Integer> temp = new ArrayList<>(ans);
                res.add(temp);
            }
            ans.removeLast();
            targetSum += root.val;
            return;
        }

        targetSum -= root.val;
        ans.add(root.val);
        dfs(root.left, targetSum, ans, res);
        dfs(root.right, targetSum, ans, res);
        targetSum += root.val;
        ans.removeLast();
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, targetSum, temp, res);
        return res;
    }
}