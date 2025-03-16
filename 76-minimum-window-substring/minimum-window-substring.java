class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
                
        int left = 0; 
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int have = 0;
        int need = countT.size();

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have += 1;
            }

            while(have == need){
                int windowSize = right - left + 1;
                if(windowSize < resLen){
                    res[0] = left;
                    res[1] = right;
                    resLen = windowSize;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}