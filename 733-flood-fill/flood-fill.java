class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(sr, sc));
        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair<Integer, Integer> pair = q.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            for(int i = 0; i < 4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] != color && image[nrow][ncol] == initialColor){
                    image[nrow][ncol] = color;
                    q.offer(new Pair<>(nrow, ncol));
                }
            }
        }
        return image;
    }
}