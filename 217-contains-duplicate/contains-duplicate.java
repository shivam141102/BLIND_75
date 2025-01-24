// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         int n = nums.length;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] == nums[j])
//                     return true;
//             }
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         for (int i = 1; i < n; i++) {
//             if (nums[i] == nums[i - 1])
//                 return true;
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashSet<Integer> seen = new HashSet<>();
//         for (int num : nums) {
//             if (seen.contains(num))
//                 return true;
//             seen.add(num);
//         }
//         return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num: nums){
            if(map.containsKey(num)){
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}