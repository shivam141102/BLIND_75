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
// class Solution {
//     public List<Integer> helper(TreeNode root, List<Integer> ans){
//         if(root == null) return ans;

//         helper(root.left, ans);
//         ans.add(root.val);
//         helper(root.right, ans);
//         return ans;
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         return helper(root, res);
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }
}