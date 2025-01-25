class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            int key = mp.getValue();
            int value = mp.getKey();
            if(bucket[key] == null){
                bucket[key] = new ArrayList<>();
            }
            bucket[key].add(value);
        }
        int[] ans = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i >= 0 ; i--){
            if (bucket[i] != null) {
                for(int j = 0; j < bucket[i].size() && index < k; j++){
                    ans[index++] = bucket[i].get(j);
                    if(index == k) break;
                }
            }
        }
        return ans;
    }
}