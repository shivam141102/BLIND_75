class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O'){
                vis[0][i] = 1;
                q.add(new int[]{0, i});
            }
            if(board[n - 1][i] == 'O'){
                vis[n - 1][i] = 1;
                q.add(new int[]{n - 1, i});
            }
        }

        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                vis[i][0] = 1;
                q.add(new int[]{i, 0});
            }
            if(board[i][m - 1] == 'O'){
                vis[i][m - 1] = 1;
                q.add(new int[]{i, m - 1});
            }
        }

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] top = q.poll();
            int row = top[0];
            int col = top[1];

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0){
                    board[i][j] = 'X';
                }
                else{
                    board[i][j] = 'O';
                }
            }
        }
    }
}