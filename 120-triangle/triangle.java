// class Solution {
//     public int f(int i, int j, List<List<Integer>> triangle, int n){
//         if(i == n - 1) return triangle.get(n - 1).get(j);;

//         int up = triangle.get(i).get(j) + f(i+1, j, triangle, n);
//         int dg = triangle.get(i).get(j) + f(i+1, j+1, triangle, n);

//         return Math.min(up, dg);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int size = triangle.size();
//         return f(0, 0, triangle, size);
//     }
// }


class Solution {
    public int f(int i, int j, List<List<Integer>> triangle, int n, int[][] dp){
        if(i == n - 1) return triangle.get(n - 1).get(j);;

        if(dp[i][j] != -1) return dp[i][j];
        int up = triangle.get(i).get(j) + f(i+1, j, triangle, n, dp);
        int dg = triangle.get(i).get(j) + f(i+1, j+1, triangle, n, dp);

        return dp[i][j] = Math.min(up, dg);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f(0, 0, triangle, size, dp);
    }
}