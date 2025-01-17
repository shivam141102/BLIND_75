class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            int tar = target - nums[i];
            if(map.containsKey(tar)){
                result[0] = map.get(tar);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}