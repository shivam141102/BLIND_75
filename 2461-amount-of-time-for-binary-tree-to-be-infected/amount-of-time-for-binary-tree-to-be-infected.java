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
    public int findInfectionTime(TreeNode start, HashMap<TreeNode, TreeNode> parentMap){
        HashMap<TreeNode, Integer> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(start);
        vis.put(start, 1);
        int ans = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null && vis.get(node.left) == null){
                    flag = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }

                if(parentMap.get(node) != null && vis.get(parentMap.get(node)) == null){
                    flag = 1;
                    vis.put(parentMap.get(node), 1);
                    q.offer(parentMap.get(node));
                }

                if(node.right != null && vis.get(node.right) == null){
                    flag = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
            }
            if(flag == 1) ans++;
        }
        return ans;
    }
    public TreeNode getParentMappings(HashMap<TreeNode, TreeNode> map, TreeNode root, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = new TreeNode();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == start) res = node;
            if(node.left != null){
                map.put(node.left, node);
                q.offer(node.left);
            }

            if(node.right != null){
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode startNode = getParentMappings(map, root, start);
        int time = findInfectionTime(startNode, map);
        return time;
    }
}