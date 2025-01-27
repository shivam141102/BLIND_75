// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if(nums.length == 0) return 0;
//         Arrays.sort(nums);
//         int result = 1;
//         int cnt = 1;
//         for(int i = 1; i < nums.length; i++){
//             if(nums[i] - 1 == nums[i-1]){
//                 cnt++;
//             }
//             else if(nums[i] == nums[i-1]){
//                 continue;
//             }
//             else{
//                 result = Math.max(result, cnt);
//                 cnt = 1;
//             }
//         }
//         return Math.max(result, cnt);
//     }
// }

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int result = 1;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int cnt = 1;
                while(set.contains(num + 1)){
                    set.remove(num + 1);
                    cnt++;
                    num++;
                }
                result = Math.max(result, cnt);
            }
        }
        return result;
    }
}