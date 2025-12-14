class Solution {
    public int helper(int i, int j, String s, String t, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper(i - 1, j - 1, s, t, dp) + helper(i - 1, j, s, t, dp);
        }
        else{
            return dp[i][j] = helper(i - 1, j, s, t, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        int index1 = s.length();
        int index2 = t.length();

        // for (int i = 0 ;i <= index1; i++) {
        //     for (int j = 0; j <= index2; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        
        for (int i = 0 ;i <= index1; i++) {
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= index1; i++){
            for(int j = 1; j <= index2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[index1][index2];
    }
}