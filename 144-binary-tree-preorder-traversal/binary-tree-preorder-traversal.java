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
    public List<Integer> helper(TreeNode root, List<Integer> ans){
        if(root == null) return ans;
        
        ans.add(root.val);
        if(root.left != null) helper(root.left, ans);
        if(root.right != null) helper(root.right, ans);
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return helper(root, ans);
    }
}

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> st = new Stack<TreeNode>();
//         List<Integer> ans = new ArrayList<>();
//         if(root == null) return ans;

//         st.push(root);
//         while(!st.isEmpty()){
//             TreeNode curr = st.pop();
//             ans.add(curr.val);
//             if(curr.right != null) st.push(curr.right);
//             if(curr.left != null) st.push(curr.left);
//         }
//         return ans;
//     }
// }