// import java.util.Arrays;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] sChars = s.toCharArray();
//         char[] tChars = t.toCharArray();
        
//         Arrays.sort(sChars);
//         Arrays.sort(tChars);
        
//         return Arrays.equals(sChars, tChars);
//     }
// }

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()) return false;
//         Map<Character, Integer> map = new HashMap();
//         for(int i = 0; i < s.length(); i++){
//             map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//             map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
//         }
//         for(int count : map.values()){
//             if(count!=0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }


class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }
        
        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}