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
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null) return root;

    //     TreeNode temp = root.right;
    //     root.right = root.left;
    //     root.left = temp;

    //     invertTree(root.right);
    //     invertTree(root.left);

    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode front = q.remove();

            TreeNode temp = front.right;
            front.right = front.left;
            front.left = temp;

            if(front.right != null){
                q.add(front.right);
            }

            if(front.left != null){
                q.add(front.left);
            }
        }
        return root;
    }
}