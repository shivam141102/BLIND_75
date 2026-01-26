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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        queue.offer(root);
        
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    temp.addLast(node.val);
                }
                else{
                    temp.addFirst(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            res.add(temp);
        }
        return res;
    }
}