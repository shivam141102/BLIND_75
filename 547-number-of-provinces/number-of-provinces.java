class Solution {
    public List<List<Integer>> getAdjacencyList(int[][] isConnected){
        List<List<Integer>> adj = new ArrayList<>();
        for(int[] edge : isConnected){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        return adj;
    }

    public void bfs(int start, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()){
            int node = q.remove();
            for(int neighbour: adj.get(node)){
                if(vis[neighbour] == false){
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = getAdjacencyList(isConnected);
        int province = 0;
        boolean[] vis = new boolean[isConnected.length + 1];

        for(int i = 0; i < isConnected.length; i++){
            if(vis[i] == false){
                bfs(i, adj, vis);
                province++;
            }
        }
        return province;
    }
}