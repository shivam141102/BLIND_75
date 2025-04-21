class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long mini = 0;
        long maxi = 0;
        long curr = 0;

        for(int i = 0; i < differences.length; i++){
            curr += differences[i];
            mini = Math.min(mini, curr);
            maxi = Math.max(maxi, curr);
        }
        long count = (upper - lower ) - (maxi - mini) + 1;
        return count > 0 ? (int)count : 0;
    }
}