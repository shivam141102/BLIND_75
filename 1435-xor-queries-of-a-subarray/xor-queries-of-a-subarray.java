class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixSum = new int[arr.length + 1];
        int[] ans = new int[queries.length];
        prefixSum[0] = 0;

        for(int i = 1; i <= arr.length; i++){
            prefixSum[i] = prefixSum[i - 1] ^ arr[i - 1];
        }
        
        int i = 0;
        for(int query[] : queries){
            ans[i++] = prefixSum[query[1] + 1] ^ prefixSum[query[0]];
        }
        return ans;
    }
}