class Solution {
    public int helper(String s, int i, HashSet<String> set){
        if(i == s.length()) return 0;

        int result = 0;
        for(int j = i; j < s.length(); j++){
            String subStr = s.substring(i, j + 1);
            
            if(!set.contains(subStr)){
                set.add(subStr);
                result = Math.max(result, 1 + helper(s, j + 1, set));
                set.remove(subStr);
            }
        }
        return result;
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return helper(s, 0, set);
    }
}