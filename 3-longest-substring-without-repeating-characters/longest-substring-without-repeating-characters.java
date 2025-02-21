class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 0;
        int left = 0, right = 0;

        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left += 1;
            }
            set.add(s.charAt(right));
            result = Integer.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}