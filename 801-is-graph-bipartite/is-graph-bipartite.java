class Solution {
    public boolean dfs(int node, int color, int[] colorArray, int[][] graph){
        colorArray[node] = color;

        for (int i: graph[node]){
            if(colorArray[i] == -1){
                int newColor = 0;
                if(color == 0){
                    newColor = 1;
                }
                else if(color == 1){
                    newColor = 0;
                }
                
                if(dfs(i, newColor, colorArray, graph) == false) return false;
            }
            else if(colorArray[i] == color){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colorArray = new int[graph.length];
        Arrays.fill(colorArray, -1);

        for(int i = 0; i < graph.length; i++){
            if(colorArray[i] == -1){
                if(dfs(i, 0, colorArray, graph) == false) return false;
            }
        }
        return true;
    }
}