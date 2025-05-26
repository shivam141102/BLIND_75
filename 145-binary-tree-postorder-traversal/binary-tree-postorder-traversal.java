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
//         helper(root.right, ans);
//         ans.add(root.val);
//         return ans;
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         return helper(root, ans);
//     }
// }

// Using 2 Stacks
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root){
//         Stack<TreeNode> stack1 = new Stack<TreeNode>();
//         Stack<Integer> stack2 = new Stack<Integer>();
//         List<Integer> ans = new ArrayList<Integer>();
//         if(root == null) return ans;
//         stack1.push(root);

//         while(!stack1.isEmpty()){
//             TreeNode node = stack1.pop();
//             stack2.push(node.val);
//             if(node.left != null) stack1.push(node.left);
//             if(node.right != null) stack1.push(node.right);
//         }
//         while(!stack2.isEmpty()){
//             ans.add(stack2.pop());
//         }
//         return ans;
//     }
// }

// Using 1 stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        Collections.reverse(result);
        return result;
    }
}