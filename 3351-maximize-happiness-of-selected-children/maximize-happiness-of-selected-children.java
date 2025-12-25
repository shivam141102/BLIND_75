class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        List<Integer> temp = Arrays.stream(happiness).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(temp);

        for(int i = 0; i <= k - 1; i++){
            int curr = pq.poll();
            if(curr - i > 0){
                ans += curr - i;
            }
        }
        return ans;
    }
}