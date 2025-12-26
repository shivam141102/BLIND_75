class Pair{
    public int row;
    public int col;
    public int time;

    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;
        
        int[][] vis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j, 0));
                }
                else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1) freshOranges++;
            }
        }

        int time = 0, cnt = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int t = queue.peek().time;
            time = Math.max(t, time);
            queue.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >=0 && nrow < n && 
                    ncol >=0 && ncol < m &&
                    grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                        queue.add(new Pair(nrow, ncol, time + 1));
                        vis[nrow][ncol] = 2;
                        cnt++;
                    }
            }
        }
        if(cnt != freshOranges) return -1;
        return time;
    }
}