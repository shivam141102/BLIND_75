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
    public boolean helper(TreeNode node, int targetSum){
        if(node == null) return false;

        if(node.left == null && node.right == null){
            if(node.val == targetSum){
                return true;
            }
            else{
                return false;
            }
        }

        boolean ans1 = helper(node.left, targetSum - node.val);
        boolean ans2 = helper(node.right, targetSum - node.val);

        return ans1 || ans2;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }
}