class Solution {
    public int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    public int minSwaps(int[] nums) { 
        int n = nums.length;
        Integer[] sorted = new Integer[n];
        for(int i = 0; i < n; i++) sorted[i] = nums[i];

        // 1) Sort Array : After below operation, nums = [18, 43, 34, 16], sorted = [16, 34, 43, 18]
        Arrays.sort(sorted, (a , b) ->{
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if(sumA == sumB) return a - b;
            return sumA - sumB;
        });
        
        // 2) Map of sorted value -> new index [16 -> 0, 34 -> 1, 43 -> 2, 18 -> 3]
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(sorted[i], i);
        }

        // 3) Cycle Detection Algorithm
        boolean[] seen = new boolean[n];
        int swaps = 0;
        for(int i = 0; i < n; i++){
            if(seen[i] || map.get(nums[i]) == i) continue;

            int cycleLen = 0, j = i;
            while(!seen[j]){
                seen[j] = true;
                j = map.get(nums[j]);
                cycleLen++;
            }
            swaps += cycleLen - 1;
        }
        return swaps;
    }
}