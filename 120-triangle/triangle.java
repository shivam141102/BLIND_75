// class Solution {
//     public int f(int i, int j, List<List<Integer>> triangle, int n){
//         if(i == n - 1) return triangle.get(n - 1).get(j);;

//         int d = triangle.get(i).get(j) + f(i+1, j, triangle, n);
//         int dg = triangle.get(i).get(j) + f(i+1, j+1, triangle, n);

//         return Math.min(d, dg);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int size = triangle.size();
//         return f(0, 0, triangle, size);
//     }
// }


// class Solution {
//     public int f(int i, int j, List<List<Integer>> triangle, int n, int[][] dp){
//         if(i == n - 1) return triangle.get(n - 1).get(j);;

//         if(dp[i][j] != -1) return dp[i][j];
//         int d = triangle.get(i).get(j) + f(i+1, j, triangle, n, dp);
//         int dg = triangle.get(i).get(j) + f(i+1, j+1, triangle, n, dp);

//         return dp[i][j] = Math.min(d, dg);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int size = triangle.size();
//         int[][] dp = new int[size][size];

//         for(int[] arr : dp){
//             Arrays.fill(arr, -1);
//         }
//         return f(0, 0, triangle, size, dp);
//     }
// }



// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int[][] dp = new int[n][n];
        
//         for(int i = 0; i < n; i++){
//             dp[n - 1][i] = triangle.get(n - 1).get(i);
//         }

//         for(int i = n - 2; i >= 0; i--){
//             for(int j = i; j >= 0 ; j--){
//                 int up = triangle.get(i).get(j) + dp[i + 1][j];
//                 int dg = triangle.get(i).get(j) + dp[i + 1][j + 1];

//                 dp[i][j] = Math.min(up, dg);
//             }
//         }
//         return dp[0][0];
//     }
// }



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        int[] curr = new int[n];
        
        for(int i = 0; i < n; i++){
            front[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0 ; j--){
                int up = triangle.get(i).get(j) + front[j];
                int dg = triangle.get(i).get(j) + front[j + 1];

                curr[j] = Math.min(up, dg);
            }
            front = curr.clone();
        }
        return front[0];
    }
}